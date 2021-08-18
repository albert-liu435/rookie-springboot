package com.rookie.bigdata.controller;

import com.rookie.bigdata.common.lang.Result;
import com.rookie.bigdata.domain.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname UserController
 * @Description TODO
 * @Author rookie
 * @Date 2021/8/18 9:44
 * @Version 1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {


    @RequestMapping("add")
    public Result addUser(@Validated @RequestBody User user, BindingResult bindingResult) {
//        user.setId(10000L);
//        user.setCreateTime(new Date());

        if (bindingResult.hasErrors()) {
            //logger.info("缺少必要的参数:{}", bindingResult.getFieldError().getDefaultMessage());
            return Result.fail(4001, bindingResult.getFieldError().getDefaultMessage());
        }

        System.out.println(user);
        return Result.succ();
    }
}
