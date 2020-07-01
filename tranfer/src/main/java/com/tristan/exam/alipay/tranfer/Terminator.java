package com.tristan.exam.alipay.tranfer;

import com.tristan.exam.alipay.tranfer.exception.SystemException;
import com.tristan.exam.alipay.tranfer.model.InvocationContext;
import com.tristan.exam.alipay.tranfer.model.TransactionContext;

import com.tristan.exam.alipay.tranfer.annotation.TransactionContextEditor;
import org.junit.platform.commons.util.StringUtils;

import java.lang.reflect.Method;

/**
 * Created by changmingxie on 10/30/15.
 */
public final class Terminator {

    public Terminator() {

    }

    public static Object invoke(TransactionContext transactionContext, InvocationContext invocationContext, Class<? extends TransactionContextEditor> transactionContextEditorClass) {


        if (!StringUtils.isBlank(invocationContext.getMethodName())) {

            try {

                Object target = FactoryBuilder.factoryOf(invocationContext.getTargetClass()).getInstance();

                Method method = null;

                method = target.getClass().getMethod(invocationContext.getMethodName(), invocationContext.getParameterTypes());

                FactoryBuilder.factoryOf(transactionContextEditorClass).getInstance().set(transactionContext, target, method, invocationContext.getArgs());

                return method.invoke(target, invocationContext.getArgs());

            } catch (Exception e) {
                throw new SystemException(e);
            }
        }
        return null;
    }
}
