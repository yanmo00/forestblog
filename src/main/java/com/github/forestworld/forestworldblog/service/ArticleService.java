package com.github.forestworld.forestworldblog.service;

import com.github.forestworld.forestworldblog.entity.Article;
import com.github.forestworld.forestworldblog.entity.User;
import com.github.forestworld.forestworldblog.vo.ResultBean;

import java.util.List;

public interface ArticleService {
    // Service接口写出整体方法，Impl具体实施通过继承重写
    List<Article> searchByContent(String content);

    ResultBean<List<Article>> getArticles();

    ResultBean<Article> publicArticle(Article article);

    ResultBean<Article> updateArticle(Article article);

    ResultBean<Article> deleteArticle(String articleId);
}
