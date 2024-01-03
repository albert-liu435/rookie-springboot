package com.rookie.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 静态代理和动态代理：https://juejin.cn/post/7098269942310502437
 * https://segmentfault.com/a/1190000011291179
 * https://zhuanlan.zhihu.com/p/540394137
 * https://developer.aliyun.com/article/939919
 * https://blog.csdn.net/weixin_45393094/article/details/120962212?spm=a2c6h.12873639.article-detail.7.39cf75adhz6iWX
 *
 * @ClassName AopApplication
 * @Description AopApplication
 * @Author rookie
 * @Date 2021/6/17 16:10
 * @Version 1.0
 */
@SpringBootApplication
public class AopProxyApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(AopProxyApplication.class);
        springApplication.run(args);

    }
}
