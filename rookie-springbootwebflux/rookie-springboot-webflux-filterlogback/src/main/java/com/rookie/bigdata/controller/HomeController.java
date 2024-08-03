package com.rookie.bigdata.controller;

import com.rookie.bigdata.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.springframework.web.filter.reactive.ServerWebExchangeContextFilter.EXCHANGE_CONTEXT_ATTRIBUTE;

/**
 * @Classname HomeController
 * @Description
 * @Author rookie
 * @Date 2022/4/25 11:41
 * @Version 1.0
 */
@RestController
@Slf4j
public class HomeController {

    @RequestMapping({"/hello"})
    public Mono<String> hello() {


        return Mono.just("hello 中国webflux");

    }

    @RequestMapping({"/world"})
    public Mono<String> world() {


        return Mono.just("world 中国webflux");

    }



    @RequestMapping({"/controller"})
    public Mono<String> helloController() {
        log.info("打印controller请求");

        return Mono.deferContextual(Mono::just)
                .map(context -> {

                    ServerWebExchange serverWebExchange=(ServerWebExchange)context.get(EXCHANGE_CONTEXT_ATTRIBUTE);

                    String logPrefix = serverWebExchange.getLogPrefix();

                    log.info("打印日志id[{}],{}",logPrefix,serverWebExchange.getRequest().getPath().value());

                    //  System.out.println((Object) context.get("TRACE_ID"));
                    return context;
                })
                .thenReturn("hello 中国 webflux");


    }


    @RequestMapping(value = "user", method = RequestMethod.POST)
    public Mono<User> hello(@RequestBody User user) {


        log.info("打印controller请求");
        return Mono.deferContextual(Mono::just)
                .map(context -> {

//                    ServerWebExchange serverWebExchange=(ServerWebExchange)context.get(EXCHANGE_CONTEXT_ATTRIBUTE);
//
//                    String logPrefix = serverWebExchange.getLogPrefix();


                    log.info("打印日志id[{}],{}",context.get("requestId"),user.toString());

                    //  System.out.println((Object) context.get("TRACE_ID"));
                    return context;
                })
                .thenReturn(user);
    }



}