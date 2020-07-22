package com.ssm.mybatis.dao;

import com.ssm.mybatis.bean.User;
import com.ssm.mybatis.sql.UserSql;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.mapping.FetchType;


import java.util.List;

/**
 * @author Jone
 * @create 2020-07-17 10:49
 * 用户持久层
 */
//@CacheNamespace(blocking=true)//mybatis 基于注解方式实现配置二级缓存
public interface IUserDao {
    /**
     * 查询所有用户
     *
     */
    // 使用注解定义sql语句 @Select("select * from user")

    List<User> findAll();

    List<User> findUserAll();

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

    /**
     * 使用注解
     */
    @SelectProvider(type =com.ssm.mybatis.sql.UserSql.class,method = "selectWhitUserSql")
    List<User> findUserByAnnotation(User user);

    @Select(value = "select * from user where id=#{id}")
    @ResultMap("userMap")
    User findUserById_Annotation(Integer id);

    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "address",column = "address"),
            @Result(property = "accounts",column = "id",
                    many=@Many(select = "com.ssm.mybatis.dao.IAccountDao.findAccountById",
                            fetchType = FetchType.LAZY))
    })
    List<User> findAll_Annotation();

}
