package com.rookie.bigdata.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 22:07
 * @Version 1.0
 */
@Controller
public class RedirectController {


    @RequestMapping("/redirect3")
    public void hello(ServerHttpResponse response){
        response.setStatusCode(HttpStatus.FOUND);
        response.getHeaders().setLocation(URI.create("http://www.taobao.com"));
    }

    @RequestMapping("/redirect2")
    public Mono<Void> hello2(ServerHttpResponse response){
        return Mono.fromRunnable(()->{
            response.setStatusCode(HttpStatus.FOUND);
            response.getHeaders().setLocation(URI.create("http://www.baidu.com"));
        });
    }


    @RequestMapping("/redirect")
    public String redirect(){

        return "redirect:http://www.baidu.com";


    }


}
