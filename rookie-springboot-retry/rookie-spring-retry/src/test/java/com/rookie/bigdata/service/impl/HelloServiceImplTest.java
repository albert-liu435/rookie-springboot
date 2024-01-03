package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.RetryOperations;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class HelloServiceImplTest
 * @Description
 * @Author rookie
 * @Date 2023/12/28 17:43
 * @Version 1.0
 */
@SpringBootTest
class HelloServiceImplTest {

    @Autowired
    private HelloService helloService;

    @Test
    void hello() {

        String hello = helloService.hello("spring-retry");
        System.out.println(hello);
    }
}
