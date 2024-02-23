package com.springpro.service;

import com.springpro.entity.News;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface NewsServiceI {
    News SendNews(News news);
    List<News> getAllNews(Integer team_id);
}
