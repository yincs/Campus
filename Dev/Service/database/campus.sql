/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : campus

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-02-29 00:01:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL,
  `user_id` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `remark` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_sex` int(1) NOT NULL DEFAULT '2' COMMENT '0女；1男；2不祥',
  `user_brithday` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '1992-02-12',
  `user_shool_current` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'xxx省xxx市xxx区/县xxx',
  `user_friends` varchar(3500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '(6+1)x500',
  `user_friends_applying` varchar(350) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '(6+1)x50',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_info
-- ----------------------------
