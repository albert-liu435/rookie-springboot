package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.dao.UserDao;
import com.rookie.bigdata.domain.User;
import com.rookie.bigdata.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 21:52
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserDao userDao;


    @Override
    public Mono<User> save(User user) {
        return userDao.save(user);
    }

    @Override
    public Flux<User> saveAllList(List<User> users) {


        return userDao.saveAll(users);
    }

    @Override
    public Flux<User> saveAllPublisher(Flux<User> userFlux) {
        return userDao.saveAll(userFlux);
    }


    @Override
    public Mono<Void> deleteById(long id) {
        return userDao.deleteById(id);
    }

    @Override
    public Flux<User> findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public Mono<User> update(User user) {
        return findById(user.getId())
                .flatMap(findUser -> {
                    findUser.setName(user.getName());
                    findUser.setAge(user.getAge());
                    // findUser.setId(user.getId());
                    return userDao.save(findUser);
                });

//                .map(em -> user.withId(em.getId()))
//                .flatMap(userDao::save);
    }


    @Override
    public Mono<User> findById(long id) {
        return userDao.findById(id);
    }


    @Override
    public Flux<User> findAll() {
        return userDao.findAll();
    }
}
