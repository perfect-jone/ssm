package com.ssm.mybatis.dao;

import com.ssm.mybatis.bean.User;


import java.util.List;

/**
 * @author Jone
 * @create 2020-07-17 10:49
 * 用户持久层
 */
public interface IUserDao {
    /**
     * 查询所有用户
     *
     */
    // 使用注解定义sql语句 @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     */

    void insert(User user);

    /**
     * 修改用户
     */

    void update(User user);

    /**
     * 删除用户
     */

    void delete(Integer id);

    /**
     * 根据查询单个用户
     */
    User selectOneById(Integer id);

    /**
     * 根据姓名模糊查询用户
     */
    List<User> findByName(String username);

    /**
     * 根据姓名模糊查询用户
     */
    List<User> findByCondition(User user);

    /**
     * 根据多个id查询用户
     */
    List<User> findUserInIds(User user);

    /**
     * 多个条件中选择一个使用条件查询用户
     */
    List<User> findByConditionOne(User user);
}
