package com.rookie.bigdata.util;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * @Class RateLimiterDemo
 * @Description
 * @Author rookie
 * @Date 2024/8/20 9:04
 * @Version 1.0
 */
public class RateLimiterDemo {

    public static void main(String[] args) {
        RateLimiterDemo.testNonBlock();
    }

    /**
     * 平滑突发限流，
     * 1、以固定的速率生成令牌
     * 2、RateLimiter使用令牌桶算法，会进行令牌的累积，如果获取令牌的频率比较低，则不会导致等待，直接获取令牌。
     * 3、RateLimiter在没有足够令牌发放时，采用滞后处理的方式，也就是前一个请求获取令牌所需等待的时间由下一次请求来承受，也就是代替前一个请求进行等待。
     */
    public static void testSmoothBursty() {
        RateLimiter r = RateLimiter.create(1);

        RateLimiterDemo.getTokenByNewThread(10, 2, 1, r);
    }

    /**
     * 平滑预热限流，带有预热期的平滑限流，即它启动后会有一段预热期，逐步将分发频率提升到配置的速率。
     */
    public static void testSmoothwarmingUp() {
        RateLimiter r = RateLimiter.create(2, 3, TimeUnit.SECONDS);
        RateLimiterDemo.getTokenByNewThread(1, 2, 8, r);
    }

    public static void testNonBlock() {
        RateLimiter r = RateLimiter.create(2);
        while (true) {
            try {
                Thread.sleep(500 * 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Calendar.getInstance().getTime() + "get tokens: " + r.tryAcquire(3) + "s");
        }
    }

    /**
     * 多线程，消耗令牌
     *
     * @param threadNum 线程数量
     * @param tokenNum  每个线程一次消耗的令牌数
     * @param count     获取几次令牌
     * @param r         限流对象
     */
    public static void getTokenByNewThread(int threadNum, int tokenNum, int count, RateLimiter r) {

        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int k = 0; k < count; k++) {
                        System.out.println(Calendar.getInstance().getTime() + " " + Thread.currentThread().getName()
                                + " get tokens: " + r.acquire());
                    }
                }
            }).start();
        }
    }
}
