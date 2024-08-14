package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName TuwerServerApplication
 * @Description TuwerServerApplication
 * @Author rookie
 * @Date 2021/6/17 16:10
 * @Version 1.0
 */
@SpringBootApplication
public class TuwerServerApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(TuwerServerApplication.class);
        springApplication.run(args);

    }
}
