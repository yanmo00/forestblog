package com.github.forestworld.forestworldblog.service.impl;

import com.github.forestworld.forestworldblog.dao.ArticleMapper;
import com.github.forestworld.forestworldblog.entity.Article;
//import com.github.forestworld.forestworldblog.repository.ArticleRepository;
import com.github.forestworld.forestworldblog.service.ArticleService;
import com.github.forestworld.forestworldblog.vo.ResultBean;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    // 数据库查找内容匹配文章
    @Override
    public List<Article> searchByContent(String content) {
        return articleMapper.searchByContent(content);
    }

    @Override
    public List<Article> searchByTimeRange(Timestamp startTime, Timestamp endTime) {
        return articleMapper.searchByTimeRange(startTime, endTime);
    }

    @Override
    public List<Article> searchAllArticles() {
        return articleMapper.searchAllArticles();
    }

    // 将文章添加入数据库
    @Override
    public ResultBean<Article> publicArticle(Article article) {
        articleMapper.insert(article);
        return ResultBean.success();
    }


    @Override
    public ResultBean<Article> updateArticle(Article article) {
        return null;
    }

    @Override
    public ResultBean<Article> deleteArticle(String articleId) {
        return null;
    }


}
