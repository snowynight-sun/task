package com.springpro.dao.Impl;

import com.springpro.dao.MessageDaoI;
import com.springpro.entity.Message;
import com.springpro.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MessageDaoImpl implements MessageDaoI {
    @PersistenceContext
    EntityManager entityManager;

    /**
     * 添加邀请信息
     **/
    @Override
    public Message Invite(Message message) {
        entityManager.persist(message);
        return message;
    }

    @Override
    public List<Message> MyMessage(User user) {
        Query query = entityManager.createQuery(" select message FROM Message message WHERE message.receive_id=:id");
        query.setParameter("id", user.getUser_id());
        List<Message> messages = query.getResultList();
        if (messages.size() != 0 && messages != null) {
            return messages;
        } else {
            return null;
        }
    }

    @Override
    public void JoinTeam(Message message,User user) {
        entityManager.merge(message);
        entityManager.merge(user);
    }

    @Override
    public List<Message> Unread(User user) {
        Query query = entityManager.createQuery(" select message FROM Message message WHERE message.receive_id=:id and message.m_status=0");
        query.setParameter("id", user.getUser_id());
        List<Message> messages = query.getResultList();
        if (messages.size() != 0 && messages != null) {
//            Message m = messages.get(0);
            return messages;
        } else {
            return null;
        }
    }

    @Override
    public List<Message> History(User user) {
        Query query = entityManager.createQuery(" select message FROM Message message WHERE message.receive_id=:id and message.m_status=1");
        query.setParameter("id", user.getUser_id());
        List<Message> messages = query.getResultList();
        if (messages.size() != 0 && messages != null) {
            return messages;
        } else {
            return null;
        }
    }

    @Override
    public Message GetMassageById(int message_id)
    {
        Message message=entityManager.find(Message.class,message_id);
        return message;
    }
}
