package com.springpro.dao.Impl;

import com.springpro.dao.NewsDaoI;
import com.springpro.entity.News;
import com.springpro.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class NewsDaoImpl implements NewsDaoI {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public News SendNew(News news) {
        entityManager.persist(news);
        return news;
    }

    @Override
    public List<News> GetAllNews(Integer team_id) {
        Query query = entityManager.createQuery(" select news FROM News news WHERE news.team_id=:id");
        query.setParameter("id", team_id);
        List<News> newsList = query.getResultList();
        if(newsList!=null &&newsList.size()!=0){
            return newsList;}
        else {
            return null;
        }
    }



}
