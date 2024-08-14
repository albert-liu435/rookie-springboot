package com.rookie.bigdata.controller;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
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
@Slf4j
@Controller
public class IndexController {
    @Autowired
    UserDetailsService userDetailsService;
    //@Autowired
    //SwitchUserFilter switchUserFilter;

    //@GetMapping("/")
    public void switchUser(HttpServletResponse response) {
        // 从安全上下文中获取登录信息
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        // 根据三方用户查绑定的本地用户
        String localUser = getLocalUser(username);
        log.info("本地用户：" + localUser);
        // 切换本地用户登录
        //switchUserFilter.setUsernameParameter(localUser);
        // 切换用户
        try {
            response.sendRedirect("./login/impersonate");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 权限提升
     * 第三方用户进入本系统后，绑定本地用户，获取本地用户的角色和权限
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String user(Model model) {
        // 从安全上下文中获取登录信息，返回给model
        Map<String, Object> map = new HashMap<>(5);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        map.put("当前用户", username);
        map.put("原来权限", auth.getAuthorities());

        //Set<GrantedAuthority> authorities = new ArraySet<>(auth.getAuthorities());
        Set<GrantedAuthority> authorities = new HashSet<>(auth.getAuthorities());

        // 根据三方用户查绑定的本地用户
        String localUser = getLocalUser(username);
        UserDetails userDetails = userDetailsService.loadUserByUsername(localUser);
        map.put("本地用户", localUser);
        // 本地用户权限
        //List<GrantedAuthority> authorities1 = new ArrayList<>(userDetails.getAuthorities());
        Set<GrantedAuthority> authorities1 = new HashSet<>(userDetails.getAuthorities());
        map.put("本地用户权限", authorities1);
        // 把本地用户权限加入原来权限集中
        authorities.addAll(authorities1);
        map.put("新的权限", authorities);
        // 生成新的认证信息
        Authentication newAuth = new OAuth2AuthenticationToken(
                (OAuth2User) auth.getPrincipal(),
                authorities,
                "myClient");
        // 重置认证信息
        SecurityContextHolder.getContext().setAuthentication(newAuth);
        model.addAttribute("user", map);
        return "index";
    }


    /**
     * 模拟通过第三方用户，得到本地用户
     *
     * @param remoteUsername
     * @return
     */
    private String getLocalUser(String remoteUsername) {
        String u = "";
        // 模拟通过三方用户查本地用户
        if (StringUtils.isNotEmpty(remoteUsername)) {
            u = "local_admin";
        }
        return u;
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
