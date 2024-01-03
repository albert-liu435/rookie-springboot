package com.rookie.bigdata.retry.callback;

/**
 * @Class RetryCallback
 * @Description TODO
 * @Author rookie
 * @Date 2024/1/2 14:17
 * @Version 1.0
 */
public interface RetryCallback<T, E extends Throwable> {

    /**
     * 重试
     * @param context
     * @return
     * @throws E
     */
    T doWithRetry(RetryContext context) throws E;

}
