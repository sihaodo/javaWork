package com.springboot.dao;

import com.springboot.entity.EmpEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpDao {

    EmpEntity getOneEmp();

    @Select("SELECT * FROM EMP")
    List<EmpEntity> getEmpList();
}
