package com.springpro.service.impl;

import com.springpro.dao.TaskDaoI;
import com.springpro.dao.UserDaoI;
import com.springpro.entity.Project;
import com.springpro.entity.Task;
import com.springpro.entity.User;
import com.springpro.service.TaskServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskServiceI {
    @Resource
    TaskDaoI taskDaoI;
    @Resource
    UserDaoI userDaoI;
    @Override
    public List<Task> findTaskByPid(int p_id){
        List<Task> taskList=taskDaoI.findTaskByPid(p_id);
        return taskList;
    }
    @Override
    public Task findTaskByTid(int t_id){
        Task task=taskDaoI.findTaskByTid(t_id);
        return task;
    }
    @Override
    public List<Task> setTask(List<Task> tasks){
        int k=tasks.size();
        List<Task> taskList=new ArrayList<>();
        for(int i=0;i<k;i++){
            Task task=tasks.get(i);
            if(task.getUser_id() != 0&&task.getT_status()==0){
                User user=userDaoI.GetUserById(task.getUser_id());
                task.setInfo("未完成");
                task.setUsername(user.getName());
            }else if(task.getT_status()!=0){
                User user=userDaoI.GetUserById(task.getUser_id());
                task.setInfo("已完成");
                task.setUsername(user.getName());
            }else{
                task.setInfo("未被领取");
                task.setUsername("暂无");
            }
            taskList.add(task);
        }
        return taskList;
    }
    @Override
    public Task addTask(Task task){
        taskDaoI.addTask(task);
        return task;
    }
    @Override
    public List<Task> ClaimTaskList(int p_id){
        List<Task> tasks=taskDaoI.findTaskByPid(p_id);
        int k=tasks.size();
        List<Task> claimTaskList=new ArrayList<>();
        for(int i=0;i<k;i++){
            Task task=tasks.get(i);
            if(task.getUser_id()==0){
                claimTaskList.add(task);
            }
        }
        return claimTaskList;
    }
    @Override
    public Task claimTask(Task task){
        taskDaoI.claimTask(task);
        return task;
    }
    @Override
    public List<Task> MyTaskList(Integer user_id){
        List<Task> taskList=taskDaoI.MyTaskList(user_id);
        return taskList;
    }
    @Override
    public List<Task> TaskInfo(List<Task> MyTaskList){
        List<Task> MyTasks=new ArrayList<>();
       for(int i=0;i<MyTaskList.size();i++){
           Task task=MyTaskList.get(i);
           if(task.getT_status()==1){
               task.setInfo("已完成");
           }else {
               task.setInfo("未完成");
           }
           taskDaoI.claimTask(task);
           MyTasks.add(task);
       }
       return MyTasks;
    }
    @Override
    public Task finishTask(Task task){
        Task task1=taskDaoI.claimTask(task);
        return task1;
    }
    @Override
    public List<Project> addtask_num(List<Project> projects)
    {
        int n=projects.size();
        List<Project> projectList=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            Project project=projects.get(i);
            List<Task> tasks1=taskDaoI.findComTaskByPid(project.getP_id());
            int comnum=tasks1.size();
            List<Task> tasks=taskDaoI.findTaskByPid(project.getP_id());
            int sum=tasks.size();

            project.setTasknum(sum);
            project.setComp_tasknum(comnum);
            projectList.add(project);
        }
        return projectList;

    }

    @Override
    public List<Task> TaskFile(Integer p_id) {
        return taskDaoI.TaskFile(p_id);
    }
}
