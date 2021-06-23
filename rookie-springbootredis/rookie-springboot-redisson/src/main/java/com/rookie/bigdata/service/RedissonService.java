package com.rookie.bigdata.service;

/**
 * @ClassName RedissonService
 * @Description RedissonService
 * @Author rookie
 * @Date 2021/6/22 10:02
 * @Version 1.0
 */

public interface RedissonService {


    /**
     * @param
     * @param key
     * @return
     */
    Long AtomicLong(/*Long value,*/ String key);


    /**
     * 设置key value值
     *
     * @param key
     * @param value
     */
    void setValue(String key, String value);

    /**
     * 设置key value值
     *
     * @param key
     * @param value
     */
    void setValue(String key, byte[] value);
}
