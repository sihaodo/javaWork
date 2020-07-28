package com.database;


public interface EmpDao {

    Emp select(long id);

    int delete(long id);

    int update(long id);

    int insert(Emp emp);

}
