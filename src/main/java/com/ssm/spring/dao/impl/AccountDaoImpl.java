package com.ssm.spring.dao.impl;


import com.ssm.spring.dao.AccountDao;
import com.ssm.spring.service.AccountService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import javax.swing.tree.VariableHeightLayoutCache;

/**
 * @author Jone
 * @create 2020-07-21 14:49
 * 账户的持久层接口实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao{

    private QueryRunner runner;
    private static final Log logger = LogFactory.getLog("ClientXml.class");


    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void saveAccount() {
        System.out.println("模拟保存了账户");
    }
}
