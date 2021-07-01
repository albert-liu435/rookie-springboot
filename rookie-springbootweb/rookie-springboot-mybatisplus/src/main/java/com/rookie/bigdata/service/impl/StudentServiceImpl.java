package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.entity.Student;
import com.rookie.bigdata.mapper.StudentMapper;
import com.rookie.bigdata.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rookie
 * @since 2021-06-25
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
