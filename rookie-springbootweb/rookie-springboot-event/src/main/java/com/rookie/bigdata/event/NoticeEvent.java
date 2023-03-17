package com.rookie.bigdata.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

/**
 * @Class NoticeEvent
 * @Description TODO
 * @Author rookie
 * @Date 2023/3/17 9:47
 * @Version 1.0
 */
public class NoticeEvent extends ApplicationEvent {

    private static final Logger logger = LoggerFactory.getLogger(NoticeEvent.class);

    /**
     * 接受信息
     */
    private String message;

    public NoticeEvent( String message) {
        super(message);
        this.message = message;
        logger.info("add event success! message: {}", message);
    }

    public String getMessage() {
        return message;
    }

}
