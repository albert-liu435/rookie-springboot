package com.rookie.bigdata.config;

import com.rookie.bigdata.config.properties.CorsProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName CorsConfig
 * @Description https://www.cnblogs.com/antLaddie/p/14751540.html
 * @Author rookie
 * @Date 2021/6/18 10:21
 * @Version 1.0
 */
@Configuration
@ConditionalOnClass(CorsProperties.class)
@EnableConfigurationProperties(CorsProperties.class)
@AllArgsConstructor
public class CorsConfig {
}
