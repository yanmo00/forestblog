package com.github.forestworld.forestworldblog.controller;

import com.github.forestworld.forestworldblog.entity.Article;
import com.github.forestworld.forestworldblog.service.ArticleService;
import com.github.forestworld.forestworldblog.vo.ResultBean;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    // 发表文章（目前文件仅限md和txt文件）
    @PostMapping("/publish")
    public ResultBean<String> publishArticle(@RequestParam(value = "file",required = false) MultipartFile file) {
        Article article = new Article();
        if (file.isEmpty()){
            return ResultBean.error("文件为空");
        }
        try {
            article.setAuthor("mo");
            //将文章标题设置为文件名称
            article.setTitle(removeExtension(file.getOriginalFilename()));
            article.setContent(getContent(file));
            articleService.publicArticle(article);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResultBean.success();
    }

    // 根据内容查询文章
    @GetMapping("/selectByContent")
    public ResultBean<Map<String, Object>> getArticle(@RequestParam String content){
        List<Article> articles = articleService.searchByContent(content);
        Map<String, Object> results = new HashMap<>();
        results.put("count", articles.size());
        results.put("articles", articles);
        return ResultBean.success("查询成功",results);
    }

    // 获取所有文章
    @GetMapping("/selectAll")
    public ResultBean<Map<String, Object>> getAllArticle(){
        List<Article> articles = articleService.searchAllArticles();
        Map<String, Object> results = new HashMap<>();
        results.put("count", articles.size());
        results.put("articles", articles);
        return ResultBean.success("查询成功",results);
    }

    //获取txt文件和md文件内容
    public String getContent(MultipartFile file) throws IOException {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);
        // 移除字符串中的空字符
        content = content.replace("\0", "");
        return content;
    }

    //去除文件后缀
    public String removeExtension(String fileName) {
        if (fileName == null) {
            return null;
        }
        return fileName.substring(0,fileName.lastIndexOf("."));
    }

}
