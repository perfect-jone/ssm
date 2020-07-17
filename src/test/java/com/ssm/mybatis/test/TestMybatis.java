package com.ssm.mybatis.test;

import cn.hutool.core.date.DateUtil;
import com.ssm.mybatis.bean.User;
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

    @Before
    public void init() throws Exception {
        // 1.读取配置文件
        resource = Resources.getResourceAsStream("mybatis-config.xml");

        // 2.创建sqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        // 3.使用工厂对象创建sqlSession对象
        sqlSession = sqlSessionFactory.openSession();

        // 4.使用sqlSession对象创建Dao接口的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception {

        // 提交事务
        sqlSession.commit();

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
}
