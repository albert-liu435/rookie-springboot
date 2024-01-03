package com.rookie.bigdata.retry.callback.executor;

import com.rookie.bigdata.retry.callback.RetryContext;

/**
 * @Class AsyncFilter
 * @Description TODO
 * @Author rookie
 * @Date 2024/1/2 14:18
 * @Version 1.0
 */
@FunctionalInterface
public interface AsyncFilter {

    /**
     * 过滤
     * @return
     */
    boolean filter(RetryContext retryContext);
}
