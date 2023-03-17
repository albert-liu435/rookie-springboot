package com.rookie.bigdata.listen;

import com.rookie.bigdata.controller.UserController;
import com.rookie.bigdata.event.AnnoEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * @Class EventListenerList
 * @Description 注解的方式进行事件监听
 * @Author rookie
 * @Date 2023/3/17 10:32
 * @Version 1.0
 */

@Configuration
public class EventListenerList {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Async
    @EventListener
    @Order(1)//一个事件多个事监听，同步的情况下，使用@order值越小，执行顺序优先
    public void eventListener1(AnnoEvent annoEvent){
        logger.info("用户注册事件监听1："+annoEvent.getName());

        //开展其他业务，例如发送邮件、短信等
    }

}
