package com.github.forestworld.forestworldblog.service;

import com.github.forestworld.forestworldblog.entity.Article;
import com.github.forestworld.forestworldblog.vo.ResultBean;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public interface ArticleService {
    // Service接口写出整体方法，Impl具体实施通过继承重写
    Article searchByArticleId(Integer id);

    List<Article> searchByContent(String content);

    List<Article> searchByTimeRange(Timestamp startTime, Timestamp endTime);

    List<Article> searchAllArticles();

    ResultBean<String> publicArticle(MultipartFile file, String title, String content) throws IOException;

    ResultBean<Article> updateArticle(Article article);

    int deleteArticle(Integer articleId);
}
