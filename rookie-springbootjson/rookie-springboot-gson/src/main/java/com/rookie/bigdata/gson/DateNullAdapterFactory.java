package com.rookie.bigdata.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.util.Date;

/**
 * @Class DateNullAdapterFactory
 * @Description https://blog.csdn.net/gaga2284/article/details/80540916
 * @Author rookie
 * @Date 2023/12/28 11:36
 * @Version 1.0
 */

public class DateNullAdapterFactory<T> implements TypeAdapterFactory {
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Class<T> rawType = (Class<T>) type.getRawType();
        if (rawType != Date.class) {
            return null;
        }
        return (TypeAdapter<T>) new DateNullAdapter();
    }


}
