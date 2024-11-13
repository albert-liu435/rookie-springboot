package com.rookie.bigdata.mapper;

import com.rookie.bigdata.pojo.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Class LogMapper
 * @Description
 * @Author rookie
 * @Date 2024/1/17 16:40
 * @Version 1.0
 */
@Mapper
public interface LogMapper {


    /**
     * 根据日志日期查询不同的表，获取表中不同的日志
     *
     * @param date
     * @return
     */
//    List<Log> selectAllByTable(String date);
}
