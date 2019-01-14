/*
Navicat MySQL Data Transfer

Source Server         : 39.108.222.143
Source Server Version : 50642
Source Host           : 39.108.222.143:3306
Source Database       : testdb

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2019-01-07 19:50:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_schema_table
-- ----------------------------
CREATE TABLE  IF NOT EXISTS `t_schema_table`(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) DEFAULT NULL COMMENT '表名',
  `status` int(11) DEFAULT NULL COMMENT '0为待执行，1为执行成功，2为执行失败',
  `add_time` datetime DEFAULT NULL COMMENT '新增时间',
  `add_user` varchar(255) DEFAULT NULL COMMENT '新增人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `uodate_user` datetime DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_schema_table
-- ----------------------------
