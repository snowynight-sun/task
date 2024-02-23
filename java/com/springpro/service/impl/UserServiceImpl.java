package com.springpro.service.impl;

import com.springpro.dao.UserDaoI;
import com.springpro.entity.User;
import com.springpro.service.UserServiceI;
import org.apache.commons.codec.binary.Base64;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceI {
    @Resource
    UserDaoI userDaoI;

    @Override
    public List<User> getAllUsers() {
        return  userDaoI.getAll();
    }


    @Override
    public List<User> getAlUsers(){return userDaoI.getAl();}

    @Override
    public User Login(String username, String password) {
        return  userDaoI.Login(username, password);
    }

    @Override
    public User  Register(User user) {
        userDaoI.Register(user);
        return user;
    }

    @Override
    public User updateUser(User user) {//更新
        userDaoI.UpdateUser(user);
        return user;
    }

    @Override
    public User getUserById(Integer id) {
        User user = userDaoI.GetUserById(id);
        return user;
    }

    @Override
    public List<User> GetAcceptUser() {

        List<User> userList=userDaoI.GetAcceptUser();
        return userList;
    }

    @Override
    public List<User> getUserByName(String name)
    {
        return userDaoI.GetUserByName(name);
    }
    /**
     * 密码加密处理（MD5）
     * @param src 原密码
     * @return 加密后的内容
     */
    public String md5(String src){
        try{//采用MD5处理
            MessageDigest md =
                    MessageDigest.getInstance("MD5");
            byte[] output = md.digest(
                    src.getBytes());
            //加密处理
            //将加密结果output利用Base64转成字符串输出
            String ret = Base64.encodeBase64String(output);
            return ret;
        }catch(Exception e){
            return "";
        }
    }

}

