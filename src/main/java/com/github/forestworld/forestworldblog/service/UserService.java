package com.github.forestworld.forestworldblog.service;


import com.github.forestworld.forestworldblog.entity.User;
import com.github.forestworld.forestworldblog.vo.ResultBean;


public interface UserService {
    ResultBean<String> addUser();

    ResultBean<String> login(String username, String password);

    ResultBean<String> logout();

    ResultBean<String> register(String username, String password);

    ResultBean<String> SelectById();

    User selectByUsername(String username);

    User selectById(Long id);

    int updateUser();


}
