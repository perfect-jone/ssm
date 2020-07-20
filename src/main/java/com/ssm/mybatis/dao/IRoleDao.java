package com.ssm.mybatis.dao;

import com.ssm.mybatis.bean.Role;

import java.util.List;

/**
 * @author Jone
 * @create 2020-07-20 10:07
 */
public interface IRoleDao {
    List<Role> findAll();
}
