package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName CorsApplication
 * @Description CorsApplication
 * @Author rookie
 * @Date 2021/6/18 10:14
 * @Version 1.0
 */
@SpringBootApplication
public class CorsApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(CorsApplication.class);
        springApplication.run(args);
    }

}
