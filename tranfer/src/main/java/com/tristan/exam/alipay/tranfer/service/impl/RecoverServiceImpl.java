package com.tristan.exam.alipay.tranfer.service.impl;

import com.alibaba.fastjson.JSON;
import com.tristan.exam.alipay.tranfer.config.RecoverConfig;
import com.tristan.exam.alipay.tranfer.exception.OptimisticLockException;
import com.tristan.exam.alipay.tranfer.model.Transaction;
import com.tristan.exam.alipay.tranfer.model.enums.TransactionStatus;
import com.tristan.exam.alipay.tranfer.model.enums.TransactionType;
import com.tristan.exam.alipay.tranfer.recover.TransactionRecovery;
import com.tristan.exam.alipay.tranfer.repository.TransactionRepository;
import com.tristan.exam.alipay.tranfer.service.RecoverService;
import com.tristan.exam.alipay.tranfer.service.TransactionConfigService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @program: alipay
 * @description: 重试失败任务
 * @author: Tristan.Xi
 * @create: 2020-07-01 12:57
 **/

@Service
public class RecoverServiceImpl implements RecoverService{
    static final Logger logger = Logger.getLogger(TransactionRecovery.class.getSimpleName());

    @Autowired
    private TransactionConfigService transactionConfigService;

    @Override
    public void startRecover() {

        List<Transaction> transactions = loadErrorTransactions();

        recoverErrorTransactions(transactions);
    }

    private List<Transaction> loadErrorTransactions() {


        long currentTimeInMillis = Calendar.getInstance().getTimeInMillis();

        TransactionRepository transactionRepository = transactionConfigService.getTransactionRepository();
        RecoverConfig recoverConfig = transactionConfigService.getRecoverConfig();

        return transactionRepository.findAllUnmodifiedSince(new Date(currentTimeInMillis - recoverConfig.getRecoverDuration() * 1000));
    }

    private void recoverErrorTransactions(List<Transaction> transactions) {


        for (Transaction transaction : transactions) {

            if (transaction.getRetriedCount() > transactionConfigService.getRecoverConfig().getMaxRetryCount()) {

                logger.error(String.format("recover failed with max retry count,will not try again. txid:%s, status:%s,retried count:%d,transaction content:%s", transaction.getXid(), transaction.getStatus().getId(), transaction.getRetriedCount(), JSON.toJSONString(transaction)));
                continue;
            }

            if (transaction.getTransactionType().equals(TransactionType.BRANCH)
                    && (transaction.getCreateTime().getTime() +
                    transactionConfigService.getRecoverConfig().getMaxRetryCount() *
                            transactionConfigService.getRecoverConfig().getRecoverDuration() * 1000
                    > System.currentTimeMillis())) {
                continue;
            }

            try {
                transaction.addRetriedCount();

                if (transaction.getStatus().equals(TransactionStatus.CONFIRMING)) {

                    transaction.changeStatus(TransactionStatus.CONFIRMING);
                    transactionConfigService.getTransactionRepository().update(transaction);
                    transaction.commit();
                    transactionConfigService.getTransactionRepository().delete(transaction);

                } else if (transaction.getStatus().equals(TransactionStatus.CANCELLING)
                        || transaction.getTransactionType().equals(TransactionType.ROOT)) {

                    transaction.changeStatus(TransactionStatus.CANCELLING);
                    transactionConfigService.getTransactionRepository().update(transaction);
                    transaction.rollback();
                    transactionConfigService.getTransactionRepository().delete(transaction);
                }

            } catch (Throwable throwable) {

                if (throwable instanceof OptimisticLockException
                        || ExceptionUtils.getRootCause(throwable) instanceof OptimisticLockException) {
                    logger.warn(String.format("optimisticLockException happened while recover. txid:%s, status:%s,retried count:%d,transaction content:%s", transaction.getXid(), transaction.getStatus().getId(), transaction.getRetriedCount(), JSON.toJSONString(transaction)), throwable);
                } else {
                    logger.error(String.format("recover failed, txid:%s, status:%s,retried count:%d,transaction content:%s", transaction.getXid(), transaction.getStatus().getId(), transaction.getRetriedCount(), JSON.toJSONString(transaction)), throwable);
                }
            }
        }
    }
}
