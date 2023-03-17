package com.rookie.bigdata.listen;

import com.rookie.bigdata.event.NoticeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Class NoticeListener
 * @Description https://juejin.cn/post/6844904037133844494  异步事件监听
 * @Author rookie
 * @Date 2023/3/17 9:50
 * @Version 1.0
 */
@Component
public class NoticeListener implements ApplicationListener<NoticeEvent> {


    private static final Logger logger = LoggerFactory.getLogger(NoticeListener.class);


    @Async
    @Override
    public void onApplicationEvent(NoticeEvent event) {
        logger.info("listener get event,sleep 2 second...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        logger.info("event message is : {}", event.getMessage());


    }
}
