package com.springWeb.service.Imple;

import com.springWeb.dao.UserDao;
import com.springWeb.entity.User;
import com.springWeb.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CheckServiceImple implements CheckService {

    @Autowired
    private UserDao userDao;

    public User selectUser(User params){
        User user = userDao.selectUser(params);
        return user;
    }
}
