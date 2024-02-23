package com.springpro.service;

import com.springpro.entity.Team;
import com.springpro.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamServiceI {
    //创建团队
    Team addTeam(Team team);
    //获取成员
    List<User> getMyMember(int team_id);
    Team getTeamById(Integer team_id);
    List<Team> getTeamByName(String team_name);
    List<Team> addLeader_name(List<Team> teamList);
}
