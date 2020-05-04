package com.videoweb.ccassign2.service.Impl;

import com.videoweb.ccassign2.Dao.UserDao;
import com.videoweb.ccassign2.entity.User;
import com.videoweb.ccassign2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String id) {
        return userDao.findById(id).get();
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findByUserName(username).get();
    }

    @Override
    public boolean createUser(User user) {
        if(userDao.findByUserName(user.getUserName()).isPresent())
        {
            return false;
        }
        userDao.saveAndFlush(user);
        return true;
    }

    @Override
    public boolean deleteUser(User user) {
        if(userDao.findByUserName(user.getUserName()).isPresent())
        {
            userDao.delete(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean loginValidation(String username, String password) {
        if(!userDao.findByUserNameAndPassword(username,password).isEmpty())
        {
            return true;
        }
        return false;
    }
}
