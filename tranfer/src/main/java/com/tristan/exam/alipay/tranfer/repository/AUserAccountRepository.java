package com.tristan.exam.alipay.tranfer.repository;

import com.tristan.exam.alipay.tranfer.model.item.UserAccountAItem;
import org.springframework.data.repository.CrudRepository;

/**
 * @program: alipay
 * @description: A数据库的user_account访问
 * @author: Tristan.Xi
 * @create: 2020-07-01 13:38
 **/
public interface AUserAccountRepository extends CrudRepository<UserAccountAItem, Long> {
}
