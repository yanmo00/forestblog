package com.github.forestworld.forestworldblog.service.impl;

import com.github.forestworld.forestworldblog.dao.ArticleMapper;
import com.github.forestworld.forestworldblog.entity.Article;
import com.github.forestworld.forestworldblog.repository.ArticleRepository;
import com.github.forestworld.forestworldblog.service.ArticleService;
import com.github.forestworld.forestworldblog.vo.ResultBean;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> searchByContent(String content) {
        return articleRepository.findByContentContaining(content);
    }

    @Override
    public ResultBean<List<Article>> getArticles() {
        return ResultBean.success();
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
