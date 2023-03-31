package com.rookie.bigdata.beans.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1、InitializingBean接口为bean提供了初始化方法的方式，它只包括afterPropertiesSet方法，凡是继承该接口的类，在初始化bean的时候都会执行该方法。
 * 2、spring初始化bean的时候，如果bean实现了InitializingBean接口，会自动调用afterPropertiesSet方法。
 * 3、在Spring初始化bean的时候，如果该bean实现了InitializingBean接口，并且同时在配置文件中指定了init-method，系统则是先调用afterPropertieSet()方法，然后再调用init-method中指定的方法。
 * <p>
 * 1、Spring为bean提供了两种初始化bean的方式，实现InitializingBean接口，实现afterPropertiesSet方法，或者在配置文件中通过init-method指定，两种方式可以同时使用。
 * 2、实现InitializingBean接口是直接调用afterPropertiesSet方法，比通过反射调用init-method指定的方法效率要高一点，但是init-method方式消除了对spring的依赖。
 * 3、如果调用afterPropertiesSet方法时出错，则不调用init-method指定的方法。
 * <p>
 * Spring中有两种类型的Bean，一种是普通Bean，另一种是工厂Bean，即FactoryBean。工厂Bean跟普通Bean不同，其返回的对象不是指定类的一个实例，其返回的是该工厂Bean的getObject方法所返回的对象。
 * <p>
 * 使用场景：1、通过外部对类是否是单例进行控制，该类自己无法感知 2、对类的创建之前进行初始化的操作，在afterPropertiesSet()中完成。
 * <p>
 * spring初始化bean有两种方式：
 * 第一：实现InitializingBean接口，继而实现afterPropertiesSet的方法
 * 第二：反射原理，配置文件使用init-method标签直接注入bean
 * ————————————————
 * 版权声明：本文为CSDN博主「qq_37705525」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_37705525/article/details/124808168
 *
 * @Class InitializingBeanMain
 * @Description TODO
 * @Author rookie
 * @Date 2023/3/31 23:55
 * @Version 1.0
 */
public class InitializingBeanMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        //TestInitializingBean testInitializingBean = (TestInitializingBean)applicationContext.getBean("testInitializingBean");

    }
}
