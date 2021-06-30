package com.rookie.bigdata.service;

import com.rookie.bigdata.domain.Student;

/**
 * @ClassName StudentService
 * @Description StudentService
 * @Author rookie
 * @Date 2021/6/29 16:47
 * @Version 1.0
 */
public interface StudentService {


    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    Student add(Student student);


    /**
     * 删除学生
     *
     * @param id
     */
    void delete(Long id);
}
