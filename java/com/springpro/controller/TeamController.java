package com.springpro.controller;

import com.springpro.entity.Team;
import com.springpro.entity.User;
import com.springpro.service.TeamServiceI;
import com.springpro.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamServiceI teamServiceI;
    @Autowired
    UserServiceI userServiceI;
    //前往创建团队
    @RequestMapping("/ToAddTeam")
    public ModelAndView ToAddTeam(HttpSession session){
        ModelAndView mv=new ModelAndView();
        User user=(User) session.getAttribute("user");
        if(user.getI_status().equals("可邀请"))
            mv.setViewName("AddTeam");
        else
        {
            String info="已有所属队伍";
            mv.addObject("info",info);
            mv.setViewName("UserHome");
        }
        return mv;
    }
    //前往我的团队
    @RequestMapping("/ToMyTeam")
    public ModelAndView ToMyTeam(HttpSession session){
        ModelAndView mv=new ModelAndView();
        User user=(User) session.getAttribute("user");
        int team_id= user.getTeam_id();
        List<User> userList=new ArrayList<>();
        if(team_id!=0)
        {userList= teamServiceI.getMyMember(team_id);}
        else {userList=null;}
        session.setAttribute("userList",userList);
        mv.setViewName("MyTeam");
        return mv;
    }

    //创建团队
    @RequestMapping("/addTeam")
    public ModelAndView addTeam(String team_name, HttpSession session){
        ModelAndView mv = new ModelAndView();
        Team team=new Team();
        User user = (User)session.getAttribute("user");
        int user_id=user.getUser_id();
        team.setTeam_name(team_name);
        team.setUser_id(user_id);
        team.setP_id(0);
        String i_status= user.getI_status();
        if (i_status.contains("邀请")) {
            teamServiceI.addTeam(team);
            session.setAttribute("team",team);
            user.setI_status("组长");
            user.setTeam_id(team.getTeam_id());
            userServiceI.updateUser(user);
            mv.addObject("team", team);
            mv.setViewName("AddTeam");
        } else if(i_status.contains("组长")){
            mv.addObject("info","不能创建第二支团队");
            mv.setViewName("UserHome");
        }
        return mv;
    }

    @RequestMapping("/GetInviteUser")
    public ModelAndView GetAcceptUser(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        List<User> users = userServiceI.GetAcceptUser();
        if(users.size() == 0 || users == null || users.get(0)==null )
        {
            String info="没有可邀请的成员";
            mv.addObject("info",info);
            mv.setViewName("MyTeam");
        }
        else {
            session.setAttribute("users", users);
            mv.setViewName("InviteUser");
        }
        return mv;
    }

}
