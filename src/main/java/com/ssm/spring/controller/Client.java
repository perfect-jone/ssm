package com.ssm.spring.controller;

import com.ssm.spring.factory.BeanFactroy;
import com.ssm.spring.service.AccountService;
import com.ssm.spring.service.impl.AccountServiceImpl;

/**
 * @author Jone
 * @create 2020-07-21 15:03
 * 模拟账户的表现层
 */
public class Client {
    public static void main(String[] args) {
        //private AccountService accountService = new AccountServiceImpl();
        AccountService accountService = (AccountService) BeanFactroy.getBean("accountService");
        for (int i = 0; i < 5; i++) {
            accountService.saveAccount();
            System.out.println(accountService);
        }
    }
}
