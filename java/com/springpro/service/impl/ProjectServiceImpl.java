package com.springpro.service.impl;

import com.springpro.dao.Impl.ProjectDaoImpl;
import com.springpro.dao.TeamDaoI;
import com.springpro.entity.Project;
import com.springpro.entity.Team;
import com.springpro.entity.User;
import com.springpro.service.ProjectServiceI;
import com.springpro.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
@Service
public class ProjectServiceImpl implements ProjectServiceI {

    @Autowired
    ProjectDaoImpl projectdao;
    @Autowired
    TeamDaoI teamDao;
    @Autowired
    UserServiceI userServiceI;
    @Override
    public int addproject(Project project)
    {
        int tag= projectdao.insertProject(project);
        return tag;
    }

    @Override
    public List<Project> getAllProjects()
    {
        List<Project> allprojects=projectdao.getAll();
        return allprojects;
    }


//    得到所属团队的所有项目
    @Override
    public List<Project> getMyProjects(int user_id)
    {
        User user=userServiceI.getUserById(user_id);
        int team_id=user.getTeam_id();
        if(team_id==0) return null;
        Team team=teamDao.getTeamById(team_id);
        int leader_id=team.getUser_id();
        List<Project> myprojects=projectdao.MyProjects(leader_id);
        if(myprojects==null || myprojects.size()==0) return null;
        else return myprojects;
    }

    @Override
    public  int updateProject(Project project)
    {
        return projectdao.UpdateProject(project);
    }

    @Override
    public Project getProjectsById(int p_id)
    {
        return projectdao.GetProjectsById(p_id);
    }
//
//    @Override
//    public int deleteProject(Project project)
//    {
//        return projectdao.DeleteProject(project);
//    }


//    为项目列表添加组长姓名列
    @Override
    public List<Project> addleader(List<Project> projects)
    {
        int n=projects.size();
        List<Project> projectList=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            Project project=projects.get(i);
            User user=userServiceI.getUserById(project.getLeader_id());
            project.setLeader_name(user.getName());
            projectList.add(project);
        }
        return projectList;
    }
    @Override
    public List<Project> getProjectByName(String projectname)
    {
        return projectdao.GetProjectByName(projectname);
    }
}