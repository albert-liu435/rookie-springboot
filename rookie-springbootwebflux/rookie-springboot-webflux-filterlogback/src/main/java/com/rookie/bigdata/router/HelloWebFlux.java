//package com.rookie.bigdata.router;
//
//import com.rookie.bigdata.handler.HelloWorldHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.*;
//import reactor.core.publisher.Mono;
//
///**
// * @Classname HelloWebFlux
// * @Description 基于功能
// * @Author rookie
// * @Date 2022/4/25 12:08
// * @Version 1.0
// */
//@Configuration
//public class HelloWebFlux {
//
//    @Bean
//    public RouterFunction<ServerResponse> hello(HelloWorldHandler handler) {
//
//
////        return RouterFunctions.
////                route(RequestPredicates.path("/routehello"), handler::helloWorld)
////                .filter(new HandlerFilterFunction<ServerResponse, ServerResponse>() {
////                    @Override
////                    public Mono<ServerResponse> filter(ServerRequest request, HandlerFunction<ServerResponse> next) {
////
////                        //只要带有参数name,就放行通过
////                        boolean flag= request.queryParam("name").isPresent();
////                        if (flag) {
////                            return next.handle(request);
////                        } else {
////
//////                            //返回错误信息
//////                            return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).header("Content-Type", "text/plain; charset=utf-8")
//////                                    .body(BodyInserters.fromObject("404 NOT_FOUND"));
////                            //直接返回400
////                            return ServerResponse.badRequest().build();
////                        }
////
////
////                    }
////                });
//
//        //同上面的效果是相同的
//        return RouterFunctions
//                .route(RequestPredicates.path("/routehello"), handler::helloWorld)
//                .filter((request, handlerFaction) -> {
//                    boolean flag = request.queryParam("name").isPresent();
//                    if (flag) {
//                        return handlerFaction.handle(request);
//                    } else {
//
//                        //直接返回400
//                        return ServerResponse.badRequest().build();
//                    }
//
//                });
//
//
//    }
//}
