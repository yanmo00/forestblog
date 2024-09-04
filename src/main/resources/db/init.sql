create table "users"
(
    id          bigserial
        primary key,
    username    varchar(16)   not null,
    password    varchar(1024) not null,
    email       varchar(64)   not null,
    created_by  bigint        not null,
    updated_by  bigint        not null,
    created_at  date     not null,
    updated_at  timestamp     not null,
    remark      varchar(255)  ,
    avatar      text
);

alter table "users"
    owner to beiyouge;
COMMENT ON TABLE "users" IS '用户表';
COMMENT ON COLUMN "users".username IS '用户名';
COMMENT ON COLUMN "users".password IS '密码';
COMMENT ON COLUMN "users".email IS '邮箱';
COMMENT ON COLUMN "users".avatar IS '头像';
