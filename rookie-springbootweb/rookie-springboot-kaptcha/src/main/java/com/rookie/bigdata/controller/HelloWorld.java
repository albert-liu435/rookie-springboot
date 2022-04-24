package com.rookie.bigdata.controller;

import com.rookie.bigdata.util.CodeUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloWorld {
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request) {
        if (!CodeUtil.checkVerifyCode(request)) {
            return "验证码有误！";
        } else {
            return "hello,world";
        }
    }
}
