package com.github.forestworld.forestworldblog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.forestworld.forestworldblog.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
