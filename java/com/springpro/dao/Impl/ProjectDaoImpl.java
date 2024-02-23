package com.springpro.dao.Impl;


import com.springpro.dao.ProjectDaoI;
import com.springpro.entity.Project;
import com.springpro.entity.Team;
import com.springpro.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDaoI {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public int insertProject(Project project){
        entityManager.persist(project);
        return 1;
    }

    @Override
    public List<Project> getAll() {
        return entityManager.createQuery("select project From Project project ").getResultList();
    }

    @Override
    public  List<Project> MyProjects(int leader_id)
    {
        Query query = entityManager.createQuery("select project From Project project WHERE project.leader_id= :leader_id");
        query.setParameter("leader_id", leader_id);
        List<Project> myprojects = query.getResultList();
        if(myprojects==null || myprojects.size()==0) return null;
        else return myprojects;

    }

    @Override
    public int UpdateProject(Project project)
    {
        entityManager.merge(project);
        return 1;
    }

    @Override
    public Project GetProjectsById(int p_id)
    {


        Query query=entityManager.createQuery("select project from Project project where project.p_id=:p_id");
        query.setParameter("p_id",p_id);
        List<Project> projectList=query.getResultList();
        if(projectList.size()!=0)
        {
            Project project=projectList.get(0);
            return project;
        }
        else return null;
    }

    @Override
    public int DeleteProject(Project project){
        entityManager.remove(project);
        return 1;
    }
    @Override
    public List<Project> GetProjectByName(String projectname)
    {
        Query query = entityManager.createQuery(" select project FROM Project project WHERE project.p_title like :name ");
        query.setParameter("name", "%"+projectname+"%");
        List<Project> projectList = query.getResultList();
        if(projectList!=null &&projectList.size()!=0){
            return projectList;}
        else {
            return null;
        }
    }
}
