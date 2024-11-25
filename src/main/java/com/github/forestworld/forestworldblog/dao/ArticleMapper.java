package com.github.forestworld.forestworldblog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.forestworld.forestworldblog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    int insertArticle(Article article);

    List<Article> searchByContent(String content);

    List<Article> searchAllArticles();

    List<Article> searchByTimeRange(Timestamp startTime, Timestamp endTime);

    int updateArticle(Article article);
}
