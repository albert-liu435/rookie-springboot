package com.rookie.bigdata.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Classname HelloWorldHandler
 * @Description
 * @Author rookie
 * @Date 2022/4/25 12:08
 * @Version 1.0
 */
@Component
public class HelloWorldHandler {


    public Mono<ServerResponse> helloWorld(ServerRequest request) {


        //        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
//                .body(BodyInserters.fromObject("Hello, 中国webflux !"));

        //解决中文乱码的问题
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).header("Content-Type", "text/plain; charset=utf-8")
                //.body(BodyInserters.fromObject("Hello, 中国webflux !"));
                .body(BodyInserters.fromObject("Hello, 中国webflux !"));
    }
}
