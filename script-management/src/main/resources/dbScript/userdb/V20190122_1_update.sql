/*
Navicat MySQL Data Transfer

Source Server         : 39.108.222.143
Source Server Version : 50642
Source Host           : 39.108.222.143:3306
Source Database       : testdb

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2019-01-06 23:34:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_test01
-- ----------------------------
DROP TABLE IF EXISTS `t_test01`;
CREATE TABLE `t_test01` (
  `id` int(11) NOT NULL  COMMENT 'user',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
