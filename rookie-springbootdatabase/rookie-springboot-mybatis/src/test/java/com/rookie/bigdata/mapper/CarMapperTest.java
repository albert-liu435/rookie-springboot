package com.rookie.bigdata.mapper;

import com.rookie.bigdata.pojo.Car;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @Class CarMapperTest
 * @Description
 * @Author rookie
 * @Date 2024/1/16 18:09
 * @Version 1.0
 */

@SpringBootTest
@ActiveProfiles("dev")
class CarMapperTest {

    public static final Logger logger = LoggerFactory.getLogger(CarMapperTest.class);


    @Autowired
    private DataSource dataSource;

    @Autowired
    private CarMapper carMapper;


    @Test
    void testDataSource() throws Exception {
        System.out.println(dataSource.getConnection());
    }


    @Test
    void insert() {
        Car car = new Car(null, "111", "奔驰", 30.00, "2022-10-2", "新能源");
        int count = carMapper.insert(car);
        System.out.println((count == 1 ? "插入成功" : "插入失败"));
    }

    @Test
    void insertCarUseGeneratedKeys() {
        Car car = new Car(null, "111", "奔驰", 30.00, "2022-10-2", "新能源");
        int count = carMapper.insert(car);
        System.out.println((count == 1 ? "插入成功" : "插入失败"));
    }


    @Test
    void delete() {
        int count = carMapper.delete(42L);
        System.out.println((count == 1 ? "删除成功" : "删除失败"));
    }


    @Test
    void update() {
        Car car = new Car(41L, "1111", "奔驰", 30.00, "2022-11-2", "新能源");
        int count = carMapper.update(car);
        System.out.println((count == 1 ? "更新成功" : "更新失败"));
    }


    @Test
    void getAll() {

        List<Car> all = carMapper.getAll();
        System.out.println(all);
    }


    @Test
    void selectByIdRetMap() {
        Map<String, Object> map = carMapper.selectByIdRetMap(41L);
        System.out.println(map);
    }

    @Test
    void selectAllRetListMap() {
        List<Map<String, Object>> listMap = carMapper.selectAllRetListMap();
        for (Map<String, Object> map : listMap) {
            System.out.println(map);
        }
        System.out.println(listMap);
    }


    @Test
    void selectAllRetMap() {
        Map<Long, Map<String, Object>> listMap = carMapper.selectAllRetMap();
        for (Long aLong : listMap.keySet()) {
            Map<String, Object> map = listMap.get(aLong);
            System.out.println(map);
        }
        System.out.println(listMap);
    }

    @Test
    void selectAllByResultMap() {
        List<Car> cars = carMapper.selectAllByResultMap();
        for (Car car : cars) {
            System.out.println(car);
        }
    }


    @Test
    void selectAllByResultMapTwo() {
        List<Car> cars = carMapper.selectAllByResultMapTwo();
        for (Car car : cars) {
            System.out.println(car);
        }
    }


    @Test
    void selectTotal() {
        Long total = carMapper.selectTotal();
        logger.info("总的car数量：{}", total);
    }


    @Test
    void selectByMultiCondition() {

        List<Car> cars = carMapper.selectByMultiCondition("", 10.00, "新");
        for (Car car : cars) {
            logger.info("car为： {}", car);
        }

    }


    @Test
    void selectByMultiConditionWithWhere() {
        List<Car> cars = carMapper.selectByMultiCondition("", 10.00, "新");
        for (Car car : cars) {
            logger.info("car为： {}", car);
        }
    }


    @Test
    void selectByMultiConditionWithTrim() {
        List<Car> cars = carMapper.selectByMultiConditionWithTrim("奔", null, "");
        for (Car car : cars) {
            logger.info("car为： {}", car);
        }
    }

    @Test
    void updateBySet() {
        Car car = new Car(43L, "112", null, null, "2022-10-09", null);
        int i = carMapper.updateBySet(car);
        if (i > 0) {
            System.out.println("更新成功");
        }
    }


    @Test
    void selectByChoose() {
        List<Car> cars = carMapper.selectByChoose("奔", 10.0, "");
        for (Car car : cars) {
            logger.info("car为： {}", car);
        }
    }


    @Test
    void deleteByIds() {
        Long[] ids = {100L, 101L, 102L};

        int i = carMapper.deleteByIds(ids);
        if (i > 0) {
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    void insertBatch(){

    }

    @Test
    void selectAll(){
        List<Car> cars = carMapper.selectAll();
        for (Car car : cars) {
            System.out.println(car);
        }
    }


    /**
     *  我们会发现在SpringBoot结合MyBatis中没有自动开启一级缓存机制，查询相同的id使用了两次查询。但是我们在方法名上添加@Transactional注解就会发现控制台发生了变化：只执行了一次查询语句。也就是说添加了@Transactional注解就能够使用一级缓存，换言之就是同一个SqlSession。
     * ————————————————
     * 版权声明：本文为CSDN博主「字节尚未跳动」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/m0_65563175/article/details/127354442
     */


    @Test
    @Transactional
    void selectById(){
        //一、一级缓存
        Car car = carMapper.selectById(43L);
        System.out.println(car);
        Car car1 = carMapper.selectById(43L);
        System.out.println(car1);

    }


//    <!--        全局性地开启或关闭所有映射器配置文件中已配置的任何缓存。二级缓存-->
//        <setting name="cacheEnabled" value="true"/>


    @Test
    @Transactional
    void selectById2(){
        //一、一级缓存
        Car car = carMapper.selectById(43L);
        System.out.println(car);
        Car car1 = carMapper.selectById(43L);
        System.out.println(car1);

    }

}
