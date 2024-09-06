package com.github.forestworld.forestworldblog.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Article {

    @TableId(type = IdType.AUTO)
    private int id;

    private String title;

    private String content;

    private String author;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime publishTime;
}
