package com.rookie.bigdata.algorithm;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Class TokenBucket
 * @Description TODO
 * @Author rookie
 * @Date 2024/8/20 11:41
 * @Version 1.0
 */
public class TokenBucket {
    private final long capacity;
    private final long refillRate;
    private AtomicLong tokens;
    private long lastRefillTimestamp;

    public TokenBucket(long capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = new AtomicLong(capacity);
        this.lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean tryConsume(long numTokens) {
        refill();
        if (tokens.get() >= numTokens) {
            tokens.addAndGet(-numTokens);
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        long tokensToAdd = (now - lastRefillTimestamp) * refillRate / 1_000_000_000;
        if (tokensToAdd > 0) {
            tokens.getAndAdd(Math.min(tokensToAdd, capacity - tokens.get()));
            lastRefillTimestamp = now;
        }
    }
}

