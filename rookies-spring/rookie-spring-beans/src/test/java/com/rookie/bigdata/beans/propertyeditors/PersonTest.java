package com.rookie.bigdata.beans.propertyeditors;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * @Class PersonTest
 * @Description TODO
 * @Author rookie
 * @Date 2023/4/1 1:22
 * @Version 1.0
 */
public class PersonTest {

    @Test
    public void test(){
        ApplicationContext application = new ClassPathXmlApplicationContext("beans/propertyeditors/applicationContext.xml");
        Person person =  application.getBean(Person.class);
        System.out.println(person);
    }

}