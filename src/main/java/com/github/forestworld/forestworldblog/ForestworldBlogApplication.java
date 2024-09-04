package com.github.forestworld.forestworldblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.github.forestworld.forestworldblog.dao")
public class ForestworldBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForestworldBlogApplication.class, args);
    }

}
