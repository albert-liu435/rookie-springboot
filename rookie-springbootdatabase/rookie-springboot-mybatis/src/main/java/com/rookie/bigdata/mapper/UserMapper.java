package com.rookie.bigdata.mapper;

import com.rookie.bigdata.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Author rookie
 * @Date 2023/1/13 10:54
 * @Version 1.0
 */
@Mapper
public interface UserMapper{


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 实体对象
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 获取所有用户信息
     *
     * @return 实体对象
     */
    List<User> findAllUser();


}
