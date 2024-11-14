package com.github.forestworld.forestworldblog.controller;

import com.github.forestworld.forestworldblog.entity.Article;
import com.github.forestworld.forestworldblog.service.ArticleService;
import com.github.forestworld.forestworldblog.vo.ResultBean;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @PostMapping("/publish")
    public ResultBean<String> publishArticle(@RequestParam(value = "file",required = false) MultipartFile file) {
        Article article = new Article();
        if (file.isEmpty()){
            return ResultBean.error("文件为空");
        }
        try {
            article.setAuthor("mo");
            article.setTitle(file.getName());
            article.setContent(parseArticle(file));
            article.setPublishdate(LocalDateTime.now());
            articleService.publicArticle(article);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResultBean.success();
    }

    public String parseArticle(MultipartFile file) throws IOException {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);
        // 移除字符串中的空字符
        content = content.replace("\0", "");
        return content;
    }
}
