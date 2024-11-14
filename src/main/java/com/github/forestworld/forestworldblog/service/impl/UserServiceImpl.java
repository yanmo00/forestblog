package com.github.forestworld.forestworldblog.service.impl;

import com.github.forestworld.forestworldblog.dao.UserMapper;
import com.github.forestworld.forestworldblog.entity.User;
import com.github.forestworld.forestworldblog.service.UserService;
import com.github.forestworld.forestworldblog.vo.ResultBean;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public ResultBean<String> addUser() {
        var user = new User();
        user.setUsername("forestworld");
        user.setPassword("123456");
        user.setEmail("1252603486@qq.com");
        user.setAvatar("https://cdn.jsdelivr.net/gh/forestworld/images/avatar.jpg");
        user.setCreatedBy(1L);
        user.setUpdatedBy(1L);
        userMapper.insert(user);

        return ResultBean.success();
    }
}
