package com.rookie.bigdata.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rookie.bigdata.common.CommonResult;
import com.rookie.bigdata.domain.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @Date 2021/6/17 11:39
 * @Version 1.0
 */
@Api(tags = "StudentController", description = "学生信息管理")
@RestController
public class StudentController {


    @Autowired
    private ObjectMapper mapper;

    @ApiOperation(value = "添加学生信息")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public CommonResult<Student> addStudent(@RequestBody Student student) throws JsonProcessingException {

        System.out.println(student);

        return CommonResult.success(student);
    }


    @RequestMapping(value = "/deserialization", method = RequestMethod.PUT)
    public String deserialization(@RequestBody Student student) {
        return student.toString();
    }

}
