package com.rookie.bigdata.algorithm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Class CounterLimiter
 * @Description
 * @Author rookie
 * @Date 2024/8/20 11:43
 * @Version 1.0
 */
public class CounterLimiter {
    private final int limit;
    private final long interval;
    private AtomicInteger counter;
    private long startTime;

    public CounterLimiter(int limit, long interval) {
        this.limit = limit;
        this.interval = interval;
        this.counter = new AtomicInteger(0);
        this.startTime = System.nanoTime();
    }

    public synchronized boolean tryConsume() {
        long now = System.nanoTime();
        if (now - startTime > interval) {
            counter.set(0);
            startTime = now;
        }
        if (counter.incrementAndGet() <= limit) {
            return true;
        }
        return false;
    }
}
