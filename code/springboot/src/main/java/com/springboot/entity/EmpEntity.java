package com.springboot.entity;

import lombok.Data;

import java.util.Date;

@Data
public class EmpEntity {
    private long empno;
    private String ename;
    private String job;
    private long mgr;
    private Date hiredate;
    private long sal;
    private long comm;
    private long deptno;



}
