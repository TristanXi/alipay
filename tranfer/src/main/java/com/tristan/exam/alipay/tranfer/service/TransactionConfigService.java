package com.tristan.exam.alipay.tranfer.service;

import com.tristan.exam.alipay.tranfer.TransactionManager;
import com.tristan.exam.alipay.tranfer.config.RecoverConfig;
import com.tristan.exam.alipay.tranfer.repository.TransactionRepository;
import org.springframework.stereotype.Service;


@Service
public interface TransactionConfigService {
    TransactionManager getTransactionManager();

    TransactionRepository getTransactionRepository();

    RecoverConfig getRecoverConfig();
}
