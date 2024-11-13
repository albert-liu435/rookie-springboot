package com.rookie.bigdata.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Class MybatisConfig
 * @Description
 * @Author rookie
 * @Date 2024/11/13 14:00
 * @Version 1.0
 */
@Configuration
@MapperScan("com.rookie.bigdata.mapper")
public class MybatisConfig {
}
