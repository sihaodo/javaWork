package com.springboot.service.imple;

import com.springboot.dao.EmpDao;
import com.springboot.entity.EmpEntity;
import com.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImple implements EmpService {

    @Autowired
    private EmpDao empDao;

    public EmpEntity getOneEmp(){
        return empDao.getOneEmp();
    }

    public List<EmpEntity> getEmpList(){
        return empDao.getEmpList();
    }
}
