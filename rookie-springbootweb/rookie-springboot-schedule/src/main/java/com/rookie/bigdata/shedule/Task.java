package com.rookie.bigdata.shedule;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Classname Task
 * @Description
 * @Author rookie
 * @Date 2018/09/24 16:10
 * @Version 1.0
 */
@Component
public class Task {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Scheduled(cron = "0 10-15 16 * * ?")
    public void task0() {
        System.out.println("执行时间： " + dateFormat.format(new Date()));


    }


    /**
     * 指定间隔调度任务，指在该任务完成后的间隔
     */
    @Scheduled(fixedDelay = 5000)
    public void task1() {
        System.out.println("执行时间： " + dateFormat.format(new Date()));
    }


    /**
     * 指定间隔调度任务,参考fixedDelay,单位为毫秒
     */
    @Scheduled(fixedDelayString = "5000")
    public void task2() {
        System.out.println("执行时间： " + dateFormat.format(new Date()));
    }

    /**
     * fixedRate:执行频率，每隔多少时间就启动任务，不管该任务是否启动完成参考fixedRate
     */
    @Scheduled(fixedRate = 5000)
    public void task3() {
        System.out.println("执行时间： " + dateFormat.format(new Date()));
    }

    /**
     * 参考fixedRate
     */
    @Scheduled(fixedDelayString = "5000")
    public void task4() {
        System.out.println("执行时间： " + dateFormat.format(new Date()));
    }

    /**
     * 参考fixedRate
     */
    @Scheduled(fixedRateString = "5000")
    public void task5() {
        System.out.println("执行时间： " + dateFormat.format(new Date()));
    }


}