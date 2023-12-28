package com.rookie.bigdata.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Class RetryTemplateService
 * @Description
 * @Author rookie
 * @Date 2023/12/28 17:08
 * @Version 1.0
 */
@Service
@Slf4j
public class RetryTemplateService {

    public void service1() throws IllegalAccessException {
        log.info("do something...");
        throw new IllegalAccessException();
    }
}
