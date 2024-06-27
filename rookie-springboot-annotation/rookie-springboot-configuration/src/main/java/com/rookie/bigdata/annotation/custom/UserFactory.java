package com.rookie.bigdata.annotation.custom;

/**
 * @Class UserFactory
 * @Description
 * @Author rookie
 * @Date 2024/6/27 11:59
 * @Version 1.0
 */
import java.lang.reflect.Method;

public class UserFactory {
    public static User create() {
        User user = new User();
        // 获取User类中所有的方法（getDeclaredMethods也行）
        Method[] methods = User.class.getMethods();
        try {
            for (Method method : methods) {
                // 判断方法上是否存在Init注解，存在就返回true，否则返回false
                if (method.isAnnotationPresent(Init.class)) {
                    // 此方法返回该元素的注解在此元素的指定注释类型（如果存在），否则返回null
                    Init init = method.getAnnotation(Init.class);
                    // 如果Method代表了一个方法 那么调用它的invoke就相当于执行了它代表的这个方法,在这里就是给set方法赋值
                    method.invoke(user, init.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }
}

