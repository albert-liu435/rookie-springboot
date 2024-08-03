package com.rookie.bigdata.retry.callback;

/**
 * @Class RetryContext
 * @Description
 * @Author rookie
 * @Date 2024/1/2 14:17
 * @Version 1.0
 */
public interface RetryContext {

    /**
     * Retry context attribute that is non-null (and true) if the context has been closed.
     */
    String CLOSED = "context.closed";

    /**
     * Retry context attribute that is non-null (and true) if the recovery path was taken.
     */
    String RECOVERED = "context.recovered";

    /**
     * Accessor for the parent context if retry blocks are nested.
     *
     * @return the parent or null if there is none.
     */
    RetryContext getParent();

    /**
     * Counts the number of retry attempts. Before the first attempt this counter is zero,
     * and before the first and subsequent attempts it should increment accordingly.
     *
     * @return the number of retries.
     */
    int getRetryCount();

    /**
     * Accessor for the exception object that caused the current retry.
     *
     * @return the last exception that caused a retry, or possibly null. It will be null
     * if this is the first attempt, but also if the enclosing policy decides not to
     * provide it (e.g. because of concerns about memory usage).
     */
    Throwable getLastThrowable();

    void setAttribute(String name, Object value);
}
