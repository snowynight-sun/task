package com.springpro.dao;

import com.springpro.entity.Project;
import com.springpro.entity.User;

import java.util.List;

public interface ProjectDaoI {
    int insertProject(Project project);
    List<Project> getAll();
    List<Project> MyProjects(int leader_id);
    int UpdateProject(Project project);
    Project GetProjectsById(int p_id);
    int DeleteProject(Project project);
    List<Project> GetProjectByName(String projectname);
}