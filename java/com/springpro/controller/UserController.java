package com.springpro.controller;

import com.springpro.entity.User;
import com.springpro.entity.Project;
import com.springpro.entity.Team;

import com.springpro.service.ProjectServiceI;
import com.springpro.service.TaskServiceI;
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
@RequestMapping
public class UserController {
    @Autowired
    UserServiceI userService;
    @Autowired
    ProjectServiceI projectServiceI;
    @Autowired
    TaskServiceI taskServiceI;
    @Autowired
    TeamServiceI teamServiceI;

    @RequestMapping("/ToLogin")
    public String index() {
        return "login";
    }

    @RequestMapping("/ToRegister")
    public String register() {
        return "register";
    }

    @RequestMapping("/ToUpdateUser")
    public String toupdateuser() {
        return "UpdateUser";
    }


//    登录
    @RequestMapping("/login")
    public ModelAndView login(String name, String password, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        String pwd=userService.md5(password);
        User user = userService.Login(name, pwd);
        List<Project> allprojects = projectServiceI.getAllProjects();
        List<Project> projects = new ArrayList<>();
        if (allprojects != null ) {
            projects = projectServiceI.addleader(allprojects);
            projects=taskServiceI.addtask_num(projects);
        }
        if (user != null && user.getDel()==0) {
            session.setAttribute("user", user);
            session.setAttribute("allprojects", projects);
            if (user.getI_status().equals("管理员")) {
                mv.setViewName("adminHome");
                List<User> users1 = userService.getAllUsers();
                session.setAttribute("users", users1);
            } else {
                List<User> users = userService.getAlUsers();
                session.setAttribute("users", users);
                mv.setViewName("UserHome");
            }
        } else {
            String info="用户名密码不匹配";
            mv.addObject("info",info);
            mv.setViewName("login");
        }
        return mv;
    }

//    退出
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }


//      进入主页
    @RequestMapping("/toHome")
    public ModelAndView tohome(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        User user = (User) session.getAttribute("user");
        List<Project> allprojects = projectServiceI.getAllProjects();
        List<Project> projects = new ArrayList<>();
        if (allprojects != null) {
            projects = projectServiceI.addleader(allprojects);
//            添加已完成/总任务列
            projects=taskServiceI.addtask_num(projects);
        }
        if (user != null) {

            session.setAttribute("user", user);

            session.setAttribute("allprojects", projects);
            if (user.getI_status().equals("管理员")) {
                List<User> users1 = userService.getAllUsers();
                session.setAttribute("users", users1);
                mv.setViewName("adminHome");
            } else {
                List<User> users = userService.getAlUsers();
                session.setAttribute("users", users);
                mv.setViewName("UserHome");
            }
        }
        return mv;
    }

//      注销
    @RequestMapping("/logoff")
    public ModelAndView logoff(HttpSession session)
    {
        ModelAndView mv=new ModelAndView();
        User user=(User) session.getAttribute("user");
        String info="";
        Integer user_team_id=user.getTeam_id();
        if(user_team_id==0)//可注销
        {
            user.setDel(1);
            userService.updateUser(user);
            session.invalidate();
            info="已注销！";
            mv.addObject("info",info);
            mv.setViewName("login");
        }
        else if(user_team_id==-1)//管理员无法注销
        {
            info="管理员无法注销！";
            mv.addObject("info",info);
            mv=tohome(session);
        }
        else {
            info="已有所属团队，无法注销！";
            mv.addObject("info",info);
            mv=tohome(session);
        }
        return mv;
    }



//  注册
    @RequestMapping("/Register")
    public ModelAndView register(String name, String password, String email, String phone) {
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setName(name);
        String pwd = userService.md5(password);
        user.setPassword(pwd);
        user.setPhone(phone);
        user.setEmail(email);
        user.setI_status("可邀请");
        user.setTeam_id(0);
        user.setDel(1);
        User user1 = userService.Register(user);
        if (user1 != null) {
            mv.setViewName("login");
        }
        return mv;
    }

//    修改用户信息
    @RequestMapping("/updateUser")
    public ModelAndView updateUser(String name, String password, String emial, String phone, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        User user = (User) session.getAttribute("user");
        user.setName(name);
        String pwd = userService.md5(password);
        user.setPassword(pwd);
        user.setEmail(emial);
        user.setPhone(phone);
        userService.updateUser(user);
        mv.setViewName("UserHome");
        return mv;
    }


    @RequestMapping("/select")
    public ModelAndView select(String sel, String value) {
        ModelAndView mv = new ModelAndView();
        if (sel.equals("user_id")) {
            int user_id = Integer.parseInt(value);
            User user = userService.getUserById(user_id);
            if(user!=null){
                List<User> userList = new ArrayList<>();
                userList.add(user);
                mv.addObject("sle_users", userList);
            }else{
                mv.addObject("info","未查询到该用户");
            }
        } else if (sel.equals("name")) {
            List<User> userList = userService.getUserByName(value);
            if(userList!=null && userList.size()!=0){
                mv.addObject("sle_users", userList);
            }else{
                mv.addObject("info","未查询到该用户");
            }
        } else if (sel.equals("team_id")) {
            Integer team_id = Integer.parseInt(value);
            Team team = teamServiceI.getTeamById(team_id);
            if(team!=null){
                List<Team> teamList = new ArrayList<>();
                teamList.add(team);
                teamList = teamServiceI.addLeader_name(teamList);
                mv.addObject("sle_teams", teamList);
            }else{
                mv.addObject("info","未查询到该团队");
            }
        } else if (sel.equals("team_name")) {
            List<Team> teamList = teamServiceI.getTeamByName(value);
            if(teamList!=null && teamList.size()!=0){
                teamList = teamServiceI.addLeader_name(teamList);
                mv.addObject("sle_teams", teamList);
            }else{
                mv.addObject("info","未查询到该团队");
            }
        } else if (sel.equals("p_id")) {
            int p_id = Integer.parseInt(value);
            Project project = projectServiceI.getProjectsById(p_id);
            if(project!=null){
                List<Project> projectList = new ArrayList<>();
                projectList.add(project);
                projectList = projectServiceI.addleader(projectList);
                mv.addObject("sle_projects", projectList);
            }else{
                mv.addObject("info","未查询到该项目");
            }
        } else if (sel.equals("p_title")) {
            List<Project> projectList = projectServiceI.getProjectByName(value);
            if(projectList!=null && projectList.size()!=0){
                projectList = projectServiceI.addleader(projectList);
                mv.addObject("sle_projects", projectList);
            }else{
                mv.addObject("info","未查询到该项目");
            }
        }
        mv.setViewName("sel_result");
        return mv;
    }
}
