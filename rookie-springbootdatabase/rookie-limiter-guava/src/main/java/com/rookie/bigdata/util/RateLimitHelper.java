package com.rookie.bigdata.util;

import com.google.common.util.concurrent.RateLimiter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class RateLimitHelper
 * @Description
 * @Author rookie
 * @Date 2024/8/19 16:08
 * @Version 1.0
 */
public class RateLimitHelper {

    private RateLimitHelper(){}

    private static Map<String, RateLimiter> rateMap = new HashMap<>();

    public static RateLimiter getRateLimiter(String limitType, double limitCount ){
        RateLimiter rateLimiter = rateMap.get(limitType);
        if(rateLimiter == null){
            rateLimiter = RateLimiter.create(limitCount);
            rateMap.put(limitType,rateLimiter);
        }
        return rateLimiter;
    }

}
