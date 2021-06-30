package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ClassName RedisServiceImplTest
 * @Description RedisServiceImplTest
 * @Author rookie
 * @Date 2021/6/25 17:27
 * @Version 1.0
 */
@SpringBootTest
@ActiveProfiles("dev")
class RedisServiceImplTest {

    @Autowired
    private RedisService redisService;

    @Test
    void set() {
    }

    @Test
    void testSet() {

        redisService.set("a", "b");
    }

    @Test
    void get() {
    }

    @Test
    void del() {
    }

    @Test
    void testDel() {
    }

    @Test
    void expire() {
    }

    @Test
    void getExpire() {
    }

    @Test
    void hasKey() {
    }

    @Test
    void incr() {
    }

    @Test
    void decr() {
    }

    @Test
    void hGet() {
    }

    @Test
    void hSet() {
    }

    @Test
    void testHSet() {
    }

    @Test
    void hGetAll() {
    }

    @Test
    void hSetAll() {
    }

    @Test
    void testHSetAll() {
    }

    @Test
    void hDel() {
    }

    @Test
    void hHasKey() {
    }

    @Test
    void hIncr() {
    }

    @Test
    void hDecr() {
    }

    @Test
    void sMembers() {
    }

    @Test
    void sAdd() {
    }

    @Test
    void testSAdd() {
    }

    @Test
    void sIsMember() {
    }

    @Test
    void sSize() {
    }

    @Test
    void sRemove() {
    }

    @Test
    void lRange() {
    }

    @Test
    void lSize() {
    }

    @Test
    void lIndex() {
    }

    @Test
    void lPush() {
    }

    @Test
    void testLPush() {
    }

    @Test
    void lPushAll() {
    }

    @Test
    void testLPushAll() {
    }

    @Test
    void lRemove() {
    }
}