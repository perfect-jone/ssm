package com.ssm.mybatis.test;

import com.ssm.mybatis.bean.Account;
import com.ssm.mybatis.bean.User;
import com.ssm.mybatis.dao.IAccountDao;
import com.ssm.mybatis.dao.IRoleDao;
import com.ssm.mybatis.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author Jone
 * @create 2020-07-20 17:12
 */
public class TestMybatisAnnotation {

    private InputStream resource;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private IAccountDao accountDao;
    private IRoleDao roleDao;


    @Before
    public void init() throws Exception {
        // 1.读取配置文件
        resource = Resources.getResourceAsStream("maybatis-config-annotation.xml");

        // 2.创建sqlSessionFactory工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

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

    @Test
    public void testFindAll() {

        // 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserByAnnotation(){
        User user = new User();
        user.setUsername("老王");
        user.setId(52);
        List<User> users = userDao.findUserByAnnotation(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void testFindUserById_Annotation(){
        User user = userDao.findUserById_Annotation(52);
        System.out.println(user);
    }

    @Test
    public void testFindAccountAll_Annotation(){
        List<Account> accounts = accountDao.findAccountAll_Annotation();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void testFindAll_Annotation(){
        List<User> users = userDao.findAll_Annotation();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
}
