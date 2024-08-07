package com.rookie.bigdata.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;

/**
 * @Class RedirectController
 * @Description
 * @Author rookie
 * @Date 2024/8/7 16:30
 * @Version 1.0
 */
//@RestController("redirects")
@Controller
@Slf4j
public class RedirectController {

//    RedirectView 直接封装了重定向的URL，适合简单的重定向需求。
//RedirectAttributes 允许携带闪存属性到重定向的目标页面，适合需要传递一些信息给下一个请求的场景。
//ModelAndView 提供了视图名前缀为 “redirect:” 的方式来实现重定向，是一种较为传统的Spring MVC做法。
//ResponseEntity 则提供了最灵活的控制方式，适用于需要精确控制HTTP响应头和状态码的场景。



    ///////////////////////////////////////////////////1. 使用 RedirectView 或 RedirectAttributes//////////////////////////////////////////////////////////////////////

    /**
     * localhost:8080/redirectExample
     * 进行重定向
     * @return
     */
    @GetMapping("/redirectExample")
    public RedirectView handleRedirect() {
        return new RedirectView("http://localhost:8080/newEndpoint");
    }

    @PostMapping("/processForm")
    public String processForm(@RequestParam("input") String input, RedirectAttributes redirectAttributes) {
        // 处理逻辑...
        redirectAttributes.addFlashAttribute("message", "操作成功！");
        return "redirect:/newEndpoint";
    }



    @GetMapping("/anotherRedirect")
    public ModelAndView anotherRedirectMethod() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/newEndpoint");
        return modelAndView;
    }

    @GetMapping("/customRedirect")
    public ResponseEntity<Void> customRedirect() {
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(URI.create("http://localhost:8080/newEndpoint")).build();
    }


    @GetMapping("/newEndpoint")
    @ResponseBody
    public String getRedirect(){
        log.info("重定向:");

        return "redirect";
    }

}
