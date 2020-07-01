package com.tristan.exam.alipay.tranfer.model;


import com.tristan.exam.alipay.tranfer.model.enums.AccountStatus;

import java.io.Serializable;

/**
 * @program: alipay
 * @description: 账户信息
 * @author: Tristan.Xi
 * @create: 2020-06-30 22:41
 **/
public class UserAccountInfo implements Serializable {
    private Long uid;

    private Long balance;

    private Long frozonBalance;

    private volatile int status = AccountStatus.NORMAL.getId();

    private String updateTime;

    private String createTime;

    private static final long serialVersionUID = 1L;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getFrozonBalance() {
        return frozonBalance;
    }

    public void setFrozonBalance(Long frozonBalance) {
        this.frozonBalance = frozonBalance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}

