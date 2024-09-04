package com.github.forestworld.forestworldblog.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class SQLMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        boolean hasGmtCreate = metaObject.hasSetter("createdAt");
        boolean hasGmtModified = metaObject.hasSetter("updatedAt");
        if (hasGmtCreate) {
            Object gmtCreate = this.getFieldValByName("createdAt", metaObject);
            if (gmtCreate == null) {
                this.strictInsertFill(metaObject, "createdAt", LocalDateTime.class, LocalDateTime.now());
            }
        }
        if (hasGmtModified) {
            Object gmtModified = this.getFieldValByName("updatedAt", metaObject);
            if (gmtModified == null) {
                this.strictInsertFill(metaObject, "updatedAt", LocalDateTime.class, LocalDateTime.now());
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        boolean hasGmtModified = metaObject.hasSetter("updatedAt");
        if (hasGmtModified) {
            Object gmtModified = this.getFieldValByName("updatedAt", metaObject);
            if (gmtModified == null) {
                this.strictInsertFill(metaObject, "updatedAt", LocalDateTime.class, LocalDateTime.now());
            }
        }
    }
}
