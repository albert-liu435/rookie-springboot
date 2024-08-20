package com.rookie.bigdata.controller;

import com.rookie.bigdata.annotation.RedisLimitAnnotation;
import com.rookie.bigdata.enums.LimitTypeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class LimitController
 * @Description
 * @Author rookie
 * @Date 2024/8/19 16:37
 * @Version 1.0
 */
@RestController
@RequestMapping("/limit")
public class LimitController {

    @GetMapping("/limitByRedis")
    @RedisLimitAnnotation(key = "limitByRedis", period = 1, count = 1, limitType = LimitTypeEnum.IP)
    public String limitByRedis() {
        return "limitByRedis";
    }

}
