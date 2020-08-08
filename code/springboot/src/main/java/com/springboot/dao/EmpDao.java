package com.springboot.dao;

import com.springboot.entity.EmpEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpDao {
    EmpEntity getOneEmp();
}
