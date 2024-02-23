package com.springpro.service;

import com.springpro.entity.Project;
import com.springpro.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskServiceI {
    //根据项目id查看任务列表
    List<Task> findTaskByPid(int p_id);
    //跟俊任务id查看任务
    Task findTaskByTid(int t_id);
    //设置任务状态和执行者
    List<Task> setTask(List<Task> tasks);
    //添加任务
    Task addTask(Task task);
    //展示未认领任务
    List<Task> ClaimTaskList(int p_id);
    //认领任务
    Task claimTask(Task task);
    //查看我的任务列表
    List<Task> MyTaskList(Integer user_id);
    //查看任务状态
    List<Task> TaskInfo(List<Task> TaskList);
    //完成任务
    Task finishTask(Task task);
    List<Task> TaskFile(Integer p_id);
    List<Project> addtask_num(List<Project> projects);
}
