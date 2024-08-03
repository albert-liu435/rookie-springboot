package com.rookie.bigdata.retry.callback;

/**
 * @Class RetryOperations
 * @Description
 * @Author rookie
 * @Date 2024/1/2 14:15
 * @Version 1.0
 */
public interface RetryOperations {

    /**
     * Execute the supplied {@link RetryCallback} with the configured retry
     * semantics. See implementations for configuration details.
     *
     * @param <T>           the return value
     * @param retryCallback the {@link RetryCallback}
     * @param <E>           the exception to throw
     * @return the value returned by the {@link RetryCallback} upon successful
     * invocation.
     * @throws E any {@link Exception} raised by the
     *           {@link RetryCallback} upon unsuccessful retry.
     * @throws E the exception thrown
     */
    <T, E extends Throwable> T execute(RetryCallback<T, E> retryCallback) throws E;

    /**
     * execute with RecoverCallback
     * @param retryCallback
     * @param recoveryCallback
     * @param <T>
     * @param <E>
     * @return
     * @throws E
     */
    <T, E extends Throwable> T execute(RetryCallback<T, E> retryCallback, RecoveryCallback<T> recoveryCallback) throws E;
}
