package com.rookie.bigdata.controller;

import com.rookie.bigdata.annotation.IpLimiter;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Classname IpController
 * @Description https://www.cnblogs.com/qdhxhz/p/10982218.html
 * @Author rookie
 * @Date 2023/1/13 16:09
 * @Version 1.0
 */
@Controller
public class IpController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IpController.class);
    private static final String MESSAGE = "请求失败,你的IP访问太频繁";

    //这里就不获取请求的ip,而是写死一个IP
    @ResponseBody
    @RequestMapping("iplimiter")
    @IpLimiter(ipAdress = "127.0.0.1", limit = 5, time = 10, message = MESSAGE)
    public String sendPayment(HttpServletRequest request) throws Exception {
        return "请求成功";
    }
    @ResponseBody
    @RequestMapping("iplimiter1")
    @IpLimiter(ipAdress = "127.188.145.54", limit = 4, time = 10, message = MESSAGE)
    public String sendPayment1(HttpServletRequest request) throws Exception {
        return "请求成功";
    }
}
