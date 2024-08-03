package com.rookie.bigdata.controller;

import com.rookie.bigdata.domain.User;
import com.rookie.bigdata.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname TestController
 * @Description
 * @Author rookie
 * @Date 2023/1/13 10:52
 * @Version 1.0
 */
@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getById")
    User get(Integer id){
        return  userMapper.selectByPrimaryKey(id);
    }


    @GetMapping("/findAllUser")
    List<User> findAllUser(){
        return  userMapper.findAllUser();
    }

}