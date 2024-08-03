package com.rookie.bigdata.beans.factory.support.defaultlistablebeanfactory;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * @Class AnimalTest
 * @Description
 * @Author rookie
 * @Date 2023/4/1 14:47
 * @Version 1.0
 */
public class AnimalTest {

    @Test
    public void test01(){


//        XmlBeanFacotry bf = new XmlBeanFacotry(new ClassPathResource("spring-context.xm1")):


        Resource resource = new ClassPathResource("beans/factory/support/defaultlistablebeanfactory/bean.xml");

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);

//        //向容器中注册MyBeanPostProcessor后处理器
//        beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());
//        //向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
//        beanFactory.addBeanPostProcessor(
//                new MyInstantiationAwareBeanPostProcessor());

        Animal animal1 = (Animal)beanFactory.getBean("animal");

        // Animal animal2 = (Animal)beanFactory.getBean("animal");

        beanFactory.destroySingletons();

    }

}