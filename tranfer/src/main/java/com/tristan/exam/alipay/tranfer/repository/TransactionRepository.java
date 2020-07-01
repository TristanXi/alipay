package com.tristan.exam.alipay.tranfer.repository;

import com.tristan.exam.alipay.tranfer.model.Transaction;
import com.tristan.exam.alipay.tranfer.model.TransactionXid;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by changmingxie on 11/12/15.
 */

@Service
public interface TransactionRepository {

    int create(Transaction transaction);

    int update(Transaction transaction);

    int delete(Transaction transaction);

    Transaction findByXid(TransactionXid xid);

    List<Transaction> findAllUnmodifiedSince(Date date);
}
