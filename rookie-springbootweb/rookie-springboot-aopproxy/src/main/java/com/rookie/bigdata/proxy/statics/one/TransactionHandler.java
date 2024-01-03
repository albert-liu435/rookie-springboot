package com.rookie.bigdata.proxy.statics.one;

/**
 * @Class TransactionHandler
 * @Description https://juejin.cn/post/7098269942310502437
 * @Author rookie
 * @Date 2024/1/3 10:08
 * @Version 1.0
 */
//3.「代理类」
public class TransactionHandler implements UserDao {
    // 目标代理对象
    // 2.「服务对象」
    private UserDao target;

    //构造代理对象时传入目标对象
    public TransactionHandler(UserDao target) {
        this.target = target;  //也可以延迟初始化 如在调用save方法时才创建target对象
    }

    @Override
    public void save() {
        //调用目标方法前的处理
        System.out.println("开启事务控制...");
        //调用目标对象的方法
        target.save();
        //调用目标方法后的处理
        System.out.println("关闭事务控制...");
    }


// 4. 「客户端」

    public static void main(String[] args) {
        //新建目标对象
        UserDaoImpl target = new UserDaoImpl();

        //创建代理对象, 并使用接口对其进行引用
        UserDao userDao = new TransactionHandler(target);

        //针对接口进行调用
        userDao.save();
    }
}
