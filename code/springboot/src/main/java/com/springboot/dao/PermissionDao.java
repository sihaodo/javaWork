package com.springboot.dao;

import com.springboot.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

@Mapper
public interface PermissionDao {

    @Select("SELECT PERMISSION_NAME\n" +
            "  FROM T_USER U, T_ROLE R, T_PERMISSION P\n" +
            " WHERE U.ROLE_ID = R.ROLE_ID\n" +
            "   AND R.ROLE_ID = P.ROLE_ID\n" +
            "   AND U.USERNAME = #{name}")
    Set<String> getPermission(String name);

}
