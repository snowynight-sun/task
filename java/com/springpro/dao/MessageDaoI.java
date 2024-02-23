package com.springpro.dao;

import com.springpro.entity.Message;
import com.springpro.entity.User;

import java.util.List;

public interface MessageDaoI {
    Message Invite(Message message);
    List<Message> MyMessage(User user);
    void JoinTeam(Message message,User user);
    List<Message> Unread(User user);//第一条未读消息
    List<Message> History(User user);//历史消息
    Message GetMassageById(int message_id);
}
