package com.springWeb.entity;

public class User {

    private int id;
    private String username;
    private String passcode;
    private String toin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getToin() {
        return toin;
    }

    public void setToin(String toin) {
        this.toin = toin;
    }
}
