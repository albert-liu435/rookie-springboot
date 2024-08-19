package com.rookie.bigdata.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @Class RedisLock
 * @Description
 * @Author rookie
 * @Date 2024/8/19 13:43
 * @Version 1.0
 */
public class RedisLock implements AutoCloseable {

    private Logger logger = LoggerFactory.getLogger(RedisLock.class);

    private String key;
    private String value;
    //单位：秒
    private int expireTime;

    private RedisTemplate<String, Object> redisTemplate;

    public RedisLock(RedisTemplate<String, Object> redisTemplate, String key,int expireTime){
        this.redisTemplate = redisTemplate;
        this.key = key;
        this.expireTime = expireTime;
        this.value = UUID.randomUUID().toString();
    }

    /**
     * 获取分布式锁
     * @return
     */
    public boolean getLock(){
        logger.debug("进入获取锁的方法。");
        RedisCallback<Boolean> redisCallback = connection -> {
            //设置NX
            RedisStringCommands.SetOption setOption = RedisStringCommands.SetOption.ifAbsent();
            //设置过期时间
            Expiration expiration = Expiration.seconds(expireTime);
            //序列化key
            RedisSerializer keySerializer = new StringRedisSerializer();
            byte[] redisKey = keySerializer.serialize(key);
            //序列化value
            RedisSerializer valueSerializer = new GenericJackson2JsonRedisSerializer();
            byte[] redisValue = valueSerializer.serialize(value);
            //执行setnx操作
            Boolean result = connection.set(redisKey, redisValue, expiration, setOption);
            return result;
        };
        //获取分布式锁
        Boolean lock = (Boolean)redisTemplate.execute(redisCallback);
        logger.debug("获取分布式锁的结果：" + lock);
        return lock;
    }

    public boolean unLock() {
        logger.debug("进入释放锁的方法。");
        String script = "if redis.call(\"get\",KEYS[1]) == ARGV[1] then\n" +
                "    return redis.call(\"del\",KEYS[1])\n" +
                "else\n" +
                "    return 0\n" +
                "end";
        RedisScript<Boolean> redisScript = RedisScript.of(script,Boolean.class);
        List<String> keys = Arrays.asList(key);

        Boolean result = (Boolean)redisTemplate.execute(redisScript, keys, value);
        logger.debug("释放锁的结果："+result);
        return result;
    }


    @Override
    public void close() throws Exception {
        unLock();
    }

}
