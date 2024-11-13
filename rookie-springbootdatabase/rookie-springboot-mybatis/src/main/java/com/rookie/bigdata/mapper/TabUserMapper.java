package com.rookie.bigdata.mapper;

import com.rookie.bigdata.pojo.TabUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname UserMapper
 * @Description
 * @Author rookie
 * @Date 2023/1/13 10:54
 * @Version 1.0
 */
//@Mapper
public interface TabUserMapper {

    //增、删、改、查


    /**
     * 插入一条记录
     *
     * @param tabUser 实体对象
     * @return 更新条目数
     */
    int insert(TabUser tabUser);

    /**
     * 动态插入一条记录
     *
     * @param tabUser 实体对象
     * @return 更新条目数
     */
    int insertSelective(TabUser tabUser);


    /**
     * 批量插入
     *
     * @param list 插入集合
     * @return 插入数量
     */
    int insertForeach(List<TabUser> list);


    /**
     * 删除 tabUser
     *
     * @param tabUser
     * @return
     */
    int deleteTabUser(TabUser tabUser);


    /**
     * 根据主键动态更新记录
     *
     * @param tabUser 实体对象
     * @return 更新条目数
     */
    int updateByPrimaryKeySelective(TabUser tabUser);


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 实体对象
     */
    TabUser selectByPrimaryKey(Long id);


    /**
     * 获取所有用户信息
     *
     * @return 实体对象
     */
    List<TabUser> findAllUser();


}
