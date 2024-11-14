package com.github.forestworld.forestworldblog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.forestworld.forestworldblog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArticleMapper extends BaseMapper<Article> {
}
