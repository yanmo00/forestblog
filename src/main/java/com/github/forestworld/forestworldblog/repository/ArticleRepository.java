package com.github.forestworld.forestworldblog.repository;

import com.github.forestworld.forestworldblog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByContentContaining(String content);
}
