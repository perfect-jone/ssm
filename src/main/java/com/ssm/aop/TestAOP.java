package com.ssm.aop;

import com.ssm.aop.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jone
 * @create 2020-07-24 16:05
 */
public class TestAOP {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean-aop.xml");
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        accountService.saveAccount();
/*        accountService.updateAccount(10);
        accountService.deleteAccount();*/
    }
}
