package com.rookie.bigdata.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Class RedisConfig
 * @Description Redis 基础配置 可以参考  org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration
 * @Author rookie
 * @Date 2024/8/15 11:53
 * @Version 1.0
 */
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(factory);
        //key序列化
        RedisSerializer keySerializer = new StringRedisSerializer();
        RedisSerializer valueSerializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setKeySerializer(keySerializer);
        //value序列化
        redisTemplate.setValueSerializer(valueSerializer);
        //hash key 序列化
        redisTemplate.setHashKeySerializer(keySerializer);
        //hash value 序列化
        redisTemplate.setHashValueSerializer(valueSerializer);
        //redis初始化
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplateGroup(RedisConnectionFactory factory) {
        // 配置redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(factory);
        RedisSerializer keySerializer = new StringRedisSerializer();
        RedisSerializer valueSerializer = new GenericJackson2JsonRedisSerializer(getMapper());
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setValueSerializer(valueSerializer);
        redisTemplate.setHashKeySerializer(keySerializer);
        redisTemplate.setHashValueSerializer(valueSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * 获取JSON工具
     * @return
     */
    private final ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        //将类名称序列化到json串中，去掉会导致得出来的的是LinkedHashMap对象，直接转换实体对象会失败
        //设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
        //其中该配置，需要升级fasterxml版本
        //mapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,ObjectMapper.DefaultTyping.NON_FINAL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

}
