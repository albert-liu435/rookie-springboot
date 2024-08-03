package com.rookie.bigdata.service;

import com.rookie.bigdata.vo.UserVO;

import java.util.List;

/**
 * @Classname UserService
 * @Description
 * @Author rookie
 * @Date 2023/1/13 16:37
 * @Version 1.0
 */
public interface UserService {

    /**
     *  批量 保存用户信息
     * @param userVOList
     */
    String  insertForeach(List<UserVO> userVOList);

    /**
     *  单个 保存用户信息
     * @param userVO
     */
    String  saveOne(UserVO userVO);

}