package com.rookie.bigdata.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Classname HomeController
 * @Description
 * @Author rookie
 * @Date 2022/4/25 11:41
 * @Version 1.0
 */
@RestController
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * localhost:8080/controller
     *
     * @return
     */
    @RequestMapping({"/controller"})
    public Mono<String> hello() {

//        Mono.deferContextual()
        // Mono.deferContextual(Mono::just).doOnEach(signl->{})
        logger.info("打印controller请求");

        // Mono.deferContextual(Mono::just).doOnEach(signl->{})
//        Mono.deferContextual(contextView -> {
//            System.out.println((Object) contextView.get("TRACE_ID"));
//            return contextView;
//        }).then(Mono.just("hello 中国 webflux"));

//        Mono<ContextView> contextViewMono = Mono.deferContextual(Mono::just);
//        contextViewMono.map(contextView -> {
//            System.out.println((Object) contextView.get("TRACE_ID"));
//            return contextView;
//        }).contextWrite( ctx -> ctx.put("TRACE_ID","haha"))
//                .subscribe();


//        Mono.subscriberContext()
//                .map( context -> {
//                    System.out.println((Object) context.get("TRACE_ID"));
//                    return context;
//                })
//                .contextWrite( ctx -> ctx.put("TRACE_ID","haha"))
//                .subscribe();

        return Mono.just("hello controller 中国 webflux");
    }
}
