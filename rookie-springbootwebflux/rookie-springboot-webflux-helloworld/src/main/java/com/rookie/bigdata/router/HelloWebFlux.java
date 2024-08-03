package com.rookie.bigdata.router;

import com.rookie.bigdata.handler.HelloWorldHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @Classname HelloWebFlux
 * @Description 基于功能
 * @Author rookie
 * @Date 2022/4/25 12:08
 * @Version 1.0
 */
@Configuration
public class HelloWebFlux {

    /**
     * localhost:8080/hello
     *
     * @param handler
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> hello(HelloWorldHandler handler) {

        return RouterFunctions.route(RequestPredicates.path("/hello"), handler::helloWorld);

//        return RouterFunctions
//                .route(RequestPredicates.GET("/hello")
//                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
//                        handler::helloWorld);
    }
}
