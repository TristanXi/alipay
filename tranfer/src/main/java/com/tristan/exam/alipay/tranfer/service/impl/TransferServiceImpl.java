package com.tristan.exam.alipay.tranfer.service.impl;

import com.tristan.exam.alipay.tranfer.annotation.Compensable;
import com.tristan.exam.alipay.tranfer.exception.IllegalUserException;
import com.tristan.exam.alipay.tranfer.exception.NotEnoughBalanceException;
import com.tristan.exam.alipay.tranfer.exception.SamePersonTransferException;
import com.tristan.exam.alipay.tranfer.exception.UserNotFoundException;
import com.tristan.exam.alipay.tranfer.model.UserAccountInfo;
import com.tristan.exam.alipay.tranfer.model.enums.AccountStatus;
import com.tristan.exam.alipay.tranfer.model.item.UserAccountAItem;
import com.tristan.exam.alipay.tranfer.service.TransferService;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;

/**
 * @program: alipay
 * @description: 转账服务
 * @author: Tristan.Xi
 * @create: 2020-07-01 13:30
 **/
public class TransferServiceImpl implements TransferService{

    @Compensable(confirmMethod = "transferConfirm", cancelMethod = "transferCancel")
    @Transactional
    public void transfer(long fromAccountId, long toAccountId, long amount) throws Exception{

        UserAccountInfo fromUser = getItem(fromAccountId);
        UserAccountInfo toUser = getItem(toAccountId);
        if(fromUser == null || toUser == null){
            throw new UserNotFoundException();
        }
        transfer(fromUser,toUser,amount);
    }

    @Compensable(confirmMethod = "transferConfirm", cancelMethod = "transferCancel")
    @Transactional
    @Override
    public void transfer(UserAccountInfo fromUser, UserAccountInfo toUser, long amount) throws Exception {
        checkUser(fromUser,toUser,amount);
        fromUser.setStatus(AccountStatus.TRANSFERING.getId());

        fromUser.setBalance(fromUser.getBalance() - amount);
        saveItem(fromUser);

        toUser.setStatus(AccountStatus.TRANSFERING.getId());
        toUser.setBalance(toUser.getBalance() + amount);
        saveItem(toUser);
    }

    public void transferConfirm(long fromAccountId, long toAccountId, long amount) {
        System.out.println("transferConfirm called");
        UserAccountInfo fromAccount = getItem(fromAccountId);
        fromAccount.setStatus(AccountStatus.NORMAL.getId());
        UserAccountInfo toAccount = getItem(toAccountId);
        toAccount.setStatus(AccountStatus.NORMAL.getId());
        saveItem(fromAccount);
        saveItem(toAccount);
    }

    public void transferCancel(long fromAccountId, long toAccountId, long amount) {

        UserAccountInfo fromUser = getItem(fromAccountId);
//        UserAccountInfo toUser = getItem(toAccountId)

        if (fromUser.getStatus() == AccountStatus.TRANSFERING.getId()) {
            fromUser.setBalance(fromUser.getBalance() + amount);
        }

        fromUser.setStatus(AccountStatus.NORMAL.getId());
        saveItem(fromUser);
    }

    private void checkUser(UserAccountInfo fromUser, UserAccountInfo toUser,long amount) throws Exception{
        if(amount <= 0){
            throw new IllegalArgumentException();
        }
        if(fromUser.equals(toUser)){
            throw new SamePersonTransferException();
        }
        if(fromUser.getBalance() < amount){
            throw new NotEnoughBalanceException();
        }
        if(fromUser.getStatus() != AccountStatus.NORMAL.getId() || toUser.getStatus() != AccountStatus.NORMAL.getId()){
            throw new IllegalUserException();
        }
        //远程调用用户
    }

    private UserAccountInfo getItem(long id){
        UserAccountInfo userAccountInfo = null;
        //根据id获取item，转换为UserAccountInfo
        return userAccountInfo;
    }

    private void saveItem(UserAccountInfo userAccountInfo){
        //根据id选择相应数据库存储
    }


}
