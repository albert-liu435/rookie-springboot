package com.rookie.bigdata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

/**
 * @Class WebAsyncTaskController
 * @Description https://spring.hhui.top/spring-blog/2020/03/29/200329-SpringBoot%E7%B3%BB%E5%88%97%E6%95%99%E7%A8%8B%E4%B9%8B%E5%BC%82%E6%AD%A5%E8%AF%B7%E6%B1%82%E6%9C%80%E5%85%A8%E7%9F%A5%E8%AF%86%E7%82%B9%E4%B8%8E%E4%BD%BF%E7%94%A8%E5%A7%BF%E5%8A%BF/
 * @Author rookie
 * @Date 2024/7/8 16:11
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "task")
public class WebAsyncTaskController {

    //allable的方式，非常直观简单，但是我们经常关注的超时+异常的处理却不太好，这个时候我们可以用WebAsyncTask，实现姿势也很简单，包装一下callable，然后设置各种回调事件即可



    @GetMapping(path = "get")
    public WebAsyncTask<String> get(long sleep, boolean error) {
        Callable<String> callable = () -> {
            System.out.println("do some thing");
            Thread.sleep(sleep);

            if (error) {
                System.out.println("出现异常，返回!!!");
                throw new RuntimeException("异常了!!!");
            }

            return "hello world";
        };

        // 指定3s的超时
        WebAsyncTask<String> webTask = new WebAsyncTask<>(3000, callable);
        webTask.onCompletion(() -> System.out.println("over!!!"));

        webTask.onTimeout(() -> {
            System.out.println("超时了");
            return "超时返回!!!";
        });

        webTask.onError(() -> {
            System.out.println("出现异常了!!!");
            return "异常返回";
        });

        return webTask;
    }
}
