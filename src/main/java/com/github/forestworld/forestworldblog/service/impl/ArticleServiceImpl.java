package com.github.forestworld.forestworldblog.service.impl;

import com.github.forestworld.forestworldblog.dao.ArticleMapper;
import com.github.forestworld.forestworldblog.entity.Article;
import com.github.forestworld.forestworldblog.service.ArticleService;
import com.github.forestworld.forestworldblog.vo.ResultBean;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public ResultBean<Article> getArticle(String articleId) {
        return null;
    }

    @Override
    public ResultBean<List<Article>> getArticles() {
        return null;
    }

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
