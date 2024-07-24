package com.rookie.bigdata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Class DeferredResultController
 * @Description
 * @Author rookie
 * @Date 2024/7/8 16:12
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "defer")
public class DeferredResultController {

    /**
     * 在上面的实例中，用户如果先访问http://localhost:8080/defer/get?id=yihuihui，不会立马有结果，直到用户再次访问http://localhost:8080/defer/pub?id=yihuihui&content=哈哈时，前面的请求才会有结果返回
     */

//    那么这个可以设置超时么，如果一直把前端挂住，貌似也不太合适吧
//
//    在构造方法中指定超时时间: new DeferredResult<>(3000L)
//    设置全局的默认超时时间


//    @Configuration
//    @EnableWebMvc
//    public class WebConf implements WebMvcConfigurer {
//
//        @Override
//        public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//            // 超时时间设置为60s
//            configurer.setDefaultTimeout(TimeUnit.SECONDS.toMillis(10));
//        }
//    }


    private Map<String, DeferredResult> cache = new ConcurrentHashMap<>();

    @GetMapping(path = "get")
    public DeferredResult<String> get(String id) {
        DeferredResult<String> res = new DeferredResult<>();
        cache.put(id, res);

        res.onCompletion(new Runnable() {
            @Override
            public void run() {
                System.out.println("over!");
            }
        });
        return res;
    }
    @GetMapping(path = "pub")
    public String publish(String id, String content) {
        DeferredResult<String> res = cache.get(id);
        if (res == null) {
            return "no consumer!";
        }

        res.setResult(content);
        return "over!";
    }
}
