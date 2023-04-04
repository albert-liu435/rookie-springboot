package com.rookie.bigdata.beans.factory.factorybean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Class CarFactoryBeanTest
 * @Description TODO
 * @Author rookie
 * @Date 2023/4/1 13:24
 * @Version 1.0
 */
public class CarFactoryBeanTest {

    @Test
    public void getObject() {

        ApplicationContext application = new ClassPathXmlApplicationContext("beans/factory/factorybean/applicationContext.xml");
        Car car =  (Car) application.getBean("car");
        System.out.println(car);

        Object bean = application.getBean("&car");
        System.out.println(bean);
    }
}