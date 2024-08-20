package com.rookie.bigdata.algorithm;

import java.util.concurrent.LinkedBlockingQueue;
/**
 * @Class LeakyBucket
 * @Description
 * @Author rookie
 * @Date 2024/8/20 11:42
 * @Version 1.0
 */

public class LeakyBucket {
    private final int capacity;
    private final long leakRate;
    private final LinkedBlockingQueue<Long> bucket;
    private long lastLeakTimestamp;

    public LeakyBucket(int capacity, long leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.bucket = new LinkedBlockingQueue<>(capacity);
        this.lastLeakTimestamp = System.nanoTime();
    }

    public synchronized boolean tryConsume() {
        leak();
        if (bucket.remainingCapacity() > 0) {
            bucket.offer(System.nanoTime());
            return true;
        }
        return false;
    }

    private void leak() {
        long now = System.nanoTime();
        long numLeaks = (now - lastLeakTimestamp) * leakRate / 1_000_000_000;
        for (long i = 0; i < numLeaks && !bucket.isEmpty(); i++) {
            bucket.poll();
        }
        lastLeakTimestamp = now;
    }
}
