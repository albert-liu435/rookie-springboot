package com.rookie.bigdata.controller.async;

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
 * @Description
 * @Author rookie
 * @Date 2024/11/15 17:41
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "/async/servlet")
@Slf4j
public class AsyncController {


//    javax.servlet.ServletRequest#startAsync()获取AsyncContext
//添加监听器 asyncContext.addListener(AsyncListener)（这个是可选的）
//用户请求开始、超时、异常、完成时回调
//设置超时时间 asyncContext.setTimeout(3000L) （可选）
//异步任务asyncContext.start(Runnable)

    /**
     * http://localhost:8080/async/servlet/get?sleep=100
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
