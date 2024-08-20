package com.rookie.bigdata.algorithm;

/**
 * @Class FixWindowLimiter
 * @Description 固定窗口算法 https://blog.csdn.net/qq_33807380/article/details/135254515
 * @Author rookie
 * @Date 2024/8/20 9:15
 * @Version 1.0
 */
public class FixWindowLimiter {
    /**
     * 每秒限制请求数
     */
    private final long perSecondLimit = 50;
    /**
     * 上一个窗口的开始时间
     */
    public long preStartTime = System.currentTimeMillis();
    /**
     * 计数器
     */
    private int counter;

    public synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();
        // 假设窗口时间位1秒，在窗口期内判断计数器是否超过限制的请求数
        if (now - preStartTime < 1000) {
            // 计数器小于限制数时放行，否则拒绝请求
            if (counter < perSecondLimit) {
                counter++;
                return true;
            } else {
                return false;
            }
        }
        // 时间窗口过期，重置计数器和时间戳
        counter = 0;
        preStartTime = now;
        return true;
    }

    //优点:
    //  实现简单，容易理解
    //  适用于突发流量较小的场景
    //缺点：
    //  无法处理时间窗口的临界突变问题
    //  对于高并发场景,难以保证系统稳定性
    //  无法实现更加精细的限流控制

}
