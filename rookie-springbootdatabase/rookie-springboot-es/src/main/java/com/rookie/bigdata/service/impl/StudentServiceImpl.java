package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.domain.Student;
import com.rookie.bigdata.repository.StudentRepository;
import com.rookie.bigdata.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName StudentServiceImpl
 * @Description StudentServiceImpl
 * @Author rookie
 * @Date 2021/6/29 16:48
 * @Version 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student add(Student student) {

        Student save = studentRepository.save(student);


        return save;
    }

    @Override
    public void delete(Long id) {

        studentRepository.deleteById(id);


    }


}
