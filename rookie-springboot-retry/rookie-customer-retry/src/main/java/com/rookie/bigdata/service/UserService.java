package com.rookie.bigdata.service;

import com.rookie.bigdata.retry.annotation.Retryable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @Class UserService
 * @Description TODO
 * @Author rookie
 * @Date 2024/1/2 14:20
 * @Version 1.0
 */
@Service
public class UserService {

    private int total = 10;

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public void say(){

    }

    @Retryable(value = Exception.class, maxAttempts = 5, async = true)
    public int runTask(int count){
        logger.info("开始扣减库存：" + LocalDateTime.now());

        try {
            int i = 1 / 0;
        } catch (Exception e) {
            logger.error("发生了异常");
        }

        if (count < 0) {
            throw new IllegalArgumentException("数量不对");
        }

        logger.info("结束扣减库存：" + LocalDateTime.now());

        logger.info("剩余库存：{}", (total - count));

        return total - count;
    }
}
