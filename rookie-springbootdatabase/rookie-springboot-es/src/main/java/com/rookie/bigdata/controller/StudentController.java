package com.rookie.bigdata.controller;

import com.rookie.bigdata.common.CommonResult;
import com.rookie.bigdata.domain.Student;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName StudentController
 * @Description StudentController
 * @Author rookie
 * @Date 2021/6/29 16:38
 * @Version 1.0
 */
@RequestMapping
public class StudentController {


    @RequestMapping(value = "add")
    public CommonResult<Student> add(@RequestBody Student student) {


        return CommonResult.success(student);

    }
}
