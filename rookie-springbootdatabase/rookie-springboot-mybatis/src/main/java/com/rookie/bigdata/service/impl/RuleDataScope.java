package com.rookie.bigdata.service.impl;

import com.rookie.bigdata.service.DataScopeInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Class RuleDataScope
 * @Description
 * @Author rookie
 * @Date 2024/11/13 16:39
 * @Version 1.0
 */
@Component("ruleDataScope")
@Slf4j
public class RuleDataScope implements DataScopeInterface {
    @Override
    public String getSql(String sql) {

        //        String userId = LoginHandlerInterceptor.userLoginThreadLocal.get();
        //模拟用户为id为2的用户加name中有ipone的数据

        String userId = "2";
        //这里模拟用户id为1的用户在查询语句后面拼接id为1的过滤条件
        if ("2".equals(userId)) {
            if (sql.toLowerCase().contains("where")) {
                sql += "and user_id=" + userId;
            }
        }
        log.info("rule: {}", sql);
        return sql;
    }
}
