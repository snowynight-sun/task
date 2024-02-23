package com.springpro.dao.Impl;

import com.springpro.dao.TaskDaoI;
import com.springpro.entity.Task;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDaoI {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Task> findTaskByPid(int p_id){
        Query query=entityManager.createQuery("select task from Task task where task.p_id=:p_id");
        query.setParameter("p_id",p_id);
        List<Task> taskList= query.getResultList();
        return taskList;
    }
    @Override
    public Task findTaskByTid(int t_id){
        Query query=entityManager.createQuery("select  task from Task task where task.t_id=:t_id");
        query.setParameter("t_id",t_id);
        List<Task> taskList=query.getResultList();
        Task task=taskList.get(0);
        return task;
    }
    @Override
    public Task addTask(Task task){
        entityManager.persist(task);
        return task;
    }
    @Override
    public Task claimTask(Task task){
        entityManager.merge(task);
        return task;
    }
    @Override
    public List<Task> MyTaskList(Integer user_id){
        Query query=entityManager.createQuery("select task from Task task where task.user_id=:user_id");
        query.setParameter("user_id",user_id);
        List<Task> taskList=query.getResultList();
        return taskList;
    }

    @Override
    public List<Task> TaskFile(Integer p_id) {
        Query query=entityManager.createQuery("select task from Task task where task.p_id=:p_id and task.t_status=1");
        query.setParameter("p_id",p_id);
        List<Task> taskList= query.getResultList();
        if(taskList!=null&&taskList.size()!=0){
        return taskList;}
        else {
            return null;
        }
    }
    @Override
    public List<Task> findComTaskByPid(Integer p_id)
    {
        Query query=entityManager.createQuery("select task from Task task where task.p_id=:p_id and task.info like '已完成'");
        query.setParameter("p_id",p_id);
        List<Task> taskList=query.getResultList();
        return taskList;
    }
}
