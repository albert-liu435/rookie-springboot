package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @ClassName AopApplication
 * @Description FilterApplication
 * @Author rookie
 * @Date 2021/6/17 16:10
 * @Version 1.0
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.rookie.bigdata.filter.web")
public class FilterApplication {
    public static void main(String[] args) {


        SpringApplication.run(FilterApplication.class, args);

    }
}
