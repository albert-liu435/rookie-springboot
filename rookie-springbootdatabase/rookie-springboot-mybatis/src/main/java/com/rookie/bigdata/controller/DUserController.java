package com.rookie.bigdata.controller;

import com.rookie.bigdata.mapper.DUserMapper;
import com.rookie.bigdata.pojo.DUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Class DUserController
 * @Description
 * @Author rookie
 * @Date 2024/11/13 16:53
 * @Version 1.0
 */
@RestController
public class DUserController {

    @Autowired
    private DUserMapper userMapper;

    @GetMapping("/getById")
    DUser get(Integer id){
        return  userMapper.selectByPrimaryKey(id);
    }


    @GetMapping("/findAllUser")
    List<DUser> findAllUser(){
        return  userMapper.findAllUser();
    }
}
