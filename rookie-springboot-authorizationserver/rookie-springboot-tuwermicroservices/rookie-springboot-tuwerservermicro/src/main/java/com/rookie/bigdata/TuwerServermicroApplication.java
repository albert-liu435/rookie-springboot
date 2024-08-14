package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName TuwerServermicroApplication
 * @Description TuwerServermicroApplication
 * @Author rookie
 * @Date 2021/6/17 16:10
 * @Version 1.0
 */
@SpringBootApplication
public class TuwerServermicroApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(TuwerServermicroApplication.class);
        springApplication.run(args);

    }
}
