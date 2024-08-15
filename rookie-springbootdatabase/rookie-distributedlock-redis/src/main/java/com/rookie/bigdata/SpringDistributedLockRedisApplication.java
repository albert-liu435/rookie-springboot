package com.rookie.bigdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName SpringDistributedLockRedisApplication
 * @Description 参考
 * @Author rookie
 * @Date 2021/6/29 16:37
 * @Version 1.0
 */
@MapperScan("com.rookie.bigdata.mapper")
@SpringBootApplication
public class SpringDistributedLockRedisApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringDistributedLockRedisApplication.class, args);
    }
}
