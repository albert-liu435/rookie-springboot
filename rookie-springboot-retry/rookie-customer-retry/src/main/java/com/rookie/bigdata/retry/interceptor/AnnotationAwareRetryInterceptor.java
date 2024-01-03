package com.rookie.bigdata.retry.interceptor;

import com.rookie.bigdata.retry.annotation.Retryable;
import com.rookie.bigdata.retry.callback.RetryOperationsInterceptor;
import com.rookie.bigdata.retry.callback.RetryPolicy;
import com.rookie.bigdata.retry.callback.RetryTemplate;
import com.rookie.bigdata.retry.callback.SimpleRetryPolicy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Class AnnotationAwareRetryInterceptor
 * @Description
 * @Author rookie
 * @Date 2024/1/2 14:10
 * @Version 1.0
 */
public class AnnotationAwareRetryInterceptor implements MethodInterceptor, BeanFactoryAware {

    private final Map<Object, Map<Method, MethodInterceptor>> delegates = new HashMap<>(256);

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        MethodInterceptor delegate = getDelegate(invocation.getThis(), invocation.getMethod());

        if (delegate != null) {
            return delegate.invoke(invocation);
        }

        //spring源码中因为条件判断的问题，执行到这里，说明调用的是没有标注 @Retryable 注解的方法
        return invocation.proceed();
    }

    private MethodInterceptor getDelegate(Object target, Method method) {
        if (!this.delegates.containsKey(target) || !this.delegates.get(target).containsKey(method)) {
            synchronized (this.delegates) {
                if (!this.delegates.containsKey(target)) {
                    this.delegates.put(target, new HashMap<Method, MethodInterceptor>());
                }

                Map<Method, MethodInterceptor> delegatesForTarget = this.delegates.get(target);
                if (!delegatesForTarget.containsKey(method)) {
                    Retryable annotation = AnnotationUtils.findAnnotation(method, Retryable.class);
                    if(annotation == null) {
                        //注解可能标注到类上了
                        annotation = AnnotationUtils.findAnnotation(method.getDeclaringClass(), Retryable.class);
                    }

                    if (annotation == null) {
                        //return null
                        return delegatesForTarget.put(method, null);
                    }

                    MethodInterceptor delegate = createInterceptor(target, method, annotation);

                    delegatesForTarget.put(method, delegate);
                }
            }
        }

        return this.delegates.get(target).get(method);
    }

    private MethodInterceptor createInterceptor(Object target, Method method, Retryable annotation) {
        RetryOperationsInterceptor methodInterceptor = new RetryOperationsInterceptor();
        RetryTemplate retryOperations = new RetryTemplate();
        retryOperations.setRetryPolicy(getRetryPolicy(annotation));

        methodInterceptor.setRetryOperations(retryOperations);


        return methodInterceptor;

    }

    private RetryPolicy getRetryPolicy(Annotation retryable) {
        Map<String, Object> attrs = AnnotationUtils.getAnnotationAttributes(retryable);
        @SuppressWarnings("unchecked")
        Class<? extends Throwable>[] includes = (Class<? extends Throwable>[]) attrs.get("value");
        Integer maxAttempts = (Integer) attrs.get("maxAttempts");
        if (maxAttempts < 0) {
            maxAttempts = SimpleRetryPolicy.DEFAULT_MAX_ATTEMPTS;
        }

        boolean async = (boolean) attrs.get("async");

        if (includes == null || includes.length == 0) {
            SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
            simpleRetryPolicy.setMaxRetryAttempts(maxAttempts);
            simpleRetryPolicy.setUseAsync(async);
            return simpleRetryPolicy;
        }

        Map<Class<? extends Throwable>, Boolean> policyMap = new HashMap<Class<? extends Throwable>, Boolean>(4);
        for (Class<? extends Throwable> type : includes) {
            policyMap.put(type, true);
        }

        return new SimpleRetryPolicy(maxAttempts, policyMap, async, false);

    }


}
