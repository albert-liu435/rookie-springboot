package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName SwaggerApplication
 * @Description SwaggerApplication  访问http://localhost:8085/swagger-ui.html进行测试
 * @Author rookie
 * @Date 2021/6/25 11:22
 * @Version 1.0
 */
@SpringBootApplication
public class SwaggerApplication {

    public static void main(String[] args) {

        SpringApplication.run(SwaggerApplication.class, args);

    }
}
