package com.rookie.bigdata.proxy.statics;

/**
 * @Class UserDao
 * @Description
 * @Author rookie
 * @Date 2024/1/2 17:32
 * @Version 1.0
 */


public class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
