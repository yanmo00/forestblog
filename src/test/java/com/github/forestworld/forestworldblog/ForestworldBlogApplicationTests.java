package com.github.forestworld.forestworldblog;

import com.github.forestworld.forestworldblog.controller.UserController;
import com.github.forestworld.forestworldblog.dao.ArticleMapper;
import com.github.forestworld.forestworldblog.dao.UserMapper;
import com.github.forestworld.forestworldblog.entity.Article;
import com.github.forestworld.forestworldblog.entity.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class ForestworldBlogApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void testSelect() {
        userMapper.selectByUsername("forestworld");
    }

    @Test
    public void testLogin(){
        UserController userController = new UserController();
        userController.login("forestworld", "123456");
    }

}
