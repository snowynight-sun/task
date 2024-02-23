package com.springpro.service.impl;

import com.springpro.dao.NewsDaoI;
import com.springpro.entity.News;
import com.springpro.service.NewsServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsServiceI {
    @Resource
    NewsDaoI newsDaoI;

    @Override
    public News SendNews(News news) {
        newsDaoI.SendNew(news);
        return news;
    }

    @Override
    public List<News> getAllNews(Integer team_id) {
        List<News> news = newsDaoI.GetAllNews(team_id);
        return news;
    }

}
