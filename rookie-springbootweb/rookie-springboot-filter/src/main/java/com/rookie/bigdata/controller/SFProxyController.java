package com.rookie.bigdata.controller;

import com.rookie.bigdata.util.ProxyUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Class SFProxyController
 * @Description
 * @Author rookie
 * @Date 2024/7/24 13:29
 * @Version 1.0
 */
@RestController
@RequestMapping("sf")
public class SFProxyController  /*extends BasicController*/ {


    /**
     * http://localhost:8081/sf/proxy/sfexpressService
     *
     * @param request
     * @param response
     * @throws URISyntaxException
     * @throws IOException
     */
    //经过/proxy/**的地址都会返回192.168.1.1的结果，相当于nginx反向代理的效果
    @RequestMapping(value = "/proxy/**")
    public void sfProxy(HttpServletRequest request, HttpServletResponse response) throws URISyntaxException, IOException {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        String requestURI = request.getRequestURI();

        String path = request.getRequestURI();
//        request

//        String path = uri.getPath();
        URI newUri = new URI("https://bspsw-sf-express.best2cn.wmask.net:4501" + path.replace("/sf/proxy",""));
        ProxyUtil.proxy(newUri,request,response);
    }
}
