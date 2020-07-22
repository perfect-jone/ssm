package com.ssm.spring.dao.impl;

import com.ssm.spring.dao.AccountDao;
import com.ssm.spring.service.AccountService;

/**
 * @author Jone
 * @create 2020-07-21 14:49
 * 账户的持久层接口实现类
 */
public class AccountDaoImpl implements AccountDao{

    public void saveAccount() {
        System.out.println("模拟保存了账户");
    }
}
