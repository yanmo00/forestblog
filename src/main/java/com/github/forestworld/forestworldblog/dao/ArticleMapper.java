package com.github.forestworld.forestworldblog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.forestworld.forestworldblog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    List<Article> searchByContent(String content);

    List<Article> searchAllArticles();
}
