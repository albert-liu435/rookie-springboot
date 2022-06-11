package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName AopApplication
 * @Description AopApplication
 * @Author rookie
 * @Date 2018/09/24 16:10
 * @Version 1.0
 */
@SpringBootApplication
//开启调度任务
@EnableScheduling
public class SheduleApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(SheduleApplication.class);
        springApplication.run(args);

    }
}
