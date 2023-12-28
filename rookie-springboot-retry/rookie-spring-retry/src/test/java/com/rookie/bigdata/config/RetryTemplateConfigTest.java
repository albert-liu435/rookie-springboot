package com.rookie.bigdata.config;

import com.rookie.bigdata.service.RetryTemplateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class RetryTemplateConfigTest
 * @Description
 * @Author rookie
 * @Date 2023/12/28 17:07
 * @Version 1.0
 */
@SpringBootTest
class RetryTemplateConfigTest {

    @Autowired
    private RetryTemplate retryTemplate;

    @Autowired
    private RetryTemplateService retryTemplateService;

    @Test
    void test1() throws IllegalAccessException {
        retryTemplate.execute(new RetryCallback<Object, IllegalAccessException>() {
            @Override
            public Object doWithRetry(RetryContext context) throws IllegalAccessException {
                retryTemplateService.service1();
                return null;
            }
        });
    }

    @Test
    void test2() throws IllegalAccessException {
        retryTemplate.execute(new RetryCallback<Object, IllegalAccessException>() {
            @Override
            public Object doWithRetry(RetryContext context) throws IllegalAccessException {
                retryTemplateService.service1();
                return null;
            }
        }, new RecoveryCallback<Object>() {
            @Override
            public Object recover(RetryContext context) throws Exception {
//                log.info("RecoveryCallback....");
                System.out.println("RecoveryCallback....");
                return null;
            }
        });
    }
}
