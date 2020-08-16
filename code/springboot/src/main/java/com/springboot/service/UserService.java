package com.springboot.service;

import com.springboot.entity.Permission;
import com.springboot.entity.Role;
import com.springboot.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    Set<String> getRole(String name);
    Set<String> getPermission(String name);
    User getUser(String name);
}
