package com.ssm.mybatis.dao;

import com.ssm.mybatis.bean.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author Jone
 * @create 2020-07-19 22:44
 */
public interface IAccountDao {
    /**
     * 查询每个账户下的所有信息，包括用户姓名，性别，地址等
     *
     * @return
     */
    List<Account> findAccountAll();

    /**
     * 使用注解
     */

    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "money", column = "money"),
            @Result(property = "user",column = "uid",
                    one=@One(select="com.ssm.mybatis.dao.IUserDao.findUserById_Annotation",fetchType = FetchType.EAGER))
    })
    List<Account> findAccountAll_Annotation();

    @Select("select * from account where uid=#{uid}")
    Account findAccountById(Integer id);

}
