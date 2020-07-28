package com.database;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class Mybatis {

    public static void selectEmp(){
        SqlSessionFactory sqlSessionFactory = UtilSqlSession.getSqlSessionFactory();
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmpDao empDao = sqlSession.getMapper(EmpDao.class);
            Emp emp = empDao.select(7369);
            System.out.println(emp);
        }
    }
}
