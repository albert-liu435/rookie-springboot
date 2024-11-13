//package com.rookie.bigdata.plugin;
//
//import com.rookie.bigdata.service.DataScopeInterface;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.executor.statement.StatementHandler;
//import org.apache.ibatis.mapping.SqlCommandType;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Invocation;
//import org.apache.ibatis.plugin.Signature;
//import org.apache.ibatis.reflection.MetaObject;
//import org.apache.ibatis.reflection.SystemMetaObject;
//
//import java.sql.Connection;
//import java.util.Collection;
//import java.util.Map;
//import java.util.Properties;
//
///**
// * @Class DataScopeInterceptor
// * @Description
// * @Author rookie
// * @Date 2024/11/13 16:29
// * @Version 1.0
// */
//@Intercepts({
//        @Signature(
//                type = StatementHandler.class, method = "prepare", args = {
//                Connection.class, Integer.class
//        }
//        )
//})
//@Slf4j
//public class DataScopeInterceptor implements Interceptor {
//
//
//    /**
//     * 这里是每次执行操作的时候，都会进行这个拦截器的方法内
//     *
//     * @param invocation
//     * @return
//     * @throws Throwable
//     */
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//
//        StatementHandler statementHandler=(StatementHandler) invocation.getTarget();
//        MetaObject metaStatementHandler= SystemMetaObject.forObject(statementHandler);
////        String userName = LoginHandlerInterceptor.userLoginThreadLocal.get();
//        //  sql语句类型
//        Object sqlCommandType = metaStatementHandler.getValue("delegate.mappedStatement.sqlCommandType");
//
////只考虑了查询
//        if (SqlCommandType.SELECT.equals(sqlCommandType)) {
//            //获取sql
//            String sql = String.valueOf(metaStatementHandler.getValue("delegate.boundSql.sql"));
//            //获取DataScopeInterface的实现类集合，并循环执行sql的格式化
//            Map<String, DataScopeInterface> dataScopeInterfaceMap = SpringContextUtils.getBeanOfType(DataScopeInterface.class);
//            Collection<DataScopeInterface> dataScopeInterfaces = dataScopeInterfaceMap.values();
//            for (DataScopeInterface dataScopeInterface : dataScopeInterfaces) {
//                sql = dataScopeInterface.getSql(sql);
//            }
//            log.info("sql --> " + sql);
//            //重新设置sql
//            metaStatementHandler.setValue("delegate.boundSql.sql", sql);
//        }
//        return invocation.proceed();
//    }
//
//    /**
//     * 主要是为了把这个拦截器生成一个代理放到拦截器链中
//     *
//     * @param target
//     * @return
//     */
//    @Override
//    public Object plugin(Object target) {
//        return Interceptor.super.plugin(target);
//    }
//
//    /**
//     * 插件初始化的时候调用，也只调用一次，插件配置的属性从这里设置进来
//     *
//     * @param properties
//     */
//    @Override
//    public void setProperties(Properties properties) {
////        Interceptor.super.setProperties(properties);
//    }
//}
