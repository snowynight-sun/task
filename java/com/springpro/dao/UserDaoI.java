package com.springpro.dao;

import com.springpro.entity.Message;
import com.springpro.entity.User;

import java.util.List;

public interface UserDaoI {
    List<User> getAll();

    User Login(String name, String password);

    User Register(User user);

    User UpdateUser(User user);

    User GetUserById(Integer id);

    List<User> GetAcceptUser();

    List<User> GetUserByName(String username);

    List<User> getAl();
}

