package com.ssm.aop.jdbcTemplate;

import com.ssm.aop.bean.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


/**
 * @author Jone
 * @create 2020-07-26 13:15
 */
public class JdbcTemplateDemo {
    public static void main(String[] args) {
        // 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean-jdbcTemplate.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        // 增
        //jt.update("insert into account(name,money) values(?,?)","eee",1000f);

        // 改
        //jt.update("update account set name=?,money=? where id = ?","e1e1",3333.3f,6);

        // 删
        //jt.update("delete from account where id = ?",1);

        // 查询所有
/*        List<Account> accounts = jt.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class),2);
        for (Account account : accounts) {
            System.out.println(account);
        }*/

        // 返回一行一列
        Long count = jt.queryForObject("select count(*) from account where money > ?", Long.class, 1000f);
        System.out.println(count);

    }
}
