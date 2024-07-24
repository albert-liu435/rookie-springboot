package com.rookie.bigdata.event;

import com.rookie.bigdata.domain.User;
import org.springframework.context.ApplicationEvent;

/**
 * @Class SendEmailEvent
 * @Description
 * @Author rookie
 * @Date 2023/3/16 18:30
 * @Version 1.0
 */
public class SendEmailEvent extends ApplicationEvent {
    private User user;



    public SendEmailEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SendEmailEvent{" +
                "user=" + user +
                '}';
    }

}
