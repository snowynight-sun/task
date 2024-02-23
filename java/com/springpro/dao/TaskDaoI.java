package com.springpro.dao;

import com.springpro.entity.Task;

import java.util.List;

public interface TaskDaoI {
    //根据项目id查看任务列表
    List<Task> findTaskByPid(int p_id);
    //根据任务id查看任务
    Task findTaskByTid(int t_id);
    //添加任务
    Task addTask(Task task);
    //认领任务
    Task claimTask(Task task);
    //查看我的任务列表
    List<Task> MyTaskList(Integer user_id);
    List<Task> TaskFile(Integer p_id);
    List<Task> findComTaskByPid(Integer p_id);

}
