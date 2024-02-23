package com.springpro.dao;

import com.springpro.entity.News;

import java.beans.IntrospectionException;
import java.util.List;

public interface NewsDaoI {
    /**发送信息**/
    News SendNew(News news);

    /**获取团队信息所有信息**/
    List<News> GetAllNews(Integer team_id);

}
