/*
 Navicat Premium Data Transfer

 Source Server         : localmysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : myhome

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 08/08/2019 16:13:23
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_demo_user
-- ----------------------------
DROP TABLE IF EXISTS `t_demo_user`;
CREATE TABLE `t_demo_user` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户ID，主键',
  `user_name` varchar(255) COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名称',
  `password` varchar(255) COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户密码',
  `phone_number` varchar(11) COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

SET FOREIGN_KEY_CHECKS = 1;
