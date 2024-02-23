package com.springpro.service.impl;

import com.springpro.dao.MessageDaoI;
import com.springpro.dao.UserDaoI;
import com.springpro.entity.Message;
import com.springpro.entity.User;
import com.springpro.service.MessageServiceI;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageServiceI {
    @Resource
    MessageDaoI messageDaoI;

    @Override
    public Message SendMessage(Message message) {
        return messageDaoI.Invite(message);
    }

    @Override
    public List<Message> MyMessage(User user) {
        return messageDaoI.MyMessage(user);
    }

    @Override
    public void JoinTeam(Message message, User user) {
        messageDaoI.JoinTeam(message,user);
    }

    @Override
    public List<Message> Unread(User user) {
        return messageDaoI.Unread(user);
    }

    @Override
    public List<Message> History(User user) {
        return messageDaoI.History(user);
    }

    @Override
    public Message getMassageById(int message_id) {
        return messageDaoI.GetMassageById(message_id);
    }
}
