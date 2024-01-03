package com.rookie.bigdata.retry.callback.ex;

import java.util.Map;

/**
 * @Class BinaryExceptionClassifier
 * @Description TODO
 * @Author rookie
 * @Date 2024/1/2 14:16
 * @Version 1.0
 */
public class BinaryExceptionClassifier extends SubclassClassifier<Throwable, Boolean> {


    public BinaryExceptionClassifier(boolean defaultValue) {
        super(defaultValue);
    }

    public BinaryExceptionClassifier(Map<Class<? extends Throwable>, Boolean> typeMap) {
        this(typeMap, false);
    }

    public BinaryExceptionClassifier(Map<Class<? extends Throwable>, Boolean> typeMap, boolean defaultValue) {
        super(typeMap, defaultValue);
    }
}
