package com.rookie.bigdata.mapper;

import com.rookie.bigdata.pojo.Car;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Class CarMapper
 * @Description https://blog.csdn.net/m0_65563175/article/details/127354442
 * @Author rookie
 * @Date 2024/1/16 18:05
 * @Version 1.0
 */
//@Mapper//让容器加载这个Bean
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


    /**
     * 根据id获取汽车信息，将汽车信息放到Map集合中
     * @param id
     * @return
     */
    Map<String,Object> selectByIdRetMap(Long id);

    /**
     * 查询所有的Car信息返回一个放Map集合的List集合
     * @return
     */
    List<Map<String,Object>> selectAllRetListMap();


    /**
     * 查询所有的Car返回一个大Map结合
     * Map集合的key是每条记录的主键值
     * Map集合的value的每条记录
     * @return
     */
    @MapKey("id")
    Map<Long,Map<String,Object>> selectAllRetMap();


    /**
     * 查询所有的Car信息，使用resultMap标签进行结果映射
     * @return
     */
    List<Car> selectAllByResultMap();


    List<Car> selectAllByResultMapTwo();

    /**
     * 获取Car的总记录条数
     * @return
     */
    Long selectTotal();

    /**
     * 多条件查询
     * @param brand 品牌
     * @param guidePrice 指导价
     * @param carType 汽车类型
     * @return
     */
    List<Car> selectByMultiCondition(@Param("brand") String brand,
                                     @Param("guidePrice") Double guidePrice,
                                     @Param("carType") String carType);


    /**
     * 使用where标签，让where子句更加的智能
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithWhere(@Param("brand") String brand,
                                              @Param("guidePrice") Double guidePrice,
                                              @Param("carType") String carType);



    /**
     * 使用trim标签
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithTrim(@Param("brand") String brand,
                                             @Param("guidePrice") Double guidePrice,
                                             @Param("carType") String carType);


    /**
     * 使用set标签进行更新
     * @param car
     * @return
     */
    int updateBySet(Car car);


    /**
     * 使用choose when otherwise标签
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByChoose(@Param("brand") String brand,
                             @Param("guidePrice") Double guidePrice,
                             @Param("carType") String carType);



    /**
     * 根据id批量删除 foreach
     * @param ids
     * @return
     */
    int deleteByIds(@Param("ids") Long[] ids);



    /**
     * 批量插入，一次插入多条Car信息
     * @param cars
     * @return
     */
    int insertBatch(@Param("cars") List<Car> cars);


    List<Car> selectAll();


    /**
     * 根据id获取Car信息
     * @param id
     * @return
     */
    Car selectById(Long id);


}
