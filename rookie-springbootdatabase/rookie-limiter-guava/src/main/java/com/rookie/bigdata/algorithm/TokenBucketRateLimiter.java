package com.rookie.bigdata.algorithm;

/**
 * @Class TokenBucketRateLimiter
 * @Description
 * @Author rookie
 * @Date 2024/8/20 9:36
 * @Version 1.0
 */
public class TokenBucketRateLimiter {
    /**
     * 桶的最大容量
     */
    public long capacity = 10;
    /**
     * 桶内当前的令牌数量
     */
    public long count = 0;
    /**
     * 令牌生成速率（每秒5次）
     */
    public long tokenRate = 5;
    /**
     * 上次生成令牌的时间
     */
    public long lastGenerateTime = System.currentTimeMillis();

    /**
     * 限流方法，返回true表示通过
     */
    public boolean limit() {
        // 调用生成令牌方法
        this.generateTokens();
        // 判断桶内是否还有令牌
        if (count > 0) {
            count--;
            return true;
        }
        return false;
    }

    /**
     * 生成令牌方法，计算并更新这段时间内生成的令牌数量
     */
    private void generateTokens() {
        long currentTime = System.currentTimeMillis();
        // 计算这段时间内，需要生成的令牌数量
        long tokens = (currentTime - lastGenerateTime) * tokenRate / 1000;
        count = Math.min(count + tokens, capacity);
        lastGenerateTime = currentTime;
    }
}
