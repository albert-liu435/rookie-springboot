package com.rookie.bigdata.retry.callback;

/**
 * @Class RecoveryCallback
 * @Description TODO
 * @Author rookie
 * @Date 2024/1/2 14:18
 * @Version 1.0
 */
public interface RecoveryCallback<T> {

    /**
     * 全部重试后，仍然失败了，是否需要进一步处理
     * @param retryContext
     * @return
     * @throws Exception
     */
    T recover(RetryContext retryContext) throws Exception;
}
