# rookie-webflux-filter

### webFilter实现过滤器

webfliter实现过滤器很简单，跟springmvc的过滤器类似，如下代码

创建controller

```java
@RestController
public class HomeController {

    @RequestMapping({"/hello"})
    public Mono<String> hello() {


        return Mono.just("hello 中国webflux");

    }

    @RequestMapping({"/world"})
    public Mono<String> world() {


        return Mono.just("world 中国webflux");

    }


}
```

设置过滤器

```java
@Component
public class UrlFilter implements WebFilter {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {


        String uri = exchange.getRequest().getPath().value();
        logger.info("{} 获取请求的url为: {}", exchange.getRequest().getId(), uri);


        //访问hello的请求会进入到/hello的映射方法上，其他的请求会全部进入到/world的映射方法上
        if ("/hello".equals(uri)) {
            return chain.filter(exchange);
        } else {

//            ServerHttpRequest request = exchange.getRequest().mutate().path("/world").build();
//            ServerWebExchange webExchange = exchange.mutate().request(request).build();
//
//            return  chain.filter(webExchange);


            return chain.filter(exchange
                    .mutate()
                    .request(
                            exchange.getRequest().mutate().path("/world").build()
                    )
                    .build()
            );

        }


    }
}
```

进行测试

分别访问如下地址即可查看到效果

http://localhost:9000/routehello

http://localhost:9000/hello

### HandlerFilterFunction实现过滤器

采用HandlerFilterFunction实现过滤器，首先需要把前面UrlFilter实现的过滤器进行注释，否则会出现问题。如下代码

HelloWorldHandler

```java
@Component
public class HelloWorldHandler {


    public Mono<ServerResponse> helloWorld(ServerRequest request) {


        //        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
//                .body(BodyInserters.fromObject("Hello, 中国webflux !"));

        //解决中文乱码的问题
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).header("Content-Type", "text/plain; charset=utf-8")
                //.body(BodyInserters.fromObject("Hello, 中国webflux !"));
                .body(BodyInserters.fromObject("Hello RouterFunction, 中国webflux !"));
    }
}

```

HelloWebFlux

```java
@Configuration
public class HelloWebFlux {

    @Bean
    public RouterFunction<ServerResponse> hello(HelloWorldHandler handler) {


//        return RouterFunctions.
//                route(RequestPredicates.path("/routehello"), handler::helloWorld)
//                .filter(new HandlerFilterFunction<ServerResponse, ServerResponse>() {
//                    @Override
//                    public Mono<ServerResponse> filter(ServerRequest request, HandlerFunction<ServerResponse> next) {
//
//                        //只要带有参数name,就放行通过
//                        boolean flag= request.queryParam("name").isPresent();
//                        if (flag) {
//                            return next.handle(request);
//                        } else {
//
////                            //返回错误信息
////                            return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).header("Content-Type", "text/plain; charset=utf-8")
////                                    .body(BodyInserters.fromObject("404 NOT_FOUND"));
//                            //直接返回400
//                            return ServerResponse.badRequest().build();
//                        }
//
//
//                    }
//                });

        //同上面的效果是相同的
        return RouterFunctions
                .route(RequestPredicates.path("/routehello"), handler::helloWorld)
                .filter((request, handlerFaction) -> {
                    boolean flag = request.queryParam("name").isPresent();
                    if (flag) {
                        return handlerFaction.handle(request);
                    } else {

                        //直接返回400
                        return ServerResponse.badRequest().build();
                    }

                });


    }
}
```

分别访问如下进行测试

http://localhost:9000/routehello?name=abc

http://localhost:9000/routehello

查看效果

