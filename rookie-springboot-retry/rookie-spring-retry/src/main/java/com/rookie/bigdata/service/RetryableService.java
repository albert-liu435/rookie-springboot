package com.rookie.bigdata.service;

import com.rookie.bigdata.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @Class RetryableService
 * @Description TODO
 * @Author rookie
 * @Date 2023/12/28 16:04
 * @Version 1.0
 */
@Service
@Slf4j
public class RetryableService {

    /**
     * 默认情况下，会重试3次，间隔1秒
     *
     * @throws IllegalAccessException
     */
    @Retryable(value = IllegalAccessException.class)
    public void service() throws IllegalAccessException {
        log.error("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException("manual exception");
    }

    //maxAttempts，用于设置重试次数
    @Retryable(include = IllegalAccessException.class, maxAttempts = 5)
    public void service2() throws IllegalAccessException {
        log.error("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException("manual exception");
    }


    //maxAttemptsExpression则可以使用表达式，比如上述就是通过获取配置中maxAttempts的值，我们可以在application.yml设置。上述其实省略掉了SpEL表达式#{....}，运行结果的话可以发现方法执行
    @Retryable(value = IllegalAccessException.class, maxAttemptsExpression = "${maxAttempts}")
//    @Retryable(value = IllegalAccessException.class, maxAttemptsExpression = "#{1+1}")
//    @Retryable(value = IllegalAccessException.class, maxAttemptsExpression = "#{${maxAttempts}}")//效果和上面的一样
    public void service3() throws IllegalAccessException {
        log.error("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException("manual exception");
    }


    //exceptionExpression = "message.contains('test')"的作用其实是获取到抛出来exception的message(调用了getMessage()方法)，然后判断message的内容里面是否包含了test字符串，如果包含的话就会执行重试。
    // 所以如果调用方法的时候传入的参数exceptionMessage中包含了test字符串的话就会执行重试。
    @Retryable(value = IllegalAccessException.class, exceptionExpression = "message.contains('test')")
    public void service4(String exceptionMessage) throws IllegalAccessException {
        log.error("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException(exceptionMessage);
    }

    @Retryable(value = IllegalAccessException.class, exceptionExpression = "#{message.contains('test')}")
    public void service4_3(String exceptionMessage) throws IllegalAccessException {
        log.error("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException(exceptionMessage);
    }


    //还可以在表达式中执行一个方法，前提是方法的类在spring容器中注册了，@retryService其实就是获取bean name为retryService的bean，然后调用里面的checkException方法，传入的参数为#root，
    // 它其实就是抛出来的exception对象。一样的也是可以省略#{...}


    @Retryable(value = IllegalAccessException.class, exceptionExpression = "#{@retryableService.checkException(#root)}")
    public void service5(String exceptionMessage) throws IllegalAccessException {
        log.error("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException(exceptionMessage);
    }

    @Retryable(value = IllegalAccessException.class, exceptionExpression = "@retryableService.checkException(#root)")
    public void service5_1(String exceptionMessage) throws IllegalAccessException {
        log.error("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException(exceptionMessage);
    }

    public boolean checkException(Exception e) {
        log.error("error message:{}", e.getMessage());
        return true; //返回true的话表明会执行重试，如果返回false则不会执行重试
    }

    @Retryable(exceptionExpression = "#{#root instanceof T(java.lang.IllegalAccessException)}") //判断exception的类型
    public void service5_2(String exceptionMessage) {
        log.error("do something... {}", LocalDateTime.now());
        throw new NullPointerException(exceptionMessage);
    }

    @Retryable(exceptionExpression = "#root instanceof T(java.lang.IllegalAccessException)")
    public void service5_3(String exceptionMessage) {
        log.error("do something... {}", LocalDateTime.now());
        throw new NullPointerException(exceptionMessage);
    }


    @Retryable(exceptionExpression = "myMessage.contains('test')") //查看自定义的MyException中的myMessage的值是否包含test字符串
    public void service5_4(String exceptionMessage) throws MyException {
        log.error("do something... {}", LocalDateTime.now());
        throw new MyException(exceptionMessage); //自定义的exception
    }

    @Retryable(exceptionExpression = "#root.myMessage.contains('test')")  //和上面service5_4方法的效果一样
    public void service5_5(String exceptionMessage) throws MyException {
        log.error("do something... {}", LocalDateTime.now());
        throw new MyException(exceptionMessage);
    }


//    这个exclude属性可以帮我们排除一些我们不想重试的异常
//
//最后我们来看看这个backoff 重试等待策略, 默认使用@Backoff注解。
//
//我们先来看看这个@Backoff的value属性,用于设置重试间隔

    @Retryable(exclude = MyException.class)
    public void service6(String exceptionMessage) throws MyException {
        log.error("do something... {}", LocalDateTime.now());
        throw new MyException(exceptionMessage);
    }

//运行结果可以看出来重试的间隔为2秒
    @Retryable(value = IllegalAccessException.class,
            backoff = @Backoff(value = 2000))
    public void service7() throws IllegalAccessException {
        log.info("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException();
    }

    //接下来介绍@Backoff的delay属性，它与value属性不能共存，当delay不设置的时候会去读value属性设置的值，如果delay设置的话则会忽略value属性
    //运行结果可以看出，重试的时间间隔为500ms

    @Retryable(value = IllegalAccessException.class,
            backoff = @Backoff(value = 2000, delay = 500))
    public void service8() throws IllegalAccessException {
        log.info("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException();
    }

    //接下来我们来看``@Backoff的multiplier`的属性, 指定延迟倍数, 默认为0。
    //multiplier设置为2，则表示第一次重试间隔为2s，第二次为4秒，第三次为8s
    @Retryable(value = IllegalAccessException.class, maxAttempts = 4,
            backoff = @Backoff(delay = 2000, multiplier = 2))
    public void service9() throws IllegalAccessException {
        log.info("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException();
    }

    //接下来我们来看看这个@Backoff的maxDelay属性,设置最大的重试间隔，当超过这个最大的重试间隔的时候，重试的间隔就等于maxDelay的值
    @Retryable(value = IllegalAccessException.class, maxAttempts = 4,
            backoff = @Backoff(delay = 2000, multiplier = 2, maxDelay = 5000))
    public void service10() throws IllegalAccessException {
        log.info("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException();
    }


    @Retryable(value = IllegalAccessException.class)
    public void service11() throws IllegalAccessException {
        log.info("do something... {}", LocalDateTime.now());
        throw new IllegalAccessException();
    }



    //注解@Recover
    //当@Retryable方法重试失败之后，最后就会调用@Recover方法。用于@Retryable失败时的“兜底”处理方法。 @Recover的方法必须要与@Retryable注解的方法保持一致，第一入参为要重试的异常，其他参数与@Retryable保持一致，返回值也要一样，否则无法执行！

    @Recover
    public void recover11(IllegalAccessException e) {
        log.info("service retry after Recover => {}", e.getMessage());
    }

    //=========================

    @Retryable(value = ArithmeticException.class)
    public int service12() throws IllegalAccessException {
        log.info("do something... {}", LocalDateTime.now());
        return 1 / 0;
    }


    @Recover
    public int recover12(ArithmeticException e) {
        log.info("service retry after Recover => {}", e.getMessage());
        return 0;
    }


    //=========================

    @Retryable(value = ArithmeticException.class)
    public int service13(String message) throws IllegalAccessException {
        log.info("do something... {},{}", message, LocalDateTime.now());
        return 1 / 0;
    }


    @Recover
    public int recover13(ArithmeticException e, String message) {
        log.info("{},service retry after Recover => {}", message, e.getMessage());
        return 0;
    }


    // openTimeout时间范围内失败maxAttempts次数后，熔断打开resetTimeout时长
    @CircuitBreaker(openTimeout = 1000, resetTimeout = 3000, value = NullPointerException.class)
    public void circuitBreaker(int num) {
        log.info(" 进入断路器方法num={}", num);
        if (num > 8) return;
        Integer n = null;
        System.err.println(1 / n);
    }


    @Recover
    public void recover(NullPointerException e) {
        log.info("service retry after Recover => {}", e.getMessage());
    }



}
