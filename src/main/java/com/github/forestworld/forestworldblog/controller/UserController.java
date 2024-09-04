package com.github.forestworld.forestworldblog.controller;

import com.github.forestworld.forestworldblog.service.UserService;
import com.github.forestworld.forestworldblog.vo.ResultBean;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @GetMapping("/add")
    public ResultBean<String> addUser() {
        return userService.addUser();
    }
}
