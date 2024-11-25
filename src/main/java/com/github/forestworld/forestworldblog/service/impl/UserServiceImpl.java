package com.github.forestworld.forestworldblog.service.impl;

import com.github.forestworld.forestworldblog.dao.UserMapper;
import com.github.forestworld.forestworldblog.entity.User;
import com.github.forestworld.forestworldblog.service.UserService;
import com.github.forestworld.forestworldblog.vo.ResultBean;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


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
        user.setEmail("2731381449@qq.com");
        user.setAvatar("https://cdn.jsdelivr.net/gh/forestworld/images/avatar.jpg");
        user.setCreatedBy(1L);
        user.setUpdatedBy(1L);
        userMapper.insert(user);
        return ResultBean.success();
    }

    @Override
    public ResultBean<String> login(String username, String password) {
        return null;
    }

    @Override
    public ResultBean<String> logout() {
        return null;
    }

    @Override
    public ResultBean<String> register(String username, String password) {
        return null;
    }

    @Override
    public ResultBean<String> SelectById() {
        return null;
    }

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public User selectById(Long id) {
        return null;
    }

    @Override
    public int updateUser() {
        return 0;
    }
}
