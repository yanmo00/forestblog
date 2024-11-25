package com.github.forestworld.forestworldblog.service.impl;

import cn.hutool.core.io.FileUtil;
import com.github.forestworld.forestworldblog.dao.ArticleMapper;
import com.github.forestworld.forestworldblog.entity.Article;
//import com.github.forestworld.forestworldblog.repository.ArticleRepository;
import com.github.forestworld.forestworldblog.service.ArticleService;
import com.github.forestworld.forestworldblog.utils.FileUtils;
import com.github.forestworld.forestworldblog.vo.ResultBean;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article searchByArticleId(Integer id) {
        return articleMapper.selectById(id);
    }

    // 数据库查找内容匹配文章
    @Override
    public List<Article> searchByContent(String content) {
        return articleMapper.searchByContent(content);
    }

    @Override
    public List<Article> searchByTimeRange(Timestamp startTime, Timestamp endTime) {
        return articleMapper.searchByTimeRange(startTime, endTime);
    }

    @Override
    public List<Article> searchAllArticles() {
        return articleMapper.searchAllArticles();
    }

    // 将文章添加入数据库
    @Override
    public ResultBean<String> publicArticle(MultipartFile file, String title, String content) throws IOException {
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
        articleMapper.insertArticle(article);
        return ResultBean.success();
    }

    @Override
    public ResultBean<Article> updateArticle(Article article) {
        int rowsAffected = articleMapper.updateArticle(article);
        if (rowsAffected > 0) {
            return ResultBean.success("更新成功");
        } else {
            return ResultBean.error("更新失败");
        }
    }

    @Override
    public int deleteArticle(Integer articleId) {
        return articleMapper.deleteById(articleId);
    }


}
