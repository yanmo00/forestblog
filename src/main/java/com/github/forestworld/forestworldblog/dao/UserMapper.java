package com.github.forestworld.forestworldblog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.forestworld.forestworldblog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    User selectByUsername(String username);
}
