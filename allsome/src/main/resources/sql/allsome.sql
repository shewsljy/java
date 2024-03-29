/*
 Navicat Premium Data Transfer

 Source Server         : localmysql
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : allsome

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 11/10/2021 10:44:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
                           `user_id` bigint(0) NOT NULL COMMENT '用户ID',
                           `user_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户编码',
                           `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
                           `user_age` int(0) NULL DEFAULT NULL COMMENT '用户年龄',
                           `user_passwd` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
                           `user_status` int(0) NULL DEFAULT 0 COMMENT '用户状态（0：正常；1：停用）',
                           `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                           `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人编码',
                           `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                           `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人编码',
                           PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '0001', 'admin', 29, 'f98c14e65de682eee9f1b7f7e0f99ee5', 1, '2021-09-01 09:31:50', '0002', '2021-09-24 16:53:13', 'admin');
INSERT INTO `t_user` VALUES (4, '0002', 'user02', 25, '87ed7cf61b00ef9b9251b8fd9b383c00', 0, '2021-09-24 17:52:42', 'admin', NULL, NULL);
INSERT INTO `t_user` VALUES (17, '0003', 'user03', 26, 'aa5e35372fcfbc316e8f35c10d0a9e18', 1, '2021-09-27 17:19:48', 'admin', NULL, NULL);
INSERT INTO `t_user` VALUES (18, '0004', 'user04', 18, '7cd5fa05fd544e3451eb8bfb928b4c61', 0, '2021-09-27 17:20:01', 'admin', NULL, NULL);
INSERT INTO `t_user` VALUES (19, '0005', 'user05', 28, '134a4fc58d5ec19c16f1c6d5618fd820', 0, '2021-09-27 17:20:13', 'admin', NULL, NULL);
INSERT INTO `t_user` VALUES (20, '0006', 'user06', 22, 'd2360667fabfa111c0f696d490878f95', 1, '2021-09-27 17:20:25', 'admin', NULL, NULL);
INSERT INTO `t_user` VALUES (21, '0007', 'user07', 32, 'c8edecf1520c9a8ec12505b61001c2a8', 1, '2021-09-27 17:20:34', 'admin', NULL, NULL);
INSERT INTO `t_user` VALUES (22, '0008', 'user08', 31, '556f2c47470bb01516f845e479b6c504', 0, '2021-09-27 17:20:47', 'admin', NULL, NULL);
INSERT INTO `t_user` VALUES (23, '0009', 'user09', 34, '5a8db9b1097fb707cc613a311db919ec', 0, '2021-09-27 17:20:57', 'admin', NULL, NULL);
INSERT INTO `t_user` VALUES (24, '0010', 'user10', 33, '5a682e5e71d4abba5d26566f260dc1a8', 0, '2021-09-27 17:21:08', 'admin', NULL, NULL);
INSERT INTO `t_user` VALUES (25, '0011', 'user11', 21, '11448f2e82464d00039755dbb6f6cd06', 0, '2021-09-27 17:21:17', 'admin', NULL, NULL);
INSERT INTO `t_user` VALUES (26, '0012', 'user12', 24, 'f72949b8235c3ef4ed0e73a6e8a795d0', 1, '2021-09-27 17:21:30', 'admin', NULL, NULL);


-- ----------------------------
-- Table structure for mysql_sequence
-- ----------------------------
DROP TABLE IF EXISTS `mysql_sequence`;
CREATE TABLE `mysql_sequence`  (
                                   `seq_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '序列名',
                                   `current_val` bigint(0) NOT NULL DEFAULT 0 COMMENT '序列当前值',
                                   `increment_val` int(0) NOT NULL DEFAULT 1 COMMENT '序列步长',
                                   PRIMARY KEY (`seq_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mysql_sequence
-- ----------------------------
INSERT INTO `mysql_sequence` VALUES ('seq_user', 100, 1);

CREATE FUNCTION `currval`(v_seq_name VARCHAR(80)) RETURNS bigint
begin
    declare value bigint;
    set value = 0;
    select current_val into value from mysql_sequence where seq_name = v_seq_name;
    return value;
end;

CREATE FUNCTION `nextval`(v_seq_name VARCHAR(80)) RETURNS bigint
begin
    update mysql_sequence set current_val = current_val + increment_val where seq_name = v_seq_name;
    return currval(v_seq_name);
end;

SET FOREIGN_KEY_CHECKS = 1;