package com.rookie.bigdata.controller;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

/**
 * @Class IndexController
 * @Description
 * @Author rookie
 * @Date 2024/8/13 18:26
 * @Version 1.0
 */
@Controller
public class IndexController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public String index(Model model) {
        // 从安全上下文中获取登录信息，返回给model
        Map<String, Object> map = new HashMap<>(2);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        map.put("name", auth.getName());
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.stream().iterator();
        ArrayList<Object> authList = new ArrayList<>();
        while (iterator.hasNext()) {
            authList.add(iterator.next().getAuthority());
        }

        map.put("authorities", authList);
        model.addAttribute("user", JSON.toJSONString(map));
        return "index";
    }

    @GetMapping("/out")
    public void logout(HttpServletRequest request,
                       HttpServletResponse response) {

        // ========== 清理客户端 ===========
        // 清理客户端session
        request.getSession().invalidate();
        // 清理客户端安全上下文
        SecurityContextHolder.clearContext();

        // ========== 清理认证中心 ===========
        // 跳转至认证中心退出页面
        try {
            response.sendRedirect("http://rookie-tuwer.server.com:9000/logout");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}