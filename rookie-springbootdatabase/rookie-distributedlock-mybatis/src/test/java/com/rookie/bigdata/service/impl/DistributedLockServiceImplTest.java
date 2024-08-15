package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.service.DistributedLockService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class DistributedLockServiceImplTest
 * @Description
 * @Author rookie
 * @Date 2024/8/15 10:59
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
@Slf4j
class DistributedLockServiceImplTest {

    @Autowired
    private DistributedLockService distributedLockService;

    @Test
    void tryLock() {

        boolean order = distributedLockService.tryLock("order");
        log.info("获取order锁：{}",order);
    }
}
