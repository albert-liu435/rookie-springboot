package com.rookie.bigdata.service.impl;

import com.google.common.collect.Lists;
import com.rookie.bigdata.domain.TabUser;
import com.rookie.bigdata.mapper.UserMapper;
import com.rookie.bigdata.service.UserService;
import com.rookie.bigdata.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Description
 * @Author rookie
 * @Date 2023/1/13 16:37
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String insertForeach(List<UserVO> userVOList) {
        //实体转换
        List<TabUser> tabUserList = Lists.newArrayListWithCapacity(userVOList.size());
        for (UserVO userVO : userVOList) {
            TabUser tabUser = build(userVO);
            tabUserList.add(tabUser);
        }
        //批量插入数据
        userMapper.insertForeach(tabUserList);
        return "保存成功";
    }

    @Override
    public String saveOne(UserVO userVO) {
        TabUser tabUser = build(userVO);
        userMapper.insert(tabUser);
        return "保存成功";
    }

    /**
     * 实体转换
     */
    private TabUser build(UserVO vo) {
        TabUser tabUser = new TabUser();
        tabUser.setName(vo.getName());
        tabUser.setSex(vo.getSex());
        tabUser.setAge(vo.getAge());
        tabUser.setCreateTime(new Date());
        tabUser.setUpdateTime(new Date());
        tabUser.setStatus(1);
        return tabUser;

    }
}
