package com.rookie.bigdata.service;

import com.rookie.bigdata.exception.MyException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class RetryableServiceTest
 * @Description
 * @Author rookie
 * @Date 2023/12/28 16:07
 * @Version 1.0
 */

@SpringBootTest
class RetryableServiceTest {

    @Autowired
    private RetryableService retryableService;

    @Test
    void service() throws IllegalAccessException {

        retryableService.service();
    }

    @Test
    void service2() throws IllegalAccessException {

        retryableService.service2();
    }


    @Test
    void service3() throws IllegalAccessException {

        retryableService.service3();
    }

    @Test
    void service4() throws IllegalAccessException {

        retryableService.service4(" test 测试");
    }



    @Test
    void testService5() throws IllegalAccessException {
        retryableService.service5("test message");
    }

    @Test
    void testService5_1() throws IllegalAccessException {
        retryableService.service5_1("test message");
    }

    @Test
    void testService5_2() {
        retryableService.service5_2("test message");
    }

    @Test
    void testService5_3() {
        retryableService.service5_3("test message");
    }

    @Test
    void testService5_4() throws MyException {
        retryableService.service5_4("test message");
    }

    @Test
    void testService5_5() throws MyException {
        retryableService.service5_5("test message");
    }


    @Test
    void testService6() throws MyException {
        retryableService.service6("test message");
    }

    @Test
    void testService7() throws IllegalAccessException {
        retryableService.service7();
    }

    @Test
    void testService8() throws IllegalAccessException {
        retryableService.service8();
    }

    @Test
    void testService9() throws IllegalAccessException {
        retryableService.service9();
    }


    @Test
    void testService10() throws IllegalAccessException {
        retryableService.service10();
    }

    @Test
    void testService11() throws IllegalAccessException {
        retryableService.service11();
    }

    @Test
    void testService12() throws IllegalAccessException {
        retryableService.service12();
    }

    @Test
    void testService13() throws IllegalAccessException {
        retryableService.service13("test message!!");
    }



    @Test
    public void testCircuitBreaker() throws InterruptedException {
        System.err.println("尝试进入断路器方法，并触发异常...");
        retryableService.circuitBreaker(1);
        retryableService.circuitBreaker(1);
        retryableService.circuitBreaker(9);
        retryableService.circuitBreaker(9);
        System.err.println("在openTimeout 1秒之内重试次数为2次，未达到触发熔断, 断路器依然闭合...");
        TimeUnit.SECONDS.sleep(1);
        System.err.println("超过openTimeout 1秒之后, 因为未触发熔断，所以重试次数重置，可以正常访问...,继续重试3次方法...");
        retryableService.circuitBreaker(1);
        retryableService.circuitBreaker(1);
        retryableService.circuitBreaker(1);
        System.err.println("在openTimeout 1秒之内重试次数为3次，达到触发熔断，不会执行重试，只会执行恢复方法...");
        retryableService.circuitBreaker(1);
        TimeUnit.SECONDS.sleep(2);
        retryableService.circuitBreaker(9);
        TimeUnit.SECONDS.sleep(3);
        System.err.println("超过resetTimeout 3秒之后，断路器重新闭合...,可以正常访问");
        retryableService.circuitBreaker(9);
        retryableService.circuitBreaker(9);
        retryableService.circuitBreaker(9);
        retryableService.circuitBreaker(9);
        retryableService.circuitBreaker(9);

    }


}
