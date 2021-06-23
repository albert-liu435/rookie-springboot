package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.service.RedissonService;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RBinaryStream;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

/**
 * @ClassName RedissonServiceImpl
 * @Description RedissonServiceImpl
 * @Author rookie
 * @Date 2021/6/22 10:03
 * @Version 1.0
 */
@Service
public class RedissonServiceImpl implements RedissonService {

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public Long AtomicLong(/*Long value, */String key) {

        RAtomicLong atomicLong = redissonClient.getAtomicLong(key);

       // atomicLong.set(value);
       // atomicLong.incrementAndGet();
       return  atomicLong.incrementAndGet();

    }

    @Override
    public void setValue(String key, String value) {
        setValue(key,value.getBytes(Charset.forName("UTF-8")));
    }

    @Override
    public void setValue(String key, byte[] value) {
        RBinaryStream binaryStream = redissonClient.getBinaryStream(key);
        binaryStream.set(value);
    }
}
