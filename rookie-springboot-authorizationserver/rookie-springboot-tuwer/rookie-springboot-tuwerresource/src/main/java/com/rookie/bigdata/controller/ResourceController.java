package com.rookie.bigdata.controller;

import com.alibaba.fastjson2.JSON;
import com.rookie.bigdata.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class ResourceController
 * @Description
 * @Author rookie
 * @Date 2024/8/13 15:14
 * @Version 1.0
 */
@RestController
public class ResourceController {
    @GetMapping("/res1")
    public String getRes1(HttpServletRequest request) {
        return JSON.toJSONString(new Result(200, "服务A -> 资源1"));
    }

    @GetMapping("/res2")
    public String getRes2() {
        return JSON.toJSONString(new Result(200, "服务A -> 资源2"));
    }
}
