package com.rookie.bigdata.controller;

import com.rookie.bigdata.domain.User;
import com.rookie.bigdata.event.AnnoEvent;
import com.rookie.bigdata.event.NoticeEvent;
import com.rookie.bigdata.event.SendEmailEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName UserController
 * @Description UserController
 * @Author rookie
 * @Date 2021/6/17 16:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/event")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * http://localhost:8080/event/getuser
     *
     * @return
     */
    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public User getUser() {

        User user = new User();
        user.setName("zhangsan");
        eventPublisher.publishEvent(new SendEmailEvent(this, user));
//        eventPublisher.publishEvent(new SendEmailEvent( "abc",user));
        return user;

    }


    @RequestMapping(value = "/getuser2", method = RequestMethod.GET)
    public User getUser2() {

        User user = new User();
        user.setName("zhangsan");

        return user;

    }


    /**
     * http://localhost:8080/event/notice/abc
     *
     * @param message
     */
//    @GetMapping("/event/notice/{message}")
    @RequestMapping(value = "/notice/{message}", method = RequestMethod.GET)
    public String notice(@PathVariable(name = "message") String message) {

        logger.info("begin >>>>>>");
        eventPublisher.publishEvent(new NoticeEvent(message));
        logger.info("end <<<<<<");
        return "sucess";
    }


    /**
     * http://localhost:8080/event/anno
     * 注解方式监听器
     *
     * @return
     */
    @RequestMapping(value = "/anno", method = RequestMethod.GET)
    public String anno() {

        AnnoEvent annoEvent = new AnnoEvent();
        annoEvent.setName("hello");
        logger.info("begin >>>>>>");
        eventPublisher.publishEvent(annoEvent);
        logger.info("end <<<<<<");
        return "sucess";
    }

}
