package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName AopApplication
 * @Description AopApplication
 * @Author rookie
 * @Date 2021/6/17 16:10
 * @Version 1.0
 */
@SpringBootApplication
public class FilterApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(FilterApplication.class);
        springApplication.run(args);

    }
}
