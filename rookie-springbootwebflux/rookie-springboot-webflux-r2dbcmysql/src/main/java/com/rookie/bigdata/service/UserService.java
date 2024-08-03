package com.rookie.bigdata.service;

import com.rookie.bigdata.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 21:51
 * @Version 1.0
 */
public interface UserService {


    Flux<User> findAll();

    Mono<User> save(User user);

    Flux<User> saveAllList(List<User> users);

    Flux<User> saveAllPublisher(Flux<User> userFlux);

    Mono<User> findById(long id);

    Mono<Void> deleteById(long id);

    Flux<User> findByName(String name);

    Mono<User> update(User user);
}
