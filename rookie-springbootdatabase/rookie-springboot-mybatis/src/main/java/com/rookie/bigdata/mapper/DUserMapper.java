package com.rookie.bigdata.mapper;

import com.rookie.bigdata.pojo.DUser;

import java.util.List;

/**
 * @Class DUserMapper
 * @Description
 * @Author rookie
 * @Date 2024/11/13 16:52
 * @Version 1.0
 */
public interface DUserMapper {


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 实体对象
     */
    DUser selectByPrimaryKey(Integer id);

    /**
     * 获取所有用户信息
     *
     * @return 实体对象
     */
    List<DUser> findAllUser();
}
