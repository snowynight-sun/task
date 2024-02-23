package com.springpro.controller;

import com.springpro.entity.Message;
import com.springpro.entity.User;
import com.springpro.service.MessageServiceI;
import com.springpro.service.TeamServiceI;
import com.springpro.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    UserServiceI userServiceI;

    @Autowired
    MessageServiceI messageServiceI;

    @RequestMapping("/SendMessage")
    public ModelAndView SendMessage(Integer user_id, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Message message = new Message();

        Date date1 = new Date();
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = d.format(date1);

        User user = (User) session.getAttribute("user");
        message.setSend_id(user.getUser_id());
        message.setReceive_id(user_id);
        message.setType(1);
        message.setIn_name(user.getName());
        String user_name = userServiceI.getUserById(user_id).getName();
        message.setBein_name(user_name);
        message.setM_info(user_name + ",您好！我是第" + user.getTeam_id() + "团队的负责人，现诚挚地邀请您加入我们的团队，非常期待与您合作！");
        message.setM_time(date);
        message.setTeam_id(user.getTeam_id());
        message.setM_status(0);

        messageServiceI.SendMessage(message);
        mv.setViewName("InviteUser");

        return mv;
    }

    //所有消息
    @RequestMapping("/MyMessage")
    public ModelAndView MyMesage(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        String info = "没有消息";
        User user = (User) session.getAttribute("user");
        List<Message> messages = messageServiceI.MyMessage(user);
        if (messages != null && messages.size() != 0) {
            session.setAttribute("messages", messages);
        } else {
            mv.addObject("info");
        }
        mv.setViewName("AllMessage");
        return mv;
    }

    //全部未读消息
    @RequestMapping("/Unread")
    public ModelAndView Unread(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        String info = "没有消息";
        User user = (User) session.getAttribute("user");
        List<Message> messages=messageServiceI.Unread(user);
        session.setAttribute("messages", messages);
        if (messages == null || messages.size()==0) {
            mv.addObject("info",info);
        }
        mv.setViewName("UnreadMessage");

        return mv;
    }

    //历史记录 历史已读消息
    @RequestMapping("/History")
    public ModelAndView History(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        String info = "没有消息";
        User user = (User) session.getAttribute("user");
        List<Message> messages = messageServiceI.History(user);
        if (messages != null && messages.size() != 0) {
            session.setAttribute("messages", messages);
        } else {
            mv.addObject("info");
        }
        mv.setViewName("HistoryMessage");
        return mv;
    }

    //接受
    @RequestMapping("/JoinTeam")
    public ModelAndView JoinTeam(int message_id,HttpSession session) {
        ModelAndView mv = new ModelAndView();
        User user = (User) session.getAttribute("user");

        String info = "没有消息";
        List<Message> messages=messageServiceI.Unread(user);
        session.setAttribute("messages", messages);
        if (messages == null || messages.size()==0) {
            mv.addObject("info",info);
        }

        Message message = messageServiceI.getMassageById(message_id);
        user.setTeam_id(message.getTeam_id());
        user.setI_status("已加入");
        message.setM_status(1);
        messageServiceI.JoinTeam(message, user);
        mv.setViewName("UnreadMessage");
        return mv;
    }

//    拒绝
    @RequestMapping("/refuse")
    public ModelAndView refuse(int message_id,HttpSession session){
        ModelAndView mv = new ModelAndView();
        User user = (User) session.getAttribute("user");
        String info = "没有消息";
        List<Message> messages=messageServiceI.Unread(user);
        if (messages != null) {
            session.setAttribute("messages", messages);
        } else {
            mv.addObject("info",info);
        }
        Message message = messageServiceI.getMassageById(message_id);
        user.setI_status("可邀请");
        message.setM_status(1);
        messageServiceI.JoinTeam(message, user);
        mv.setViewName("UnreadMessage");
        return mv;
    }



}
