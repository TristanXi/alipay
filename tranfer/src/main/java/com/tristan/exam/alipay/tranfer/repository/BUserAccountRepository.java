package com.tristan.exam.alipay.tranfer.repository;

import com.tristan.exam.alipay.tranfer.model.item.UserAccountBItem;
import org.springframework.data.repository.CrudRepository;

/**
 * @program: alipay
 * @description: B数据库的user_account访问
 * @author: Tristan.Xi
 * @create: 2020-07-01 13:38
 **/
public interface BUserAccountRepository extends CrudRepository<UserAccountBItem, Long> {
}
