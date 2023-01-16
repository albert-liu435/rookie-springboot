//package com.rookie.bigdata.controller;
//
//import com.rookie.bigdata.common.CommonResult;
//import com.rookie.bigdata.domain.Course;
//import com.rookie.bigdata.domain.Student;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * @ClassName StudentControllerTest
// * @Description StudentControllerTest
// * @Author rookie
// * @Date 2021/6/29 16:45
// * @Version 1.0
// */
//@SpringBootTest
//@AutoConfigureMockMvc
//class StudentControllerTest {
//
//    @Autowired
//    private StudentController controller;
//
//    @Autowired
//    private MockMvc mvc;
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
//        CommonResult<Student> add = controller.add(student);
//        System.out.println(add);
//
//
//        // 模拟
////        MvcResult mvcResult = mvc.perform(get("/" + NAME))
////                .andExpect(status().isOk())
////                .andExpect(content().string("Hello " + NAME))
////                .andReturn();
////
////
////        System.out.println(mvcResult.getResponse());
//    }
//}