//package com.rookie.bigdata.service.impl;
//
//import com.rookie.bigdata.common.CommonResult;
//import com.rookie.bigdata.domain.Course;
//import com.rookie.bigdata.domain.Student;
//import com.rookie.bigdata.service.StudentService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * @ClassName StudentServiceImplTest
// * @Description StudentServiceImplTest
// * @Author rookie
// * @Date 2021/6/29 17:03
// * @Version 1.0
// */
//@SpringBootTest
//class StudentServiceImplTest {
//
//    @Autowired
//    private StudentService studentService;
//
//    @Test
//    void add() {
//
//        Student student=new Student();
//        student.setId(1L);
//        student.setStuNo(123456L);
//        student.setBirthDate(new Date());
//        student.setAge(23);
//        student.setSchool("北京家里蹲小学");
//        student.setUsername("张三");
//        student.setAddress("北京市通州区永顺镇小区");
//
//        List<Course> list=new ArrayList<>();
//        Course course=new Course();
//
//        course.setId(1L);
//        course.setCourseName("数学");
//        list.add(course);
//
//        student.setCourseList(list);
//
//        Student add = studentService.add(student);
//        System.out.println(add);
//    }
//
//
//    @Test
//    public void delete(){
//        studentService.delete(1L);
//
//    }
//}