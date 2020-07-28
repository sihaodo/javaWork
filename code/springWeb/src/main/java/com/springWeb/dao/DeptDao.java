package com.springWeb.dao;

import com.springWeb.entity.Dept;

public interface DeptDao {


    public Dept selectDept(int deptno);

    public int addDept(Dept dept);
}
