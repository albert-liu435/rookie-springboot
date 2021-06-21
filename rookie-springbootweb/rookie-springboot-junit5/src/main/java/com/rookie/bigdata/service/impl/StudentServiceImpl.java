package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.domain.Student;
import com.rookie.bigdata.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName StudentServiceImpl
 * @Description StudentServiceImpl
 * @Author rookie
 * @Date 2021/6/21 9:51
 * @Version 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public Student getUser() {

        Student student = new Student();
        student.setId(100L);
        student.setName("zhagnsan");
        student.setAge(23);
        student.setStudentNo(10);
        student.setBirthDate(new Date());

        return student;
    }
}
