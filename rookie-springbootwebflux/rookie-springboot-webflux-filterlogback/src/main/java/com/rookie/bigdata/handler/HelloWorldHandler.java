//package com.rookie.bigdata.handler;
//
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Mono;
//
///**
// * @Classname HelloWorldHandler
// * @Description TODO
// * @Author rookie
// * @Date 2022/4/25 12:08
// * @Version 1.0
// */
//@Component
//public class HelloWorldHandler {
//
//
//    public Mono<ServerResponse> helloWorld(ServerRequest request) {
//
//
//        //        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
////                .body(BodyInserters.fromObject("Hello, 中国webflux !"));
////
//        //解决中文乱码的问题
//        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).header("Content-Type", "text/plain; charset=utf-8")
//                //.body(BodyInserters.fromObject("Hello, 中国webflux !"));
//                .body(BodyInserters.fromObject("Hello RouterFunction, 中国webflux !"));
//
//
////        //http://localhost:9000/routehello?name=other
////        //http://localhost:9000/routehello?name=123
////
////        String name = request.queryParam("name").orElse("other");
////
////        return mono(name).flatMap(serverResponse -> ServerResponse.ok()
////                .contentType(MediaType.TEXT_PLAIN).syncBody(serverResponse))
////                .onErrorResume(e -> Mono.just("Error: " + e.getMessage()).
////                        flatMap(serverResponse -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
////                                .syncBody(serverResponse)));
//
//
////        String name = request.queryParam("name").orElse("other");
////        return mono(name)
////                //.flatMap(serverResponse -> ServerResponse.ok()
////                //.contentType(MediaType.TEXT_PLAIN).syncBody(serverResponse))
////                .onErrorReturn("onErrorReturn").
////                        flatMap(serverResponse -> ServerResponse.ok()
////                                .contentType(MediaType.TEXT_PLAIN)
////                                .syncBody(serverResponse));
//
//
//    }
//
//    public Mono<String> mono(String value) {
//
//        switch (value) {
//            case "abc":
//                return Mono.just("a-b-c");
//            case "bdc":
//                return Mono.just("b-c-d");
//            case "other":
//                throw new NullPointerException("空指针异常");
//            default:
//                return Mono.just(value);
//        }
//
//
//    }
//
//}
