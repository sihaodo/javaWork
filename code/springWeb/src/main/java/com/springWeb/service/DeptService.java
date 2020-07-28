package com.springWeb.service;


import com.springWeb.entity.Dept;

public interface DeptService {

    Dept selectDept(int deptno);

    int addDept(Dept dept);



}
