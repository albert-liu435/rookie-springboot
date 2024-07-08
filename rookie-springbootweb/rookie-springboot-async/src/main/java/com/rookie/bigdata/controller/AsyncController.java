package com.rookie.bigdata.controller;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.AsyncEvent;
import jakarta.servlet.AsyncListener;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Class AsyncController
 * @Description https://spring.hhui.top/spring-blog/2020/03/29/200329-SpringBoot%E7%B3%BB%E5%88%97%E6%95%99%E7%A8%8B%E4%B9%8B%E5%BC%82%E6%AD%A5%E8%AF%B7%E6%B1%82%E6%9C%80%E5%85%A8%E7%9F%A5%E8%AF%86%E7%82%B9%E4%B8%8E%E4%BD%BF%E7%94%A8%E5%A7%BF%E5%8A%BF/
 * @Author rookie
 * @Date 2024/7/8 15:42
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "servlet")
@Slf4j
public class AsyncController {


//    javax.servlet.ServletRequest#startAsync()获取AsyncContext
//添加监听器 asyncContext.addListener(AsyncListener)（这个是可选的）
//用户请求开始、超时、异常、完成时回调
//设置超时时间 asyncContext.setTimeout(3000L) （可选）
//异步任务asyncContext.start(Runnable)

    /**
     * http://localhost:8080/servlet/get?sleep=100
     *
     * @param request
     */


    @GetMapping(path = "get")
    public void get(HttpServletRequest request) {
        AsyncContext asyncContext = request.startAsync();
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent asyncEvent) throws IOException {
                log.info("操作完成：{}", Thread.currentThread().getName());
//                System.out.println("操作完成:" + Thread.currentThread().getName());
            }

            @Override
            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                log.info("超时返回!!!");
                asyncContext.getResponse().setCharacterEncoding("utf-8");
                asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
                asyncContext.getResponse().getWriter().println("超时了！！！!");
            }

            @Override
            public void onError(AsyncEvent asyncEvent) throws IOException {
                log.info("出现了m某些异常");
                asyncEvent.getThrowable().printStackTrace();

                asyncContext.getResponse().setCharacterEncoding("utf-8");
                asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
                asyncContext.getResponse().getWriter().println("出现了某些异常哦！！！!");
            }

            @Override
            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                log.info("开始执行");
            }
        });

        asyncContext.setTimeout(3000L);
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(Long.parseLong(request.getParameter("sleep")));
                    log.info("内部线程：" + Thread.currentThread().getName());
                    asyncContext.getResponse().setCharacterEncoding("utf-8");
                    asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
                    asyncContext.getResponse().getWriter().println("异步返回!");
                    asyncContext.getResponse().getWriter().flush();
                    // 异步完成，释放
                    asyncContext.complete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        log.info("主线程over!!! " + Thread.currentThread().getName());
    }
}
