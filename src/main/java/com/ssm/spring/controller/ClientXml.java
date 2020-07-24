package com.ssm.spring.controller;

import com.ssm.spring.config.SpringConfiguration;
import com.ssm.spring.dao.AccountDao;
import com.ssm.spring.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.swing.*;

/**
 * *****************************************************************************
 *  ApplicationContext接口的三个常用实现类：
 *  1. ClassPathXmlApplicationContext
 *      加载类路径下的配置文件
 *  2. FileSystemXmlApplicationContext
 *      加载磁盘任意路径下的配置文件
 *  3. AnnotationConfigApplicationContext
 *      用于读取注解创建容器的
 *
 *  核心容器的两个接口引发的两个问题：
 *  1. ApplicationContext：单例模式适用
 *      在构建核心容器时，创建对象采取的策略是采用立即加载方式，
 *      只要一读取完配置文件，里面创建配置文件中的对象
 *  2. BeanFactory：       多例模式适用
 *      在构建核心容器时，创建对象采取的策略是采用懒加载方式，
 *      什么时候根据id获取对象了，什么时候才真正的创建对象
 *
 * ******************************************************************************
 */
public class ClientXml {
    public static void main(String[] args) {
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
        //        "F:\\workspace\\mybatis\\src\\main\\resources\\bean.xml");

        // 获取spring容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean-context.xml");

        //如果是通过配置类读取的注解信息，也即没有xml文件时，用下面的类
        //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        // 下面两种获取方式都可以

        // 通过id获取bean对象
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        //AccountService accountService1 = (AccountService) ac.getBean("accountService");

        //System.out.println(accountService);
        accountService.saveAccount();
    }
}
