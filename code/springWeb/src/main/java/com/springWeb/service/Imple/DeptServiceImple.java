package com.springWeb.service.Imple;

import com.springWeb.dao.DeptDao;
import com.springWeb.entity.Dept;
import com.springWeb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImple implements DeptService {

    @Autowired
    private DeptDao deptDao;

    public Dept selectDept(int deptno){
        Dept dept = deptDao.selectDept(deptno);
        return dept;
    }

    public int addDept(Dept dept){
        return deptDao.addDept(dept);
    }

}
