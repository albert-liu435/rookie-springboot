package com.rookie.bigdata.beans.factory;

import com.rookie.bigdata.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 基于注释实例化Bean
 *
 * @author rookie
 * @version 1.0
 * @date 2020/4/9 22:42
 */
@Configuration
public class Config {

//    @Bean(name = "user",initMethod ="init" )
//    public User buildUser() {
//        User user = new User();
//        user.setAddress("北京");
//        user.setUsername("张三");
//        return user;
//    }
//
//
//    public void print() {
//        System.out.println("打印");
//    }


    @Bean(initMethod = "init")
    public TestInitializingBean test() {
        return new TestInitializingBean();
    }

}
