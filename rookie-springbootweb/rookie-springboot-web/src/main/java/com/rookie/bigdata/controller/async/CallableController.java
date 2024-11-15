package com.rookie.bigdata.controller.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @Class CallableController
 * @Description
 * @Author rookie
 * @Date 2024/11/15 17:48
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "/async/call")
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
