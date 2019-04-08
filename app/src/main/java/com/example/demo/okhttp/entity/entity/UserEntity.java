package com.example.demo.okhttp.entity.entity;

public class UserEntity {

    private int id;

    private String username;

    private String password;

    public int getId() {
        return id;
    }

    public void setId(int flag) {
        this.id = flag;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getUserPassword() {
        return password;
    }

    public void setUserPassword(String userPassword) {
        this.password = userPassword;
    }
}
