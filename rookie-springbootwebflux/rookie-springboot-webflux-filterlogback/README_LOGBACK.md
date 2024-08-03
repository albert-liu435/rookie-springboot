# rookie-webflux-logback

参考官方文档介绍的关于请求的log id

[webflux-logging](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux-logging)

官方对于webflux的log id的解释是由于webflux在处理一个请求时会涉及多次线程的切换，所以线程id对于一个请求它的日志信息的关联的作用就不大了，也就是说我们在打印日志进行追踪的时候最好不要用线程或者日志的MDC方式来进行处理了。spring-webflux中在接受请求的时候会自动生成一个唯一的请求id,并保存在ServerWebExchang中。可以查看ServerWebExchange的LOG_ID_ATTRIBUTE的属性值。

log id的生成策略可以查看源码AbstractServerHttpRequest的getId方法，最终调用的是ReactorServerHttpRequest的initId()方法

关于日志追踪中的唯一logid有很多种方法，这里介绍两种方法

### 使用webflux自带的过滤器ServerWebExchangeContextFilter

如下代码

```java
@Configuration
public class FilterConfig {

    @Bean
    public ServerWebExchangeContextFilter filter(){
        return new ServerWebExchangeContextFilter();
    }
}
```

```java
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


@RequestMapping({"/controller"})
public Mono<String> hello() {
    logger.info("打印controller请求");

    return Mono.deferContextual(Mono::just)
            .map(context -> {

                ServerWebExchange serverWebExchange=(ServerWebExchange)context.get(EXCHANGE_CONTEXT_ATTRIBUTE);

                String logPrefix = serverWebExchange.getLogPrefix();

                logger.info("打印日志id[{}],{}",logPrefix,serverWebExchange.getRequest().getPath().value());

              //  System.out.println((Object) context.get("TRACE_ID"));
                return context;
            })
            .thenReturn("hello 中国 webflux");


}
```

访问http://localhost:9000/controller即可看到自己打印的日志中含有这个请求的唯一id了，方便后续问题排查

### 自定义过滤器实现

```java
@Component
public class LogFilter implements WebFilter {
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        return chain.filter(exchange)
                .contextWrite(Context.of("requestId", exchange.getLogPrefix()));
    }
}
```

```java
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public Mono<User> hello(@RequestBody User user) {


      //  logger.info("打印controller请求");
        return Mono.deferContextual(Mono::just)
                .map(context -> {

//                    ServerWebExchange serverWebExchange=(ServerWebExchange)context.get(EXCHANGE_CONTEXT_ATTRIBUTE);
//
//                    String logPrefix = serverWebExchange.getLogPrefix();


                    logger.info("打印日志id[{}],{}",context.get("requestId"),user.toString());

                    //  System.out.println((Object) context.get("TRACE_ID"));
                    return context;
                })
                .thenReturn(user);
    }
```

使用postman访问请求 http://localhost:9000/user,并在body中添加

```java
{

  "name":"张三",

  "age":23

}
```

