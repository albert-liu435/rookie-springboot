package com.rookie.bigdata.proxy.statics.one;

/**
 * @Class UserDaoImpl
 * @Description TODO
 * @Author rookie
 * @Date 2024/1/3 10:07
 * @Version 1.0
 */
//2.「服务类」
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("正在保存用户...");
    }
}


