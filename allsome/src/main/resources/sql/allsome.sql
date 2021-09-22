create table if not exists t_user
(
    user_id bigint auto_increment comment '用户ID'
    primary key,
    user_code varchar(32) null comment '用户编码',
    user_name varchar(64) null comment '用户名称',
    user_age int null comment '用户年龄',
    user_passwd varchar(64) null comment '用户密码',
    user_status int default 0 null comment '用户状态（0：正常；1：停用）',
    create_time datetime null comment '创建时间',
    create_by varchar(32) null comment '创建人编码',
    update_time datetime null comment '更新时间',
    update_by varchar(32) null comment '更新人编码'
    )
    comment '用户表';

INSERT INTO t_user (user_id, user_code, user_name, user_age, user_passwd, user_status, create_time, create_by, update_time, update_by) VALUES (1, '0001', 'admin', 29, 'f98c14e65de682eee9f1b7f7e0f99ee5', 0, '2021-09-01 09:31:50', '0002', null, null);