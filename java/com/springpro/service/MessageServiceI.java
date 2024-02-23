package com.springpro.service;

import com.springpro.entity.Message;
import com.springpro.entity.User;

import java.util.List;

public interface MessageServiceI {

    Message SendMessage(Message message);
    List<Message> MyMessage(User user);
    void JoinTeam(Message message,User user);
    List<Message> Unread(User user);
    List<Message> History(User user);
    Message getMassageById(int message_id);
}
