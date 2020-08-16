package com.springboot.entity;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String username;
    private String passcode;
    private String salt;
    private int roleId;
}
