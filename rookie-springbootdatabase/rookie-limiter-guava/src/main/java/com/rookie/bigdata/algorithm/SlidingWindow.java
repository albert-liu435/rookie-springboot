package com.rookie.bigdata.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Class SlidingWindow
 * @Description
 * @Author rookie
 * @Date 2024/8/20 11:43
 * @Version 1.0
 */
public class SlidingWindow {
    private final int limit;
    private final long windowSize;
    private final Queue<Long> timestamps;

    public SlidingWindow(int limit, long windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
        this.timestamps = new LinkedList<>();
    }

    public synchronized boolean tryConsume() {
        long now = System.nanoTime();
        long boundary = now - windowSize;
        while (!timestamps.isEmpty() && timestamps.peek() < boundary) {
            timestamps.poll();
        }
        if (timestamps.size() < limit) {
            timestamps.offer(now);
            return true;
        }
        return false;
    }
}
