package com.tristan.exam.alipay.tranfer.service;

import com.tristan.exam.alipay.tranfer.model.UserAccountInfo;
import org.springframework.stereotype.Service;

@Service
public interface TransferService {

    public void transfer(long fromAccountId, long toAccountId, long amount) throws Exception;

    public void transfer(UserAccountInfo fromUser, UserAccountInfo toUser, long amount) throws Exception;
}
