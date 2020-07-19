package com.ssm.mybatis.test;

import cn.hutool.core.date.DateUtil;
import com.ssm.mybatis.bean.Account;
import com.ssm.mybatis.bean.User;
import com.ssm.mybatis.dao.IAccountDao;
import com.ssm.mybatis.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Jone
 * @create 2020-07-17 11:34
 */


public class TestMybatis {

    private InputStream resource;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private IAccountDao accountDao;

    @Before
    public void init() throws Exception {
        // 1.读取配置文件
        resource = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.创建sqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        // 3.使用工厂对象创建sqlSession对象,设置自动提交
        sqlSession = sqlSessionFactory.openSession(true);

        // 4.使用sqlSession对象创建Dao接口的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destory() throws Exception {

        // 关闭资源
        sqlSession.close();
        resource.close();
    }

    /**
     * 查询所有方法
     */
    @Test
    public void testFindAll() {

        // 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    /**
     * 保存方法
     */
    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("jone");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("西安市");
        System.out.println("插入前id:"+user);
        userDao.insert(user);
        System.out.println("插入后id:"+user);
    }

    /**
     * 修改方法
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(51);
        user.setUsername("pating");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("宝鸡市");
        userDao.update(user);
    }

    /**
     * 删除方法
     */
    @Test
    public void testDelete() {

        userDao.delete(51);
    }

    /**
     * 查询单个用户方法
     */
    @Test
    public void testSelectOne() {

        User user = userDao.selectOneById(48);
        System.out.println(user);
    }

    /**
     * 根据姓名模糊查询用户方法
     */
    @Test
    public void testFindByName() {

        // List<User> users = userDao.findByName("王");
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 根据姓名、性别等查询用户方法
     */
    @Test
    public void testFindByCondition() {

        User user = new User();
        user.setUsername("老王");
        user.setSex("男");
        List<User> users = userDao.findByCondition(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    /**
     * 根据姓名、性别等查询用户方法
     */
    @Test
    public void testFindUserInIds() {

        User user = new User();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(43);
        user.setIds(ids);
        List<User> users = userDao.findUserInIds(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    /**
     * 根据姓名、性别等查询用户方法
     */
    @Test
    public void testFindByConditionOne() {

        User user = new User();

        List<User> users = userDao.findByConditionOne(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    /**
     * 查询所有账户方法
     */
    @Test
    public void testFindAccountAll() {

        // 使用代理对象执行方法
        List<Account> accounts = accountDao.findAccountAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
