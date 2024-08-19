//package com.rookie.bigdata.service;
//
//import cn.hutool.core.lang.UUID;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.script.DefaultRedisScript;
//import org.springframework.data.redis.core.script.RedisScript;
//
//import java.util.Collections;
//import java.util.concurrent.TimeUnit;
//
///**
// * @Class SimpleRedisLock
// * @Description
// * @Author rookie
// * @Date 2024/8/19 13:44
// * @Version 1.0
// */
//public class SimpleRedisLock implements ILock {
//
//    private String name;
//    private StringRedisTemplate stringRedisTemplate;
//
//    public SimpleRedisLock(String name, StringRedisTemplate stringRedisTemplate) {
//        this.name = name;
//        this.stringRedisTemplate = stringRedisTemplate;
//    }
//
//    private static final String KEY_PREFIX = "lock:";
//
//    //randomUUID生成的数字会带一个横线，toString（true）方法就是去掉横线
//    //因为不同JVM中，可能存在线程号相同的情况，所以需要用UUID来区分不同的JVM
//    private static final String ID_PREFIX = UUID.randomUUID().toString(true) + "-";
//
//    private static final DefaultRedisScript<Long> UNLOCK_SCRIPT;
//    static {
//        UNLOCK_SCRIPT = new DefaultRedisScript<>();
//        UNLOCK_SCRIPT.setLocation(new ClassPathResource("unlock.lua")); //加载的脚本的位置
//        UNLOCK_SCRIPT.setResultType(Long.class); //返回值的类型
//    }
//
//    @Override
//    public boolean tryLock(long timeoutSec) {
//        // 获取线程标示
//        String threadId = ID_PREFIX + Thread.currentThread().getId();
//        // 获取锁
//        Boolean success = stringRedisTemplate.opsForValue()
//                .setIfAbsent(KEY_PREFIX + name, threadId, timeoutSec, TimeUnit.SECONDS);
//        //不能直接返回success，因为会有自动拆箱的风险，如果success是null，就会返回true，返回错误数据
//        return Boolean.TRUE.equals(success);
//    }
//
//    @Override
//    public void unlock() {
//        // 调用lua脚本  ,原来的多行代码变成了现在的单行代码就保证了原子性
//        stringRedisTemplate.execute(
//                UNLOCK_SCRIPT,
//                Collections.singletonList(KEY_PREFIX + name), //生成单元素的集合，即脚本中的需要的KETS[1]参数
//                ID_PREFIX + Thread.currentThread().getId()); //即脚本中需要的ARVG[1]参数
//    }
//
//}
