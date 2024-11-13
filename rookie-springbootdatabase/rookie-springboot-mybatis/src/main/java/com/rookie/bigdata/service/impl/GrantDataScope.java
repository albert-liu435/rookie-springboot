package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.service.DataScopeInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Class GrantDataScope
 * @Description
 * @Author rookie
 * @Date 2024/11/13 16:34
 * @Version 1.0
 */
@Component("grantDataScope")
@Slf4j
public class GrantDataScope implements DataScopeInterface {


    /**
     * 明细授权实现
     *
     * @param sql
     * @return
     */
    @Override
    public String getSql(String sql) {
        //这里是获取当前登录用户的id，我定义了一个登录拦截器，通过ThreadLocal保存当前登录的用户。代码就不写出来了。比较简单
//        String userId = LoginHandlerInterceptor.userLoginThreadLocal.get();
        String userId="1";
        //这里模拟用户id为1的用户在查询语句后面拼接id为1的过滤条件
        if("1".equals(userId)){
            if(sql.toLowerCase().contains("where")){
                sql +="and user_id="+userId;
            }
        }

        return sql;
    }
}
