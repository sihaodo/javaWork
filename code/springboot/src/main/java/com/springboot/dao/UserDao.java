package com.springboot.dao;

import com.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("SELECT * FROM T_USER U WHERE U.USERNAME = #{name}")
    User getUser(String name);
}
