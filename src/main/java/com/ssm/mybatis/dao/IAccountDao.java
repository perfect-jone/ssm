package com.ssm.mybatis.dao;

import com.ssm.mybatis.bean.Account;

import java.util.List;

/**
 * @author Jone
 * @create 2020-07-19 22:44
 */
public interface IAccountDao {
    /**
     * 查询每个账户下的所有信息，包括用户姓名，性别，地址等
     * @return
     */
    List<Account> findAccountAll();
}
