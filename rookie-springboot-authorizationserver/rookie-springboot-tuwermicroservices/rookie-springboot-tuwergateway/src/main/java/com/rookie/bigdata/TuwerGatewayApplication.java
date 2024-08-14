package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @ClassName TuwerGatewayApplication
 * @Description TuwerGatewayApplication
 * @Author rookie
 * @Date 2021/6/18 10:14
 * @Version 1.0
 */
//@EnableEurekaClient
//@EnableDiscoveryClient

@SpringBootApplication
public class TuwerGatewayApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TuwerGatewayApplication.class);
        springApplication.run(args);
    }

}
