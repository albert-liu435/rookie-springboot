package com.rookie.bigdata.controller;

import com.rookie.bigdata.domain.User;
import com.rookie.bigdata.event.SendEmailEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName UserController
 * @Description UserController
 * @Author rookie
 * @Date 2021/6/17 16:12
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public User getUser() {

        User user = new User();
        user.setName("zhangsan");
        eventPublisher.publishEvent(new SendEmailEvent(this, user));
        eventPublisher.publishEvent(new SendEmailEvent( "abc",user));
        return user;

    }


    @RequestMapping(value = "/getuser2", method = RequestMethod.GET)
    public User getUser2() {

        User user = new User();
        user.setName("zhangsan");

        return user;

    }

}
