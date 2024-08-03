package com.rookie.bigdata.controller;

import com.rookie.bigdata.domain.User;
import com.rookie.bigdata.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author rookie
 * @Description
 * @Date 2024/8/3 21:53
 * @Version 1.0
 */
@RestController
@RequestMapping("/temp/user")
public class UserTemplateController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;


    //增加

    @RequestMapping("saveOne")
    public Mono<User> save(@RequestBody User user) {

        return userService.save(user);

    }

    @RequestMapping("saveAllList")
    public Flux<User> saveAllList(@RequestBody List<User> users) {

        return userService.saveAllList(users);
        // return   Flux.just(users);

    }

    @RequestMapping("saveAllPublisher")
    public Flux<User> saveAllPublisher(@RequestBody List<User> users) {

        Flux<User> userFlux = Flux.fromIterable(users);

        return userService.saveAllPublisher(userFlux);
    }


    //删除
    @RequestMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable("id") final long id) {
        return userService.deleteById(id);

    }


    //更改

    @RequestMapping("/update")
    public Mono<User> update(@RequestBody final User user) {
        return userService.update(user);
    }





//    @RequestMapping(path = "{id}")
//    public Mono<User> findById(@PathVariable long id) {
//        return userService.findById(id)
//                .switchIfEmpty(Mono.error(new NotFoundException("User id " + id + "not found")));
//    }


    @RequestMapping ("find")
    public Flux<User> findByName(@RequestParam("name") String name) {
        return userService.findByName(name);
    }



    //查询所有的用户的信息
    @RequestMapping("/findAll")
    public Flux<User> findAll() {

        return userService.findAll();
    }
}