package com.videoweb.ccassign2.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class appUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;

    @NotNull
    //@Column(name="username")
    private String userName;


    @NotNull
    //@Column(name="password")
    private String passWord;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
