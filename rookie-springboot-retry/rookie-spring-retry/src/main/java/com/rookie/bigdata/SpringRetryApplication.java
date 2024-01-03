package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @ClassName JacksonApplication
 * @Description JacksonApplication
 * @Author rookie  参考 https://blog.csdn.net/cckevincyh/article/details/112347200
 * @Date 2021/6/17 11:32
 * @Version 1.0
 */
@SpringBootApplication
//设置了proxyTargetClass=true这使用CGLIB动态代理
//@EnableRetry(proxyTargetClass = true)
//开始Retry功能
@EnableRetry
public class SpringRetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRetryApplication.class, args);
    }
}
