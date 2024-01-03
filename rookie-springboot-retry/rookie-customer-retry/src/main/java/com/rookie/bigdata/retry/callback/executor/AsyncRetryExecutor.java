package com.rookie.bigdata.retry.callback.executor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Class AsyncRetryExecutor
 * @Description TODO
 * @Author rookie
 * @Date 2024/1/2 14:19
 * @Version 1.0
 */
public class AsyncRetryExecutor extends ThreadPoolTaskExecutor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return null;
    }
}
