package com.rookie.bigdata.retry.callback;

/**
 * @Class SimpleRecoveryCallback
 * @Description TODO
 * @Author rookie
 * @Date 2024/1/2 14:19
 * @Version 1.0
 */
public class SimpleRecoveryCallback implements RecoveryCallback<Object>{


    @Override
    public Object recover(RetryContext retryContext) throws Exception {
        return "retry count: " + (retryContext.getRetryCount() + 1) + " please handle";
    }
}
