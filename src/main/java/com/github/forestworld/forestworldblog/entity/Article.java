package com.github.forestworld.forestworldblog.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Article extends BaseEntity {
    @Id
    private int id;

    private String title;

    private String content;

    private String author;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime publishdate;

}
