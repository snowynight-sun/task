package com.springpro.dao.Impl;

import com.springpro.dao.TeamDaoI;
import com.springpro.entity.Team;
import com.springpro.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TeamDaoImpl implements TeamDaoI {
    @PersistenceContext
    EntityManager entityManager;
    /**
     * 新建团队
     **/
    @Override
    public Team addTeam(Team team){
        entityManager.persist(team);
        return team;
    }

    @Override
    public List<User> getMyMember(Integer team_id){
        Query query= entityManager.createQuery("select user from User user where user.team_id=:team_id");
        query.setParameter("team_id",team_id);
        List<User> userList= query.getResultList();
        if(userList==null||userList.size()==0){return null;}
        return userList;
    }

    /**
     * 展示所有可以邀请的成员
     */
    @Override
    public List<User> GetAcceptUser(){
        Query query = entityManager.createQuery(" select user FROM User user WHERE user.i_status=:i");
        query.setParameter("i", "可邀请");
        List<User> userList = query.getResultList();
        if(userList!=null &&userList.size()!=0){
            return userList;
        }
        else {
            return null;
        }
    }


//    通过teamid得到team
    @Override
    public Team getTeamById(Integer team_id)
    {
        Query query= entityManager.createQuery("select team from Team team where team.team_id=:team_id");
        query.setParameter("team_id",team_id);
        List<Team> teamList=query.getResultList();
        if(teamList.size()!=0)
        {
            Team team=teamList.get(0);
            return team;
        }
        else return null;
    }

    @Override
    public List<Team> GetTeamByName(String teamname)
    {
        Query query = entityManager.createQuery(" select team FROM Team team WHERE team.team_name like :name ");
        query.setParameter("name", "%"+teamname+"%");
        List<Team> teamList = query.getResultList();

        if(teamList==null || teamList.size()==0){
            return null;
            }
        else {
            return teamList;
        }
    }
}
