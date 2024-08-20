package com.rookie.bigdata.algorithm;

/**
 * @Class LeakyBucketLimiter
 * @Description 漏桶算法    https://blog.csdn.net/qq_33807380/article/details/135254515
 * @Author rookie
 * @Date 2024/8/20 9:26
 * @Version 1.0
 */
public class LeakyBucketLimiter {
    /**
     * 桶的最大容量
     */
    public long capacity = 10;
    /**
     * 桶内当前水量
     */
    public long count = 0;
    /**
     * 漏水速率（每秒5次）
     */
    public long rate = 5;
    /**
     * 上次漏水时间
     */
    public static long lastLeakTime = System.currentTimeMillis();

    /**
     * 限流方法，返回true表示通过
     */
    public synchronized boolean tryAcquire() {
        // 调用漏水方法
        this.leak();
        // 判断是否超过最大请求数量
        if (count < capacity) {
            count++;
            return true;
        }
        return false;
    }

    /**
     * 漏水方法，计算并更新这段时间内漏水量
     */
    private void leak() {
        // 获取系统当前时间
        long currentTime = System.currentTimeMillis();
        // 计算这段时间内，需要流出的水量
        long leakWater = (currentTime - lastLeakTime) * rate / 1000;
        count = Math.max(count - leakWater, 0);
        lastLeakTime = currentTime;
    }

//    优点：
//
//可以限制请求的速率，并且不会出现过载的情况。
//可以实现较为精细的限流控制。
//缺点：
//
//如果入口流量过大，超过了桶的容量，那么就需要丢弃部分请求。
//由于速率是固定的，即使下游能够处理更大的流量，漏桶也不允许突发流量通过。
}

