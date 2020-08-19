package com.videoweb.ccassign2.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;

    @NotNull
    //@Column(name="username")
    private String userName;

    @NotNull
    //@Column(name="username")
    private String email;

    @NotNull
    //@Column(name="password")
    private String password;


    public String getUserIdand() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passWord) {
        this.password = passWord;
    }
}
