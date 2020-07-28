package com.springWeb.service.Imple;

import com.springWeb.annotation.Syslog;
import com.springWeb.dao.EmpDao;
import com.springWeb.entity.Emp;
import com.springWeb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImple implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    @Syslog("hello")
    public Emp select(int id){
        Emp emp = empDao.select(id);
        return emp;
    }
}
