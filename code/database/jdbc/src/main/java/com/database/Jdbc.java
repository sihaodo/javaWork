package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc {

    public static void selectEmp() throws Exception{
        Connection connection = Util.getConnection();
        String sql = "SELECT * FROM EMP T WHERE T.EMPNO = ?";
        Emp emp = new Emp();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,"7369");
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    emp.setEmpno(resultSet.getLong("empno"));
                    emp.setEname(resultSet.getString("ename"));
                    emp.setJob(resultSet.getString("job"));
                    emp.setMgr(resultSet.getLong("mgr"));
                    emp.setHiredate(resultSet.getDate("hiredate"));
                    emp.setSal(resultSet.getLong("sal"));
                    emp.setComm(resultSet.getLong("comm"));
                    emp.setDeptno(resultSet.getLong("deptno"));
                }
                System.out.println(emp);
            }
        } finally {
            connection.close();
        }
    }
}
