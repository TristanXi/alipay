package com.tristan.exam.alipay.tranfer.model.enums;

/**
 * Created by changmingxie on 12/3/15.
 */
public enum AccountStatus {

    NORMAL(1),

    TRANSFERING(2),

    FROZEN(3),

    ILLEGAL(4);

    private int id;

    AccountStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
