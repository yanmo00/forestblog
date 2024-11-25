package com.github.forestworld.forestworldblog.vo;

import com.github.forestworld.forestworldblog.entity.Article;
import lombok.Data;

import java.util.List;

@Data
public class ArticleTimeVo {
    int count;
    List<Article> articles;

    public ArticleTimeVo(int count, List<Article> articles) {
        this.count = count;
        this.articles = articles;
    }

    public ArticleTimeVo() {

    }
}
