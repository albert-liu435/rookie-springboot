package com.rookie.bigdata.dao;

import com.rookie.bigdata.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 21:50
 * @Version 1.0
 */
public interface UserDao extends ReactiveCrudRepository<User, Long> {

    Flux<User> findByName(String name);



}
