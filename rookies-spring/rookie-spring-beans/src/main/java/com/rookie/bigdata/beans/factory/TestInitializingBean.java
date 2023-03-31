package com.rookie.bigdata.beans.factory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Class TestInitializingBean
 * @Description TODO
 * @Author rookie
 * @Date 2023/3/31 23:54
 * @Version 1.0
 */
//@Component
public class TestInitializingBean implements InitializingBean {
    public TestInitializingBean() {
        System.out.println("我是TestInitializingBean构造方法执行...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("我是TestInitializingBean afterPropertiesSet方法执行...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("我是 TestInitializingBean postConstruct方法执行...");
    }

    public void init() {
        System.out.println("我是TestInitializingBean init方法执行...");
    }

}
