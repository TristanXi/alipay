package com.tristan.exam.alipay.tranfer.serializer;

import com.tristan.exam.alipay.tranfer.model.Transaction;
import org.apache.commons.lang3.SerializationUtils;

/**
 * Created by changming.xie on 7/22/16.
 */
public class JdkSerializationSerializer implements ObjectSerializer<Transaction> {

    @Override
    public byte[] serialize(Transaction object) {
        return SerializationUtils.serialize(object);
    }

    @Override
    public Transaction deserialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        } else {
            return (Transaction) SerializationUtils.deserialize(bytes);
        }
    }

    @Override
    public Transaction clone(Transaction object) {
        return SerializationUtils.clone(object);
    }
}
