package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName TuwerMicroResource01Application
 * @Description TuwerMicroResource01Application
 * @Author rookie
 * @Date 2021/6/18 10:14
 * @Version 1.0
 */
@SpringBootApplication
public class TuwerMicroResource01Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TuwerMicroResource01Application.class);
        springApplication.run(args);
    }

}
