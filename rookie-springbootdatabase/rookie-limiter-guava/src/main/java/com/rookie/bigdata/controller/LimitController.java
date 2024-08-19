package com.rookie.bigdata.controller;

import com.rookie.bigdata.annotation.GuavaLimitRateAnnotation;
import com.rookie.bigdata.annotation.SentinelLimitRateAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class LimitController
 * @Description
 * @Author rookie
 * @Date 2024/8/19 16:09
 * @Version 1.0
 */
@RestController
@RequestMapping("/limit")
public class LimitController {

    @GetMapping("/limitByGuava")
    @GuavaLimitRateAnnotation(limitType = "测试限流", limitCount = 1)
    public String limitByGuava() {
        return "limitByGuava";
    }

    @GetMapping("/limitBySentinel")
    @SentinelLimitRateAnnotation(resourceName = "测试限流2", limitCount = 1)
    public String limitBySentinel() {
        return "limitBySentinel";
    }


}
