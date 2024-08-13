package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaServerApplication
 * @Description EurekaServerApplication
 * @Author rookie
 * @Date 2021/6/18 10:14
 * @Version 1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(EurekaServerApplication.class);
        springApplication.run(args);
    }

}
