package com.rookie.bigdata.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class FixWindowLimiterTest
 * @Description
 * @Author rookie
 * @Date 2024/8/20 9:17
 * @Version 1.0
 */
class FixWindowLimiterTest {

    @Test
    void tryAcquire() {

        FixWindowLimiter fixWindowLimiter=new FixWindowLimiter();

        for(int i=0;i<100;i++){
            boolean b = fixWindowLimiter.tryAcquire();
            System.out.println("获取请求是否成功: "+ b);
        }



    }
}
