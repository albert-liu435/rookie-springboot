package com.rookie.bigdata.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 17:59
 * @Version 1.0
 */
@Component
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE+11) // 可以指定优先级，不填的话默认为最小的优先级
public class LogFilter implements WebFilter {
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        log.info("LogFilter:{}",exchange.getRequest().getId());

        return chain.filter(exchange)
                .contextWrite(Context.of("requestId", exchange.getLogPrefix()));
    }
}
