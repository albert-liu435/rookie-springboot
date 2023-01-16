package com.rookie.bigdata.mapper;

import com.rookie.bigdata.domain.TabUser;

import java.util.List;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Author rookie
 * @Date 2023/1/13 10:54
 * @Version 1.0
 */
public interface UserMapper {

    /**
     * 插入一条记录
     *
     * @param record 实体对象
     * @return 更新条目数
     */
    int insert(TabUser record);

    /**
     * 动态插入一条记录
     *
     * @param record 实体对象
     * @return 更新条目数
     */
    int insertSelective(TabUser record);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 实体对象
     */
    TabUser selectByPrimaryKey(Long id);

    /**
     * 批量插入
     *
     * @param list 插入集合
     * @return 插入数量
     */
    int insertForeach(List<TabUser> list);


    /**
     * 根据主键动态更新记录
     *
     * @param record 实体对象
     * @return 更新条目数
     */
    int updateByPrimaryKeySelective(TabUser record);
}
