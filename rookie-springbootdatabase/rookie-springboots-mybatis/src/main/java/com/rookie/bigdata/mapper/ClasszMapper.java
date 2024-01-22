package com.rookie.bigdata.mapper;

import com.rookie.bigdata.pojo.Classz;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Class ClassMapper
 * @Description
 * @Author rookie
 * @Date 2024/1/19 17:08
 * @Version 1.0
 */
@Mapper
public interface ClasszMapper {
    /**
     * 分步查询第二步：根据cid获取班级信息
     *
     * @param id
     * @return
     */
    Classz selectByIdStep2(Integer id);


    /**
     * 第一种方式：collection
     *
     * @param cid
     * @return
     */
    Classz selectByCollection(Integer cid);



    /**
     * 分步查询第一步：根据班级编号获取班级信息
     * @param cid
     * @return
     */
    Classz selectByStep1(Integer cid);
}
