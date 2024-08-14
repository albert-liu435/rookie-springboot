package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName TuwerClientMicroApplication
 * @Description TuwerClientMicroApplication
 * @Author rookie
 * @Date 2021/6/18 10:14
 * @Version 1.0
 */
@SpringBootApplication
public class TuwerClientMicroApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TuwerClientMicroApplication.class);
        springApplication.run(args);
    }

}
