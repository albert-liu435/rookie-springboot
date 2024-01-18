package com.rookie.bigdata.mapper;

import com.rookie.bigdata.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Class StudentMapperTest
 * @Description
 * @Author rookie
 * @Date 2024/1/18 9:30
 * @Version 1.0
 */
@SpringBootTest
//@ActiveProfiles("test")
class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void selectById() {
        List<Student> students = studentMapper.selectById(1L);
        for (Student student : students) {
            System.out.println(student);
        }


    }

    @Test
    void selectByName() {
        List<Student> students = studentMapper.selectByName("张三");
        for (Student student : students) {
            System.out.println(student);
        }


    }

    @Test
    void selectByBirth() {

        List<Student> students = studentMapper.selectByBirth("2023-01-18");
        for (Student student : students) {
            System.out.println(student);
        }

    }

    @Test
    void selectBySex() {
        List<Student> students = studentMapper.selectBySex('男');
        for (Student student : students) {
            System.out.println(student);
        }

    }


    @Test
    void insertStudentByMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("姓名","王五");
        map.put("年龄","20");
        map.put("身高",161);
        map.put("性别",'男');
        map.put("生日",new Date());
        int i=studentMapper.insertStudentByMap(map);
        if(i>0){
            System.out.println("增加成功");
        }
    }



}
