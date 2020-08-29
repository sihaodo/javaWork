package com.springboot.service;

import com.springboot.entity.EmpEntity;

import java.util.List;

public interface EmpService {

    EmpEntity getOneEmp();

    List<EmpEntity> getEmpList();

}
