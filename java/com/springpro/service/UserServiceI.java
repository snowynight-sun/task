package com.springpro.service;
import com.springpro.entity.User;

import java.util.List;

public interface UserServiceI {
    List<User> getAllUsers();//获取所有用户信息
    User Login(String username, String password);//登录
    User Register(User user);//注册
    User updateUser(User user);//更新
    User getUserById(Integer id);//根据id查找user
    List<User> GetAcceptUser();
    List<User> getUserByName(String name);
    String md5(String src);
    List<User> getAlUsers();//不显示已注销
}
