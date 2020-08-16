package com.springboot.service.imple;

import com.springboot.dao.PermissionDao;
import com.springboot.dao.RoleDao;
import com.springboot.dao.UserDao;
import com.springboot.entity.Permission;
import com.springboot.entity.Role;
import com.springboot.entity.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    public Set<String> getRole(String name){
        return roleDao.getRole(name);
    }
    public Set<String> getPermission(String name){
        return permissionDao.getPermission(name);
    }
    public User getUser(String name){
        return userDao.getUser(name);
    }
}
