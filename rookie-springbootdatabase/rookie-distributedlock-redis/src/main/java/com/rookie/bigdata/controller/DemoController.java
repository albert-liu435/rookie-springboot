package com.rookie.bigdata.controller;

import com.rookie.bigdata.service.RedisLock;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Class DemoController
 * @Description
 * @Author rookie
 * @Date 2024/8/19 13:42
 * @Version 1.0
 */
@RestController
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("redisLock")
    @Transactional(rollbackFor = Exception.class)
    public String testLock() throws Exception {

        String threadId ="ab";
        Boolean success = redisTemplate.opsForValue()
                .setIfAbsent(1 + "a", threadId, 1, TimeUnit.SECONDS);
        logger.debug("进入testLock()方法;");
        try (RedisLock redisLock = new RedisLock(redisTemplate,"redisKey",30)){
            if (redisLock.getLock()) {
                logger.debug("获取到分布式锁；");
                Thread.sleep(20 * 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug("方法执行完成；");
        return "方法执行完成";
    }

}
