package com.ssm.mybatis.sql;

import com.ssm.mybatis.bean.User;
import org.apache.ibatis.jdbc.SQL;


/**
 * @author Jone
 * @create 2020-07-20 17:51
 */
public class UserSql {
    public String selectWhitUserSql(final User user) {
        return new SQL() {
            {
                SELECT("*");
                FROM("user");
                if (user.getId() != null && !user.getId().equals("")) {
                    WHERE("id=#{id}");
                }
                if (user.getUsername() != null && !user.getUsername().equals("")) {
                    WHERE("username=#{username}");
                }
            }
        }.toString();
    }
}
