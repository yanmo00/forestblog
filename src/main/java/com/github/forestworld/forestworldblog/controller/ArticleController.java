package com.github.forestworld.forestworldblog.controller;

import cn.hutool.core.io.FileUtil;
import com.github.forestworld.forestworldblog.entity.Article;
import com.github.forestworld.forestworldblog.service.ArticleService;
import com.github.forestworld.forestworldblog.utils.FileUtils;
import com.github.forestworld.forestworldblog.vo.ResultBean;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;



@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;


    /**
     * 发表文章（支持文件上传和手写文字两种方式）
     * @param file 上传的文件（可选）
     * @param content 手写的文章内容（可选）
     * @return 发布结果
     */
    @PostMapping("/publish")
    public ResultBean<String> publishArticle(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "content", required = false) String content) throws IOException {
        File newfile = FileUtils.switchFormat(file);
        Article article = new Article();
        article.setAuthor("mo");
        // 根据上传方式设置文章标题和内容
        if (FileUtil.exist(newfile)) {
            // 文件上传方式
            article.setTitle(FileUtils.getOriginalFilename(newfile));
            article.setContent(FileUtils.getContent(newfile));
        } else {
            // 手写文字方式
            article.setTitle(title);
            article.setContent(content);
        }
        articleService.publicArticle(article);
        return ResultBean.success();
    }

    /**
     * 根据id删除文章
     * @param articleId （所要删除文章的id）
     * @return 发布结果
     */
    @DeleteMapping("/delete")
    public ResultBean<String> deleteArticle(@RequestParam Integer articleId) {
            // 检查 articleId 是否为空
            if (articleId == null) {
                return ResultBean.error("articleId cannot be empty");
            }
            articleService.deleteArticle(articleId);
            return ResultBean.success();
        }


    @PutMapping("/update")
    public ResultBean<Article> updateArticle(@RequestParam(required = false) int id,
                                             @RequestParam(required = false) String content,
                                             @RequestParam(required = false) String title,
                                             @RequestParam(required = false) String author) {

        Article article = articleService.searchByArticleId(id);
        if (article == null){
            return ResultBean.error("Article not found");
        }
        if (content != null) {
            article.setContent(content);
        }
        if (title != null) {
            article.setTitle(title);
        }
        if (author != null) {
            article.setAuthor(author);
        }
        return articleService.updateArticle(article);
    }

    /**
     * 根据id查询文章
     * @param id （文章id）
     * @return 发布结果
     */
    @GetMapping("/selectById/{id}")
    public ResultBean<Article> selectById(@PathVariable("id") Integer id) {
        Article article = articleService.searchByArticleId(id);
        return ResultBean.success("查询成功",article);
    }

    /**
     * 根据内容查询文章
     * @param content （所要搜索的内容）
     * @return 发布结果
     */
    @GetMapping("/selectByContent")
    public ResultBean<List<Article>> selectByContent(@RequestParam String content){
        List<Article> articles = articleService.searchByContent(content);
        return ResultBean.success("查询成功",articles);
    }

    /**
     * 根据时间查询文章
     * @param startTime （开始时间）
     * @param endTime   （结束时间）
     * @return 发布结果
     */
    @GetMapping("/selectByTime")
    public ResultBean<List<Article>> selectByTime(@RequestParam String startTime, @RequestParam String endTime){
        Timestamp start = Timestamp.valueOf(startTime);
        Timestamp end = Timestamp.valueOf(endTime);
        List<Article> articles = articleService.searchByTimeRange(start, end);
        return ResultBean.success("查询成功", articles);
}

    /**
     * 查询所有文章
     * @return 发布结果
     */
    @GetMapping("/selectAll")
    public ResultBean<List<Article>> selectAllArticles() {
        List<Article> articles = articleService.searchAllArticles();
        return ResultBean.success("查询成功", articles);
    }

}
