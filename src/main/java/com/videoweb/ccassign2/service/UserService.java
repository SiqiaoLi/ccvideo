package com.videoweb.ccassign2.service;


import com.videoweb.ccassign2.entity.User;

public interface UserService {
    User getUser(String id);

    User getUserByUsername(String username);

    boolean createUser(User user);

    boolean deleteUser(User user);

    boolean loginValidation(String username,String password);
}
