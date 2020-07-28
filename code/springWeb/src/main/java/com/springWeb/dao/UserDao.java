package com.springWeb.dao;

import com.springWeb.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface UserDao {

    @Select("SELECT * FROM TABLE_USER T WHERE T.USERNAME = #{username} AND T.PASSCODE = #{passcode}")
    public User selectUser(User params);
}
