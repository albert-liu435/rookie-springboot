package com.rookie.bigdata.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rookie.bigdata.mapper.UserMapper;
import com.rookie.bigdata.pojo.User;
import com.wky.sensitive.annotation.SensitiveReplace;
import com.wky.sensitive.enums.DataTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Class UserController
 * @Description 加密数据 https://gitee.com/wei_kai_yu/sensitiveReplace
 * @Author rookie
 * @Date 2024/2/28 15:07
 * @Version 1.0
 */

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;




    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public User getUser() throws JsonProcessingException {



        return userMapper.selectByPrimaryKey(1);
    }

    @SensitiveReplace(dataType = DataTypeEnum.COMMON)
    @RequestMapping(value = "/getuser1", method = RequestMethod.GET)
    public User getUser1() throws JsonProcessingException {



        return userMapper.selectByPrimaryKey(1);
    }


    @RequestMapping(value = "/getuser2", method = RequestMethod.GET)
    public User getUser2() throws JsonProcessingException {



        return userMapper.selectByPrimaryKey(1);
    }


    @RequestMapping(value = "/getuser3", method = RequestMethod.GET)
    public User getUser3() throws JsonProcessingException {



        return userMapper.selectByPrimaryKey(1);
    }




}
