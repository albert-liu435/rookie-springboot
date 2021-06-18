package com.rookie.bigdata.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rookie.bigdata.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @ClassName StudentController
 * @Description StudentController
 * @Author rookie
 * @Date 2021/6/17 11:39
 * @Version 1.0
 */
@RestController
public class StudentController {



    @RequestMapping(value = "/getstudent", method = RequestMethod.GET)
    public Student getStudent() throws JsonProcessingException {

        Student student = new Student();

        student.setName("zhagnsan");
        student.setStudentNo(10);


        return student;
    }


    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String postStudent(@RequestBody Student student) {
        return student.toString();
    }

    @RequestMapping("delete/{id}")
    public String deleteCoupon(@PathVariable("id") Integer id) {

        System.out.println(id);

        return "删除成功";


    }

}
