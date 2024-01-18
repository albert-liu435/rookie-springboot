package com.rookie.bigdata.mapper;

import com.rookie.bigdata.pojo.Car;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class CarMapperTest
 * @Description
 * @Author rookie
 * @Date 2024/1/16 18:09
 * @Version 1.0
 */

@SpringBootTest
//@ActiveProfiles("test")
class CarMapperTest {

    public static final Logger logger = LoggerFactory.getLogger(CarMapperTest.class);


    @Autowired
    private DataSource dataSource;

    @Autowired
    private CarMapper carMapper;


    @Test
    void testDataSource()throws Exception{
        System.out.println(dataSource.getConnection());
    }





    @Test
    void insert(){
        Car car = new Car(null,"111","奔驰",30.00,"2022-10-2","新能源");
        int count = carMapper.insert(car);
        System.out.println((count == 1 ? "插入成功" : "插入失败"));
    }
    @Test
    void insertCarUseGeneratedKeys(){
        Car car = new Car(null,"111","奔驰",30.00,"2022-10-2","新能源");
        int count = carMapper.insert(car);
        System.out.println((count == 1 ? "插入成功" : "插入失败"));
    }



    @Test
    void delete(){
        int count = carMapper.delete(42L);
        System.out.println((count == 1 ? "删除成功" : "删除失败"));
    }


    @Test
    void update(){
        Car car = new Car(41L,"1111","奔驰",30.00,"2022-11-2","新能源");
        int count = carMapper.update(car);
        System.out.println((count == 1 ? "更新成功" : "更新失败"));
    }


    @Test
    void getAll() {

        List<Car> all = carMapper.getAll();
        System.out.println(all);
    }
}
