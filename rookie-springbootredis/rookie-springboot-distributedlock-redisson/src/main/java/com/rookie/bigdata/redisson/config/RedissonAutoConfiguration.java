package com.rookie.bigdata.redisson.config;

import com.rookie.bigdata.redisson.RedissonLock;
import com.rookie.bigdata.redisson.RedissonManager;
import com.rookie.bigdata.redisson.entity.RedissonProperties;
import org.redisson.Redisson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @Classname RedissonAutoConfiguration
 * @Description Redisson自动化配置
 * @Author rookie
 * @Date 2023/1/16 11:22
 * @Version 1.0
 */
@Configuration
@ConditionalOnClass(Redisson.class)
@EnableConfigurationProperties(RedissonProperties.class)
//@ComponentScan("com.oujiong.redisson.annotation")
public class RedissonAutoConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedissonAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    @Order(value = 2)
    public RedissonLock redissonLock(RedissonManager redissonManager) {
        RedissonLock redissonLock = new RedissonLock(redissonManager);
        LOGGER.info("[RedissonLock]组装完毕");
        return redissonLock;
    }

    @Bean
    @ConditionalOnMissingBean
    @Order(value = 1)
    public RedissonManager redissonManager(RedissonProperties redissonProperties) {
        RedissonManager redissonManager =
                new RedissonManager(redissonProperties);
        LOGGER.info("[RedissonManager]组装完毕,当前连接方式:" + redissonProperties.getType() +
                ",连接地址:" + redissonProperties.getAddress());
        return redissonManager;
    }
}
