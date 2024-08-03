# rookie-webflux-helloworld

webflux开发有两种方式，基于注解式和基于功能

### 基于注解

基于注解的方式同springmvc一样，直接加入注解即可，如下代码

```java
@RestController
public class HomeController {

    private static final Log logger = LogFactory.getLog(HomeController.class);


    @RequestMapping({"/controller"})
    public Mono<String> hello() {

        //Mono.deferContextual()
       // Mono.deferContextual(Mono::just).doOnEach(signl->{})
        logger.info("打印controller请求");

        return Mono.just("hello 中国 webflux");
    }
}
```

运行程序直接访问http://localhost:9000/controller即可返回响应结果

### 基于功能

如下代码：

```java
@Configuration
public class HelloWebFlux {

    @Bean
    public RouterFunction<ServerResponse> hello(HelloWorldHandler handler) {

                return RouterFunctions.route(RequestPredicates.path("/hello"),handler::helloWorld);

//        return RouterFunctions
//                .route(RequestPredicates.GET("/hello")
//                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
//                        handler::helloWorld);
    }
}
```

```java
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
```

运行程序访问http://localhost:9000/hello即可
