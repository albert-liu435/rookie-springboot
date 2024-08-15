package com.rookie.bigdata.controller;

import com.rookie.bigdata.domain.CommonResult;
import com.rookie.bigdata.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class UserController
 * @Description
 * @Author rookie
 * @Date 2024/8/15 9:20
 * @Version 1.0
 */
@RestController
public class UserController {

    @GetMapping("/getUser3")
    public CommonResult getUser(){
        User user = new User();
        user.setCardId("372911111111111111");
        user.setPhone("15822229999");
        user.setName("赵飞燕");
        user.setInfo("这是机密文件，该打码打码");
        return CommonResult.success(user);
    }

}
