package com.springpro.service;

import com.springpro.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectServiceI {
    int addproject(Project project);
    List<Project> getAllProjects();
    List<Project> getMyProjects(int leader_id);
    int updateProject(Project project);
    Project getProjectsById(int p_id);
//    int deleteProject(Project project);
    List<Project> addleader(List<Project> projects);
    List<Project> getProjectByName(String projectname);
}
