package com.springpro.controller;

import com.springpro.entity.Project;
import com.springpro.entity.Task;
import com.springpro.entity.User;
import com.springpro.service.ProjectServiceI;
import com.springpro.service.TaskServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskServiceI taskServiceI;
    @Autowired
    ProjectServiceI projectServiceImpl;
    //查看项目任务列表
    @RequestMapping("/findtask")
    public ModelAndView findTask(int p_id,HttpSession session){
        Project curpro=projectServiceImpl.getProjectsById(p_id);
        session.setAttribute("curpro",curpro);
        ModelAndView mv=new ModelAndView();
        List<Task> tasks=taskServiceI.findTaskByPid(p_id);
        List<Task> taskList = taskServiceI.setTask(tasks);
        session.setAttribute("taskList",taskList);
        mv.setViewName("ProjectTasklist");
        return mv;
    }
    //前往添加任务页面
    @RequestMapping("/ToaddTask")
    public ModelAndView ToaddTask(int p_id,HttpSession session){
        Project curpro=projectServiceImpl.getProjectsById(p_id);
        ModelAndView mv=new ModelAndView();
        int leader_id=curpro.getLeader_id();
        int project_id=curpro.getP_id();
        mv.addObject("leader_id",leader_id);
        mv.addObject("project_id",project_id);
        mv.setViewName("AddTask");
        return mv;
    }
    //添加任务
    @RequestMapping("/addTask")
    public ModelAndView addTask(int user_id,int p_id,String title,String desc,String s_t,String e_t,HttpSession session){
        ModelAndView mv=new ModelAndView();
        Project curpro=projectServiceImpl.getProjectsById(p_id);
        int leader_id=curpro.getLeader_id();
        Task task=new Task();
        task.setUser_id(user_id);
        task.setP_id(p_id);
        task.setLeader_id(leader_id);
        task.setT_title(title);
        task.setDesct(desc);
        task.setS_t(s_t);
        task.setE_t(e_t);
        task.setUser_id(0);
        task.setT_status(0);
        task.setInfo("未完成");
        Task task1=taskServiceI.addTask(task);
        if(task1!=null){
            session.setAttribute("curpro",curpro);
            List<Task> tasks=taskServiceI.findTaskByPid(p_id);
            List<Task> taskList = taskServiceI.setTask(tasks);
            session.setAttribute("taskList",taskList);
            mv.setViewName("ProjectTasklist");
        }else{ mv.setViewName("AddTask"); }
        return mv;
    }
    //展示未认领任务列表
    @RequestMapping("/ClaimTaskList")
    public ModelAndView ClaimTaskList(int p_id,HttpSession session){
        ModelAndView mv=new ModelAndView();
        List<Task> claimTaskList=taskServiceI.ClaimTaskList(p_id);
        session.setAttribute("claimTaskList",claimTaskList);
        mv.addObject("claimTaskList",claimTaskList);
        mv.setViewName("ClaimTask");
        return mv;
    }
    //认领任务
    @RequestMapping("/ClaimTask")
    public ModelAndView ClaimTask(Integer t_id,HttpSession session){
        User user=(User) session.getAttribute("user");
        Integer user_id=user.getUser_id();
        Project project=(Project) session.getAttribute("curpro");
        Integer p_id=project.getP_id();
        ModelAndView mv=new ModelAndView();
        Task task=taskServiceI.findTaskByTid(t_id);
        task.setUser_id(user_id);
        taskServiceI.claimTask(task);
        List<Task> claimTaskList=taskServiceI.ClaimTaskList(p_id);
        session.setAttribute("claimTaskList",claimTaskList);
        mv.addObject("claimTaskList",claimTaskList);
        mv.setViewName("ClaimTask");
        return mv;
    }

    //查看我的任务列表
    @RequestMapping("/MyTaskList")
    public ModelAndView MyTaskList(Integer user_id,HttpSession session){
        ModelAndView mv=new ModelAndView();
        List<Task> MyTaskList=taskServiceI.MyTaskList(user_id);
        List<Task> MyTasks=taskServiceI.TaskInfo(MyTaskList);
        session.setAttribute("MyTasks",MyTasks);
        mv.addObject("MyTasks",MyTasks);
        mv.setViewName("MyTask");
        return mv;
    }

    //确认完成任务
    @RequestMapping("/finishTask")
    public ModelAndView finishTask(Integer t_id,HttpSession session){
        User user=(User)session.getAttribute("user");
        Integer user_id=user.getUser_id();
        ModelAndView mv=new ModelAndView();
        Task task=taskServiceI.findTaskByTid(t_id);
        task.setT_status(1);
        task.setInfo("已完成");
        taskServiceI.finishTask(task);
        List<Task> MyTaskList=taskServiceI.MyTaskList(user_id);
        List<Task> MyTasks=taskServiceI.TaskInfo(MyTaskList);
        session.setAttribute("MyTasks",MyTasks);
        mv.addObject("MyTasks",MyTasks);
        mv.setViewName("MyTask");
        return mv;
    }
    //前往修改
    @RequestMapping("/ToUpdateTask")
    public ModelAndView ToUpdateTask(Integer t_id,HttpSession session){
        ModelAndView mv=new ModelAndView();
        Task task=taskServiceI.findTaskByTid(t_id);
        session.setAttribute("task",task);
        mv.setViewName("UpdateTask");
        return mv;
    }
    //修改任务
    @RequestMapping("/UpdateTask")
    public ModelAndView UpdateTask(String title,String desc,String s_t,String e_t,HttpSession session ){
        ModelAndView mv=new ModelAndView();
        Task task=(Task) session.getAttribute("task");
        task.setT_title(title);
        task.setDesct(desc);
        task.setS_t(s_t);
        task.setE_t(e_t);
        taskServiceI.claimTask(task);
        mv.setViewName("MyTask");
        return mv;
    }
}
