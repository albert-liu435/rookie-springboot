package com.rookie.bigdata.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rookie.bigdata.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName StudentController
 * @Description StudentController
 * @Author rookie
 * @Date 2021/6/17 14:25
 * @Version 1.0
 */
@RestController
public class StudentController {


    @RequestMapping(value = "/serialization", method = RequestMethod.GET)
    public Student serialization() throws JsonProcessingException {

        Student student = new Student();
        student.setId(100L);
        student.setName("zhagnsan");
        student.setAge(23);
        student.setStudentNo(10);
        student.setBirthDate(new Date());


        return student;
    }


    @RequestMapping(value = "/deserialization", method = RequestMethod.PUT)
    public String deserialization(@RequestBody Student student) {
        return student.toString();
    }

}
