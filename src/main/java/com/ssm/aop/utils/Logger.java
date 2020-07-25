package com.ssm.aop.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author Jone
 * @create 2020-07-24 15:29
 * <p>
 * 前置、后置、异常、最终，类似于try catch finally
 */
@Component("logger")
@Aspect // 表示此类是个切面类
@EnableAspectJAutoProxy // 该注解可以省略开启xml中的<aop:aspectj-autoproxy/>标签
public class Logger {

    @Pointcut("execution(* com.ssm.aop.service.impl.*.*(..))")
    private void pointcut(){
    }

/*    *//**
     * 前置通知
     *//*
    @Before("pointcut()")
    public void beforePrintLog() {
        System.out.println("前置通知：开始记录日志了！");
    }

    *//**
     * 后置通知
     *//*
    @AfterReturning("pointcut()")
    public void afterReturningPrintLog() {
        System.out.println("后置通知：开始记录日志了！");
    }

    *//**
     * 异常通知
     *//*
    @AfterThrowing("pointcut()")
    public void afterThrowingPrintLog() {
        System.out.println("异常通知：开始记录日志了！");
    }

    *//**
     * 最终通知
     *//*
    @After("pointcut()")
    public void afterPrintLog() {
        System.out.println("最终通知：开始记录日志了！");
    }*/

    /**
     * 环绕通知：它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     * Spring框架为我们提供了一个接口,proceedingJoinPoint.该接口有一个方法proceed()此方法就相当于明确调用切入点方法.
     */

    @Around("pointcut()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object proceed = null;
        try {
            System.out.println("环绕通知-前置通知：开始记录日志了！");
            proceed = pjp.proceed(pjp.getArgs());
            System.out.println("环绕通知-后置通知：开始记录日志了！");
        } catch (Throwable t) {
            System.out.println("环绕通知-异常通知：开始记录日志了！");
            t.printStackTrace();
        } finally {
            System.out.println("环绕通知-最终通知：开始记录日志了！");
        }
        return proceed;
    }
}
