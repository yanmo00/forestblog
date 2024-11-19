package com.github.forestworld.forestworldblog.controller;

import com.github.forestworld.forestworldblog.entity.Article;
import com.github.forestworld.forestworldblog.service.ArticleService;
import com.github.forestworld.forestworldblog.vo.ResultBean;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    /**
 * 发表文章（支持文件上传和手写文字两种方式）
 *
 * @param file 上传的文件（可选）
 * @param content 手写的文章内容（可选）
 * @return 发布结果
 */
@PostMapping("/publish")
public ResultBean<String> publishArticle(
        @RequestParam(value = "file", required = false) MultipartFile file,
        @RequestParam(value = "title", required = false) String title,
        @RequestParam(value = "content", required = false) String content) {

    Article article = new Article();
    if ((file == null || file.isEmpty()) && (content == null || content.trim().isEmpty())) {
        // 如果文件和内容都为空，返回错误信息
        return ResultBean.error("文件和内容均为空");
    }

    try {
        article.setAuthor("mo");
        // 根据上传方式设置文章标题和内容
        if (file != null && !file.isEmpty()) {
            // 文件上传方式
            article.setTitle(removeExtension(file.getOriginalFilename()));
            article.setContent(getContent(file));
        } else {
            // 手写文字方式
            article.setTitle(title);
            article.setContent(content);
        }

        articleService.publicArticle(article);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return ResultBean.success();
}


    // 根据内容查询文章
    @GetMapping("/selectByContent")
    public ResultBean<Map<String, Object>> selectByContent(@RequestParam String content){
        List<Article> articles = articleService.searchByContent(content);
        Map<String, Object> results = new HashMap<>();
        results.put("count", articles.size());
        results.put("articles", articles);
        return ResultBean.success("查询成功",results);
    }

    // 根据时间查询文章
    @GetMapping("/selectByTime")
    public ResultBean<Map<String, Object>> selectByTime(@RequestParam String startTime, @RequestParam String endTime){
        try{
            Timestamp start = Timestamp.valueOf(startTime);
            Timestamp end = Timestamp.valueOf(endTime);
            System.out.println(start);
            System.out.println(end);
            List<Article> articles = articleService.searchByTimeRange(start, end);
            Map<String, Object> results = new HashMap<>();
            results.put("count", articles.size());
            results.put("articles", articles);
            // 返回成功响应
            return ResultBean.success("查询成功", results);
    } catch (IllegalArgumentException e) {
        // 处理非法参数异常
        return ResultBean.error("时间格式错误，请检查输入的时间格式是否正确");
    } catch (Exception e) {
        // 处理其他未知异常
        return ResultBean.error("服务器内部错误");
    }
}

    // 获取所有文章
    @GetMapping("/selectAll")
    public ResultBean<Map<String, Object>> selectAllArticles(){
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
