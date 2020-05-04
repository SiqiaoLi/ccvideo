package com.videoweb.ccassign2.Dao;


import com.videoweb.ccassign2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User,String> {

    List<User> findByUserNameAndPassword(String userName,String password);

    Optional<User> findById(String id);

    Optional<User> findByUserName(String userName);
}
