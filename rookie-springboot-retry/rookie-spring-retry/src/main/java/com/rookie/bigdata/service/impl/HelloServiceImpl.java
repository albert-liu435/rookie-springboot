package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @Class HelloServiceImpl
 * @Description
 * @Author rookie
 * @Date 2023/12/28 17:42
 * @Version 1.0
 */
@Service
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Override
    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 1.5))
    public String hello(String username) {
        log.debug("hello,{}", username);
        int random = (int) (Math.random() * 30);
        if (random % 4 != 0) {
            throw new RuntimeException("error");
        }
        return "hello world," + username;
    }
}

