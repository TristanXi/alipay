package com.tristan.exam.alipay.tranfer.utils;

import com.tristan.exam.alipay.tranfer.model.CompensableMethodContext;
import com.tristan.exam.alipay.tranfer.model.enums.Propagation;

/**
 * Created by changming.xie on 2/23/17.
 */
public class TransactionUtils {

    public static boolean isLegalTransactionContext(boolean isTransactionActive, CompensableMethodContext compensableMethodContext) {


        if (compensableMethodContext.getPropagation().equals(Propagation.MANDATORY) && !isTransactionActive && compensableMethodContext.getTransactionContext() == null) {
            return false;
        }

        return true;
    }
}
