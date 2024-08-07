package com.rookie.bigdata.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @Class CallableController
 * @Description https://spring.hhui.top/spring-blog/2020/03/29/200329-SpringBoot%E7%B3%BB%E5%88%97%E6%95%99%E7%A8%8B%E4%B9%8B%E5%BC%82%E6%AD%A5%E8%AF%B7%E6%B1%82%E6%9C%80%E5%85%A8%E7%9F%A5%E8%AF%86%E7%82%B9%E4%B8%8E%E4%BD%BF%E7%94%A8%E5%A7%BF%E5%8A%BF/
 * @Author rookie
 * @Date 2024/7/8 16:07
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "call")
@Slf4j
public class CallableController {

    //请注意上面的两种case，一个正常返回，一个业务执行过程中，抛出来异常


    @GetMapping(path = "/get")
    public Callable<String> get() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("do some thing");
                Thread.sleep(1000);
                log.info("执行完毕，返回!!!");
                return "over!";
            }
        };

        return callable;
    }

    @GetMapping(path = "exception")
    public Callable<String> exception() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("do some thing");
                Thread.sleep(1000);
                log.info("出现异常，返回!!!");
                throw new RuntimeException("some error!");
            }
        };

        return callable;
    }
}
