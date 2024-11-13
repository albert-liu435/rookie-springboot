//package com.rookie.bigdata.plugin;
//
//import org.apache.ibatis.executor.Executor;
//import org.apache.ibatis.mapping.BoundSql;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.mapping.SqlSource;
//import org.apache.ibatis.plugin.*;
//import org.apache.ibatis.session.ResultHandler;
//import org.apache.ibatis.session.RowBounds;
//
//import java.util.Properties;
//
///**
// * @Class DataPermissionInterceptor
// * @Description
// * @Author rookie
// * @Date 2024/11/13 16:44
// * @Version 1.0
// */
//@Intercepts({
//        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
//})
//public class DataPermissionInterceptor implements Interceptor {
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        // 获取被拦截的对象，通常是Executor类型
//        Executor executor = (Executor) invocation.getTarget();
//
//        // 获取被拦截的方法
//        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
//
//        // 获取被拦截的方法参数
//        Object parameter = invocation.getArgs()[1];
//
//        // 获取RowBounds对象
//        RowBounds rowBounds = (RowBounds) invocation.getArgs()[2];
//
//        // 获取结果处理器
//        ResultHandler resultHandler = (ResultHandler) invocation.getArgs()[3];
//
//        // 根据用户权限动态构建SQL
//        String originalSql = mappedStatement.getBoundSql(parameter).getSql();
//        String user = "当前用户"; // 假设已经获取到当前用户信息
//        String dataScopeSql = " AND your_data_scope_column = '" + user + "'";
//        String modifiedSql = originalSql + dataScopeSql;
//
//        // 构建新的MappedStatement
//        BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), modifiedSql);
//        MappedStatement newMs = copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(newBoundSql));
//
//        // 使用新的MappedStatement执行查询
//        return executor.query(newMs, parameter, rowBounds, resultHandler);
//    }
//
//    private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
//        // 这里简化了复制过程，实际情况需要复制更多属性
//        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());
//        return builder.build();
//    }
//
//    @Override
//    public Object plugin(Object target) {
//        return Plugin.wrap(target, this);
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//        // 可以接收配置的属性
//    }
//}
