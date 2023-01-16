//package com.rookie.bigdata.service.impl;
//
//import com.rookie.bigdata.service.RedissonService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * @ClassName RedissonServiceImplTest
// * @Description RedissonServiceImplTest
// * @Author rookie
// * @Date 2021/6/22 10:13
// * @Version 1.0
// */
//@SpringBootTest
//@ActiveProfiles("dev")
//class RedissonServiceImplTest {
//
//
//
//    @Autowired
//    private RedissonService redissonService;
//
//    @Test
//    void atomicLong() {
//
//
//        redissonService.setValue("a","b");
//
//        Long key = redissonService.AtomicLong(/*(long) 1,*/ "key");
//        System.out.println(key);
//    }
//
//
//    @Test
//    public void test1(){
//        System.out.println(UUID.randomUUID().toString());
//    }
//}