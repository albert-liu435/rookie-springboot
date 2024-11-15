package com.rookie.bigdata.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rookie.bigdata.domain.Student;
import com.rookie.bigdata.second.HttpException;
import com.rookie.bigdata.second.HttpStatusEnum;
import com.rookie.bigdata.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName StudentController
 * @Description StudentController
 * @Author rookie
 * @Date 2021/6/21 9:48
 * @Version 1.0
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public Student getUserFirst() throws Exception {

        Student student = new Student();
        student.setId(100L);
        student.setName("zhagnsan");
        student.setAge(23);
        student.setStudentNo(10);
        student.setBirthDate(new Date());

        if (true)
            throw new Exception();
        return student;
    }


    @RequestMapping(value = "/getUserSecond", method = RequestMethod.GET)
    public Student getUserSecond() throws Exception {

        Student student = new Student();
        student.setId(100L);
        student.setName("zhagnsan");
        student.setAge(23);
        student.setStudentNo(10);
        student.setBirthDate(new Date());

        if (true)
            throw new HttpException(HttpStatusEnum.USER_NOT_EXISTS);        return student;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getHello(@PathVariable(value = "name") String name) {
        return "Hello " + name;
    }

}
