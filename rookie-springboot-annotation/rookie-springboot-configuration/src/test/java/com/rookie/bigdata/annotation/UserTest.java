package com.rookie.bigdata.annotation;


import com.rookie.bigdata.annotation.custom.Init;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * @Class UserTest
 * @Description
 * @Author rookie
 * @Date 2024/6/27 13:40
 * @Version 1.0
 */
class UserTest {


    @Test
    void test01() throws Exception{
        User user = new User();
        user.setAge("111");
        user.setName("www");

        Class<User> userClass = User.class;
        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("属性名称是：" + field.getName());
            Init annotation = field.getAnnotation(Init.class);
            System.out.println("注解的value值是：" + annotation.value());
            // 字段是私有的想要获取就需要将Accessible设置为true，否则报错
            field.setAccessible(true);
            Object o = field.get(user);
            System.out.println("user对象的属性值是：" + o);
            System.out.println();
        }
    }


}
