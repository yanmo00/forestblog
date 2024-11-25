package com.github.forestworld.forestworldblog.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.github.forestworld.forestworldblog.dao.UserMapper;
import com.github.forestworld.forestworldblog.entity.User;
import com.github.forestworld.forestworldblog.service.UserService;
import com.github.forestworld.forestworldblog.vo.ResultBean;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Resource
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/add")
    @SaCheckLogin
    public ResultBean<String> addUser() {
        return userService.addUser();
    }


    @PostMapping("/login")
    public ResultBean<Map<String,Object>> login(@RequestParam(value = "username") String username,
                                    @RequestParam(value = "password") String password) {
        User user = userMapper.selectByUsername(username);
        Map<String, Object> result = new HashMap<>();
        if (user != null && password.equals(user.getPassword())){
            StpUtil.login(user.getId());
            result.put("token", StpUtil.getTokenValue());
            return ResultBean.success("登陆成功", result);
        }
        return ResultBean.error("用户名或密码错误");
    }

    @GetMapping("/logout")
    @SaCheckLogin
    public ResultBean<String> logout() {
        StpUtil.logout();
        return ResultBean.success("注销成功");
    }

    @SaCheckLogin
    @GetMapping("/selectByUsername")
    public User selectByUsername(@RequestParam(value = "username") String username) {
        return userService.selectByUsername(username);
    }
}
