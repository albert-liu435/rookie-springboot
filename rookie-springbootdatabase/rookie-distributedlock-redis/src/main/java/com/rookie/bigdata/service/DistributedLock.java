//package com.rookie.bigdata.service;
//
///**
// * @Class DistributedLock
// * @Description https://blog.csdn.net/kaka_buka/article/details/140077016
// * @Author rookie
// * @Date 2024/8/19 13:37
// * @Version 1.0
// */
//public class DistributedLock {
//
//    private Jedis jedis;
//    private String lockKey;
//    private String lockValue;
//    private int expireTime;
//
//    public DistributedLock(Jedis jedis, String lockKey, int expireTime) {
//        this.jedis = jedis;
//        this.lockKey = lockKey;
//        this.expireTime = expireTime;
//    }
//
//    // 获取锁
//    public boolean acquireLock() {
//        this.lockValue = UUID.randomUUID().toString();
//        String result = jedis.set(lockKey, lockValue, "NX", "EX", expireTime);
//        return "OK".equals(result);
//    }
//
//    // 释放锁
//    public boolean releaseLock() {
//        String luaScript =
//                "if redis.call('get', KEYS[1]) == ARGV[1] then " +
//                        "return redis.call('del', KEYS[1]) " +
//                        "else " +
//                        "return 0 " +
//                        "end";
//        Object result = jedis.eval(luaScript, 1, lockKey, lockValue);
//        return result.equals(1L);
//    }
//
//    public static void main(String[] args) {
//        Jedis jedis = new Jedis("localhost", 6379);
//        DistributedLock lock = new DistributedLock(jedis, "resource_lock", 10);
//
//        if (lock.acquireLock()) {
//            try {
//                System.out.println("Lock acquired, doing some work...");
//                // 执行业务逻辑
//            } finally {
//                lock.releaseLock();
//                System.out.println("Lock released");
//            }
//        } else {
//            System.out.println("Failed to acquire lock");
//        }
//
//        jedis.close();
//    }
//}
