package com.rookie.bigdata.proxy.statics;

/**
 * @Class UserDaoProxy
 * @Description 静态代理
 * @Author rookie
 * @Date 2024/1/2 17:33
 * @Version 1.0
 */
public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务");//扩展了额外功能
        target.save();
        System.out.println("提交事务");
    }
}
