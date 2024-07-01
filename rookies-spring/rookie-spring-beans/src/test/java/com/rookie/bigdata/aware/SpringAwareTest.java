package com.rookie.bigdata.aware;

import com.rookie.bigdata.domain.User;
import com.rookie.bigdata.domain.User1;
import com.rookie.bigdata.domain.User2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;


/**
 * @author rookie
 * @version 1.0
 * @date 2020/3/21 23:27
 */
public class SpringAwareTest {



    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/aware/spring-beanaware.xml");



        User1 user1=(User1)applicationContext.getBean("user1");
        System.out.println(user1);

        User2 user2=(User2)applicationContext.getBean("user2");
        System.out.println(user2);
    }

    @Test
    public void test3(){
        StandardEnvironment standardEnvironment=new StandardEnvironment();
        System.out.println(standardEnvironment);

    }


}
