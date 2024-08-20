package com.rookie.bigdata.algorithm;

import java.util.concurrent.TimeUnit;

/**
 * @Class SlidingWindowLimiter
 * @Description 滑动窗口算法 https://blog.csdn.net/qq_33807380/article/details/135254515
 * @Author rookie
 * @Date 2024/8/20 9:23
 * @Version 1.0
 */
public class SlidingWindowLimiter {
    // 固定时间窗口大小，单位毫秒
    private long windowSize;
    // 固定窗口拆分的小窗口数
    private int windowNum;
    // 每个窗口允许通过最大请求数
    private int maxRequestCount;
    // 各个窗口内请求计数
    private int[] perWindowCount;
    // 请求总数
    private int totalCount;
    // 当前窗口下标
    private int windowId;
    // 每个小窗口大小，毫秒
    private long perWindowSize;
    // 窗口右边界
    private long windowRightBorder;

    /**
     * 构造函数
     *
     * @param windowSize      固定时间窗口大小
     * @param windowNum       固定窗口拆分的小窗口数
     * @param maxRequestCount 每个窗口允许通过最大请求数
     */
    public SlidingWindowLimiter(long windowSize, int windowNum, int maxRequestCount) {
        this.windowSize = windowSize;
        this.windowNum = windowNum;
        this.maxRequestCount = maxRequestCount;
        perWindowCount = new int[windowNum];
        perWindowSize = windowSize / windowNum;
        windowRightBorder = System.currentTimeMillis();
    }

    /**
     * 限流方法
     *
     * @return
     */
    public synchronized boolean tryAcquire() {
        //当前时间
        long currentTime = System.currentTimeMillis();
        //当前时间大于窗口右边界
        if (currentTime > windowRightBorder) {

            //移动窗口的时候将第一个窗口的数据减去
            do {
                //窗口index
                windowId = (++windowId) % windowNum;
                //总的数量减去请求的窗口数量
                totalCount -= perWindowCount[windowId];
                //将请求窗口数量设置为0
                perWindowCount[windowId] = 0;
                //窗口的由边界进行滑动
                windowRightBorder += perWindowSize;
            } while (windowRightBorder < currentTime);
        }

        if (totalCount < maxRequestCount) {
            System.out.println("tryAcquire success,{}" + windowId);
            perWindowCount[windowId]++;
            totalCount++;
            return true;
        } else {
            System.out.println("tryAcquire fail,{}" + windowId);
            return false;
        }
    }

    /**
     * 测试方法
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        SlidingWindowLimiter slidingWindowLimiter = new SlidingWindowLimiter(1000, 10, 10);
        TimeUnit.MILLISECONDS.sleep(800);
        for (int i = 0; i < 15; i++) {
            boolean acquire = slidingWindowLimiter.tryAcquire();
            if (acquire) {
                System.out.println("执行任务");
            } else {
                System.out.println("被限流");
            }
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }


//    优点：
//
//可以根据业务需求灵活调整窗口的大小和时间间隔，实现更加精细的限流控制。
//解决了固定窗口算法的窗口边界问题，避免突发流量压垮服务器。
//缺点：
//
//窗口的大小和时间间隔需要根据具体业务场景进行调整，实现较为复杂。
//需要统计窗口内的请求次数，计算较为复杂。
}
