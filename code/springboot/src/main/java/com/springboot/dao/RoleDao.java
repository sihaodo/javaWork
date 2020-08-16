package com.springboot.dao;

import com.springboot.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

@Mapper
public interface RoleDao {

    @Select("SELECT ROLE_NAME FROM T_USER U,T_ROLE R WHERE U.ROLE_ID = R.ROLE_ID AND U.USERNAME = #{name}")
    Set<String> getRole(String name);
}
