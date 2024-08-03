package com.rookie.bigdata.controller;

import com.rookie.bigdata.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 22:01
 * @Version 1.0
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);



    //重定向 访问http://localhost:9000/redirectindex

    @RequestMapping("/redirectindex")
    public String redirectUrl(){

        return "redirect:/index";
    }

    //重定向 访问http://localhost:9000/redirectrender
    @RequestMapping("/redirectrender")
    public Mono<Rendering> redirectRender(){

        return Mono.just(Rendering.redirectTo("/index").build());

    }



    @RequestMapping({"/index"})
    public Mono<String> index(final Model model) {

        logger.info("打印controller请求");

        model.addAttribute("name", "张三");

        return Mono.just("index");

    }


    @RequestMapping({"/getusers"})
    public Mono<String> user(final Model model){

        Flux<User> userFlux = Flux.just(new User("张三", 23), new User("李四", 24));
        model.addAttribute("users",userFlux);

        return Mono.just("users.html");


    }




}
