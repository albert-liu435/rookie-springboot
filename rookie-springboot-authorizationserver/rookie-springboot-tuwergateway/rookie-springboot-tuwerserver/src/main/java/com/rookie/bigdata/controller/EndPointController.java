package com.rookie.bigdata.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class EndPointController
 * @Description 获取用户信息接口
 * @Author rookie
 * @Date 2024/8/13 14:48
 * @Version 1.0
 */
@RestController
@RequestMapping("/oauth2")
public class EndPointController {
    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("/user")
    public Authentication oauth2UserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new RuntimeException("无有效认证用户！");
        }
        return authentication;
    }
}
