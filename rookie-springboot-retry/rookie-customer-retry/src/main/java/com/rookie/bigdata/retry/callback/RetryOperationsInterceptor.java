package com.rookie.bigdata.retry.callback;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ProxyMethodInvocation;

/**
 * @Class RetryOperationsInterceptor
 * @Description TODO
 * @Author rookie
 * @Date 2024/1/2 14:12
 * @Version 1.0
 */
public class RetryOperationsInterceptor implements MethodInterceptor {

    private RetryOperations retryOperations;

    public RetryOperations getRetryOperations() {
        return retryOperations;
    }

    public void setRetryOperations(RetryOperations retryOperations) {
        this.retryOperations = retryOperations;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        /**
         * 这里只是一个匿名函数,并没有触发里面的执行逻辑
         * 当
         */

        RetryCallback<Object, Throwable> retryCallback = new RetryCallback<Object, Throwable>() {
            @Override
            public Object doWithRetry(RetryContext context) throws Throwable {


                if (invocation instanceof ProxyMethodInvocation) {
                    try {
                        return ((ProxyMethodInvocation) invocation).invocableClone().proceed();
                    } catch (Exception | Error e) {
                        throw e;
                    } catch (Throwable e) {
                        throw new IllegalStateException(e);
                    }

                } else {
                    throw new IllegalStateException(
                            "MethodInvocation of the wrong type detected - this should not happen with Spring AOP, " +
                                    "so please raise an issue if you see this exception");
                }
            }
        };

        return retryOperations.execute(retryCallback);
    }
}
