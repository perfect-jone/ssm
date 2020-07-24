package com.ssm.aop.utils;

/**
 * @author Jone
 * @create 2020-07-24 15:29
 *
 * 前置、后置、异常、最终，类似于try catch finally
 */
public class Logger {

    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知：开始记录日志了！");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("后置通知：开始记录日志了！");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog(){
        System.out.println("异常通知：开始记录日志了！");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("最终通知：开始记录日志了！");
    }

}
