package com.rookie.bigdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ESApplication
 * @Description 参考 https://github.com/mybatis/spring-boot-starter
 * https://blog.csdn.net/m0_65563175/article/details/127354442
 * @Author rookie
 * @Date 2021/6/29 16:37
 * @Version 1.0
 */
@MapperScan("com.rookie.bigdata.mapper")
@SpringBootApplication
public class SpringMybatisApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringMybatisApplication.class, args);
    }
}
