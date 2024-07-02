package com.rookie.bigdata.controller;

import com.alibaba.fastjson2.JSONObject;
import com.rookie.bigdata.domain.User;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description UserController
 * @Author rookie
 * @Date 2021/6/17 16:12
 * @Version 1.0
 */
@RestController
public class UserController {


    /**
     * http://localhost:8081/getuser
     *
     * @return
     */
    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public User getUser() {

        User user = new User();
        user.setName("zhangsan");

        return user;

    }


    @RequestMapping(value = "/getuser2", method = RequestMethod.GET)
    public User getUser2() {

        User user = new User();
        user.setName("zhangsan");

        return user;

    }


    /**
     * 1、get方法测试首尾去空格
     */
    @GetMapping(value = "/getTrim")
    public String getTrim(@RequestParam String username, @RequestParam String phone) {
        return username + "&" + phone;
    }

    /**
     * 2、post方法测试首尾去空格
     */
    @PostMapping(value = "/postTrim")
    public String postTrim(@RequestParam String username, @RequestParam String phone) {
        return username + "&" + phone;
    }

    /**
     * 3、post方法 Content-Type为application/json 测试首尾去空格
     */
    @PostMapping(value = "/postJsonTrim")
    public String helloUser(@RequestBody User user) {
        return JSONObject.toJSONString(user);
    }


}
