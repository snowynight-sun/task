package com.springpro.service.impl;

import com.springpro.dao.TeamDaoI;
import com.springpro.dao.UserDaoI;
import com.springpro.entity.Project;
import com.springpro.entity.Team;
import com.springpro.entity.User;
import com.springpro.service.TeamServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TeamServicelmpl implements TeamServiceI {
    @Resource
    TeamDaoI teamDaoI;
    @Resource
    UserDaoI userDaoI;

    @Override
    public Team addTeam(Team team){
        return teamDaoI.addTeam(team);
    }

    @Override
    public List<User> getMyMember(int team_id){
        List<User> userList=teamDaoI.getMyMember(team_id);
        return userList;
    }

    @Override
    public  Team getTeamById(Integer team_id)
    {
        return teamDaoI.getTeamById(team_id);

    }

    @Override
    public List<Team> getTeamByName(String team_name)
    {
        return teamDaoI.GetTeamByName(team_name);
    }

    @Override
    public List<Team> addLeader_name(List<Team> teamList)
    {
        int n=teamList.size();
        List<Team> teams=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            Team team=teamList.get(i);
            int leader_id=team.getUser_id();
            User user=userDaoI.GetUserById(leader_id);
            team.setLeader_name(user.getName());
            teams.add(team);
        }
        return teams;
    }
}
