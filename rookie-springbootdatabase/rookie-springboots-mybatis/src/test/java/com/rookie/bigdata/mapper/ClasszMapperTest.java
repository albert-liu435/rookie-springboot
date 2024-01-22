package com.rookie.bigdata.mapper;

import com.rookie.bigdata.pojo.Classz;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Class ClassMapperTest
 * @Description
 * @Author rookie
 * @Date 2024/1/19 17:31
 * @Version 1.0
 */

@SpringBootTest
//@ActiveProfiles("test")
class ClasszMapperTest {

    @Autowired
    private ClasszMapper classzMapper;

    @Test
    void selectByIdStep2() {
    }

    @Test
    void selectByCollection() {

        Classz aClass = classzMapper.selectByCollection(1000);
        System.out.println(aClass);
    }

    @Test
    void selectByStep1(){
        Classz aClass = classzMapper.selectByStep1(1000);
        System.out.println(aClass);
    }
}
