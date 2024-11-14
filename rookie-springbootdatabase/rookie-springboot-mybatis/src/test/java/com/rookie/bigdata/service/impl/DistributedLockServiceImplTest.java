package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.service.DistributedLockService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * @Class DistributedLockServiceImplTest
 * @Description
 * @Author rookie
 * @Date 2024/11/14 17:45
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
@Slf4j
class DistributedLockServiceImplTest {


    @Autowired
    private DistributedLockService distributedLockService;

    @Test
    void tryLock() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        List<Callable<String>> list = new ArrayList<>();
        for (int i = 1; i < 1000; i++) {

            list.add(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    boolean order = distributedLockService.tryLock("order");
                    log.info("获取锁成功或失败: {}", order);
                    return null;
                }
            });


        }

        executorService.invokeAll(list);
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                boolean order = distributedLockService.tryLock("order");
//                log.info("获取锁成功或失败: {}", order);
//            }
//        });


    }

    @Test
    void insert() {
    }
}
