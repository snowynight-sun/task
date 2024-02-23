package com.springpro.controller;

import com.springpro.dao.NewsDaoI;
import com.springpro.entity.News;
import com.springpro.entity.User;
import com.springpro.service.NewsServiceI;
import com.springpro.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class NewsController {
    @Autowired
    NewsServiceI newsServiceI;

    @RequestMapping(value = "/ToChat")
    public String Tochat(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<News> newsList = newsServiceI.getAllNews(user.getTeam_id());
        session.setAttribute("newsList",newsList);
        return "chat";
    }

//    发送消息
    @RequestMapping("/SendNews")
    public ModelAndView SendNews(String info, HttpSession session) {
        ModelAndView mv = new ModelAndView("chat");
        News news = new News();
        Date date1 = new Date();
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = d.format(date1);
        User user = (User) session.getAttribute("user");
        news.setInfo(info);
        news.setUser_id(user.getUser_id());
        news.setTeam_id(user.getTeam_id());
        news.setUser_name(user.getName());
        news.setTime(date);
        newsServiceI.SendNews(news);

        List<News> newsList = newsServiceI.getAllNews(user.getTeam_id());
        session.setAttribute("newsList",newsList);
        return mv;
    }


}
