package com.springpro.dao;

import com.springpro.entity.Team;
import com.springpro.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeamDaoI {
    /**新建团队**/
    Team addTeam(Team team);
    /**获取成员列表**/
    List<User> getMyMember(Integer team_id);
    /**展示可邀请成员**/
    List<User> GetAcceptUser();

    Team getTeamById(Integer team_id);

    List<Team> GetTeamByName(String teamname);
}
