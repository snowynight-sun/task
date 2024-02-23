package com.springpro.controller;

import com.springpro.entity.Project;
import com.springpro.entity.User;
import com.springpro.service.ProjectServiceI;
import com.springpro.service.TaskServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Resource
    ProjectServiceI projectServiceI;
    @Resource
    TaskServiceI taskServiceI;


    @RequestMapping("/to_addproject")
    public String to_AddProject()
    {
        return "AddProject";
    }
//    创建项目
    @RequestMapping("/addproject")
    public ModelAndView AddProject(@Valid Project project, BindingResult bindingResult,HttpSession session) {
        User user=(User) session.getAttribute("user");
        ModelAndView mv = new ModelAndView();
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            mv.addObject("info", bindingResult.getFieldError().getDefaultMessage());
            mv.setViewName("UserHome");
        }else if(user.getI_status().equals("组长"))
        {
            project.setTasknum(0);
            project.setComp_tasknum(0);
            project.setLeader_id(user.getUser_id());
            int tag = projectServiceI.addproject(project);

            List<Project> allprojects = projectServiceI.getAllProjects();
            List<Project> projects = new ArrayList<>();
            if (allprojects != null) {
                projects = projectServiceI.addleader(allprojects);
//            添加已完成/总任务列
                projects = taskServiceI.addtask_num(projects);
                session.setAttribute("allprojects", projects);
            }
            if (tag == 0) {
                mv.addObject("info", "创建失败");
                mv.setViewName("UserHome");
            } else {
                mv.setViewName("UserHome");}
        } else {
            String info="非组长无法创建项目";
            mv.addObject("info",info);
            mv.setViewName("UserHome");
        }
        return mv;
    }

//    去我的项目
    @RequestMapping("/projectlist")
    public ModelAndView to_myproject(HttpSession session){
        ModelAndView mv=new ModelAndView();
        User user=(User) session.getAttribute("user");
        int user_id =user.getUser_id();
        if(user.getTeam_id()==0)
        {
            mv.addObject("info","暂无项目");
            mv.setViewName("UserHome");
            return mv;
        }
        List<Project> myprojects= projectServiceI.getMyProjects(user_id);
        session.setAttribute("myprojects",myprojects);
        if(myprojects.size()==0 || myprojects==null)
        {
            mv.addObject("info","暂无项目");
            mv.setViewName("UserHome");
        }
        else mv.setViewName("MyProject");
        return mv;
    }

    @RequestMapping("/to_updateproject")
    public String to_UpdateProject(int p_id,HttpSession session){
        Project curpro= projectServiceI.getProjectsById(p_id);
        session.setAttribute("curpro",curpro);
        return "UpdateProject";
    }

    @RequestMapping("/updateproject")
    public String UpdateProject(String title,String desc,String s_t,String e_t,HttpSession session){
        Project project=(Project) session.getAttribute("curpro");
        project.setP_title(title);
        project.setDesct(desc);
        project.setS_t(s_t);
        project.setE_t(e_t);
        projectServiceI.updateProject(project);
        return "MyProject";
    }

//    @RequestMapping("/deleteproject")
//    public String DeleteProject(int p_id,HttpSession session)
//    {
//        Project curpro= projectServiceI.getProjectsById(p_id);
//        session.setAttribute("curpro",curpro);
//        projectServiceI.deleteProject(curpro);
//        return "MyProject";
//    }
}
