local key=KEYS[1]  -- 锁的key
local threadId=ARGV[1]  --线程唯一标识
-- 比较线程标示与锁中的标示是否一致
if(redis.call('get', key) ==  threadId) then
    -- 释放锁 del key
    return redis.call('del', key)
end
return 0;
