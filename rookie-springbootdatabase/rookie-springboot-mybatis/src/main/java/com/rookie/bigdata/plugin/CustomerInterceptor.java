package com.rookie.bigdata.plugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

/**
 * @Class CustomerInterceptor
 * @Description 自定义插件
 * @Author rookie
 * @Date 2024/11/13 15:46
 * @Version 1.0
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {
                MappedStatement.class, Object.class
        }),
})
@Slf4j
public class CustomerInterceptor implements Interceptor {
//    @Intercepts	// 描述：标志该类是一个拦截器
//@Signature 	// 描述：指明该拦截器需要拦截哪一个接口的哪一个方法
//
//// @Signature注解中属性:
//type; // 四种类型接口中的某一个接口，如Executor.class；
//method; // 对应接口中的某一个方法名，比如Executor的query方法；
//args; // 对应接口中的某一个方法的参数，比如Executor中query方法因为重载原因，有多个，args就是指明参数类型，从而确定是具体哪一个方法；





    @Override
    public Object intercept(Invocation invocation) throws Throwable {


        log.info("执行自定义的mybatis插件");

        return invocation.proceed();
    }
}
