package com.rookie.bigdata.repository;

import com.rookie.bigdata.domain.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName StudentRepository
 * @Description StudentRepository
 * @Author rookie
 * @Date 2021/6/29 16:35
 * @Version 1.0
 */
//@Repository
public interface StudentRepository extends ElasticsearchRepository<Student, Long> {





}
