package com.rookie.bigdata.mapper;

import com.rookie.bigdata.pojo.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Class CarMapper
 * @Description https://blog.csdn.net/m0_65563175/article/details/127354442
 * @Author rookie
 * @Date 2024/1/16 18:05
 * @Version 1.0
 */
@Mapper//让容器加载这个Bean
public interface CarMapper {


    /**
     * 插入汽车
     *
     * @param car
     * @return
     */
    int insert(Car car);


    /**
     * 按id删除车辆信息
     *
     * @param id
     * @return
     */
    int delete(Long id);


    /**
     * 更新车辆信息
     *
     * @param car
     * @return
     */
    int update(Car car);

    /**
     * 查询所有的汽车
     *
     * @return
     */
    List<Car> getAll();


    /**
     * 按照排序进行查询
     *
     * @param ascOrDesc
     * @return
     */
    List<Car> selectAllByAscOrDesc(String ascOrDesc);


    /**
     * 根据汽车类型获取汽车信息
     *
     * @param carType
     * @return
     */
    List<Car> selectByCarType(String carType);

    /**
     * 根据id批量删除
     *
     * @param ids
     * @return
     */
    int deleteBatch(String ids);


    /**
     * 根据汽车品牌进行模糊查询
     *
     * @param brand
     * @return
     */
    List<Car> selectByBrandLike(String brand);


    /**
     * 插入车辆信息并且使用生成的主键值
     *
     * @param car
     * @return
     */
    int insertCarUseGeneratedKeys(Car car);
}
