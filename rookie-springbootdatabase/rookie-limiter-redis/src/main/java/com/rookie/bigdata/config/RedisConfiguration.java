//package com.rookie.bigdata.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.script.DefaultRedisScript;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.scripting.support.ResourceScriptSource;
//
///**
// * @Class RedisConfiguration
// * @Description
// * @Author rookie
// * @Date 2024/8/19 16:30
// * @Version 1.0
// */
//@Configuration
//public class RedisConfiguration {
//
//    @Bean
//    public DefaultRedisScript<Number> redisLuaScript() {
//        DefaultRedisScript<Number> redisScript = new DefaultRedisScript<>();
//        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua\\limit.lua")));
//        // 设置lua脚本返回值类型 需要同lua脚本中返回值一致
//        redisScript.setResultType(Number.class);
//        return redisScript;
//    }
//
//    @Bean("redisTemplate")
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        //设置value的序列化方式为JSOn
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        //设置key的序列化方式为String
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//
//}
