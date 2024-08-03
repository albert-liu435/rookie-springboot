package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.dao.UserDao;
import com.rookie.bigdata.domain.User;
import com.rookie.bigdata.exception.NotFoundException;
import com.rookie.bigdata.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Query;
import org.springframework.data.relational.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.data.relational.core.query.Criteria.where;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 21:55
 * @Version 1.0
 */
@Service
public class UserTemplateServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserDao userDao;

    @Autowired
    private R2dbcEntityTemplate entityTemplate;


    @Override
    public Mono<User> save(User user) {
//        return userDao.save(user);

        return entityTemplate.insert(user);
    }

    @Override
    public Flux<User> saveAllList(List<User> users) {


        return Flux.fromIterable(users)
                .flatMap(user -> {
                    return entityTemplate.insert(user);
                });
        // return userDao.saveAll(users);
    }

    @Override
    public Flux<User> saveAllPublisher(Flux<User> userFlux) {


        return Flux.from(userFlux)
                .flatMap(user -> {
                    return entityTemplate.insert(user);
                });

//        return userDao.saveAll(userFlux);
    }


    @Override
    public Mono<Void> deleteById(long id) {


        return entityTemplate
                .delete(Query.query(where("id").is(id)), User.class)
                .then();
        //  return userDao.deleteById(id);
    }

    @Override
    public Flux<User> findByName(String name) {

        Query query = Query.query(where("name").is(name));

        return entityTemplate.select(query, User.class);
        // return userDao.findByName(name);
    }

    @Override
    public Mono<User> update(User user) {


//        Mono<Integer> update=  entityTemplate.update(User.class)
//                .matching(Query.query(where("id").is(user.getId())))
//                .apply(Update.update("id", user.getId())
//                        .set("name", user.getName())
//                        .set("age", user.getAge()));

        //  return entityTemplate.update(user);

//        return findById(user.getId())
//                .flatMap(findUser -> {
//                    return entityTemplate.update(user);
//                });


        Mono<Long> update = entityTemplate.update(
                Query.query(where("id").is(user.getId())),
                Update.update("id", user.getId())
                        .set("name", user.getName())
                        .set("age", user.getAge()),
                User.class
        );

        update.subscribe(System.out::println);

        return Mono.just(user);
    }


    @Override
    public Mono<User> findById(long id) {
        // return userDao.findById(id);
        Query query = Query.query(where("id").is(id));
        return entityTemplate.select(query, User.class)
                .next()
                .switchIfEmpty(Mono.error(new NotFoundException("User id \"" + id + "\"not found")));
    }


    @Override
    public Flux<User> findAll() {
        // return userDao.findAll();
        final Query query = Query.empty();
        return entityTemplate.select(query, User.class);

    }
}