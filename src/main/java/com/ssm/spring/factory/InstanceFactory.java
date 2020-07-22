package com.ssm.spring.factory;

import com.ssm.spring.service.AccountService;
import com.ssm.spring.service.impl.AccountServiceImpl;

/**
 * @author Jone
 * @create 2020-07-22 12:25
 * 模拟一个工厂类，类可能存在于jar包中
 */
public class InstanceFactory {
/*    // 创建bean对象的第二种方式，利用工厂中的方法创建对象
    public AccountService getAccountService(){
        return new AccountServiceImpl();
    }*/

    // 创建bean对象的第三种方式，利用工厂中的静态方法创建对象
    public static AccountService getAccountService(){
        return null;
        //return new AccountServiceImpl();
    }
}
