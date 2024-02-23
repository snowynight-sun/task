package com.springpro.dao.Impl;

import com.springpro.dao.UserDaoI;
import com.springpro.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDaoI {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select user From User user ").getResultList();
    }

    /**
     * 登录用户
     **/
    @Override
    public User Login(String username, String password) {
        Query query = entityManager.createQuery(" select user FROM User user WHERE user.name = :name and user.password = :password");
        query.setParameter("name", username);
        query.setParameter("password", password);
        List<User> userList = query.getResultList();
        if(userList!=null &&userList.size()!=0){
        return userList.get(0);}else {
            return null;
        }
    }

    /**
     * 注册用户
     **/
    @Override
    public User Register(User user) {
        entityManager.persist(user);
        return user;
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @Override
    public User UpdateUser(User user) {
        entityManager.merge(user);
        return user;
    }

    /**
     * 通过id获取user
     * @param id
     * @return
     */
    @Override
    public User GetUserById(Integer id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    /**
     * 展示所有可以邀请的成员
     */
    @Override
    public List<User> GetAcceptUser(){
        Query query = entityManager.createQuery(" select user FROM User user WHERE user.team_id=0 and user.del=0 ");
        List<User> userList = query.getResultList();
        if(userList==null || userList.size()==0) return null;
        else return userList;
    }

    @Override
    public List<User> GetUserByName(String username)
    {
        Query query = entityManager.createQuery(" select user FROM User user WHERE user.name like :name ");
        query.setParameter("name", "%"+username+"%");
        List<User> userList = query.getResultList();
        if(userList!=null &&userList.size()!=0){
            return userList;}
        else {
            return null;
        }
    }

    @Override
    public List<User> getAl()
    {
        Query query = entityManager.createQuery(" select user FROM User user where user.del=0");
        List<User> userList = query.getResultList();
        if(userList==null || userList.size()==0) return null;
        else return userList;
    }
}
