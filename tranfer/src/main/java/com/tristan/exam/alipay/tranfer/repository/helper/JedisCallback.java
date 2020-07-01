package com.tristan.exam.alipay.tranfer.repository.helper;

import redis.clients.jedis.Jedis;

/**
 * Created by changming.xie on 9/15/16.
 */
public interface JedisCallback<T> {

    public T doInJedis(Jedis jedis);
}