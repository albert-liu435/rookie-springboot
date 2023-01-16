package com.rookie.bigdata.controller;

import com.rookie.bigdata.redisson.RedissonLock;
import com.rookie.bigdata.redisson.annotation.DistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname AnnotatinLockController
 * @Description 基于注解的方式 加锁基于注解的方式 加锁
 * @Author rookie
 * @Date 2023/1/16 11:31
 * @Version 1.0
 */
@RestController
@Slf4j
public class AnnotatinLockController {

    @Autowired
    RedissonLock redissonLock;

    /**
     * 模拟这个是商品库存
     */
    public static volatile Integer TOTAL = 10;

    @GetMapping("annotatin-lock-decrease-stock")
    @DistributedLock(value="goods", leaseTime=5)
    public String lockDecreaseStock() throws InterruptedException {
        if (TOTAL > 0) {
            TOTAL--;
        }
        log.info("===注解模式=== 减完库存后,当前库存===" + TOTAL);
        return "=================================";
    }
}

