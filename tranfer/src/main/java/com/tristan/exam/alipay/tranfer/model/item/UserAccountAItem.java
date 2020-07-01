package com.tristan.exam.alipay.tranfer.model.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: alipay
 * @description: user_account in database A
 * @author: Tristan.Xi
 * @create: 2020-06-30 18:02
 **/

@Entity
@Table(name = "user_account")
public class UserAccountAItem {
    @Id
    private long id;


    private long uid;

    /**
     * 当前余额
     */
    private long currentBalance;

    /**
     * 冻结余额
     */
    private long frozenBalance;


    private String createTime;


    private String updateTime;

    private byte status;

}

