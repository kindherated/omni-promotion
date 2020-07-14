/*
Navicat MySQL Data Transfer

Source Server         : MyDB
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : xus

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2017-08-29 20:17:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for drools_rule
-- ----------------------------
DROP TABLE IF EXISTS `drools_rule`;
CREATE TABLE `drools_rule` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) CHARACTER SET utf8mb4 DEFAULT NULL,
  `rule_type` VARCHAR(30) DEFAULT NULL COMMENT '规则业务类型',
  `rule` MEDIUMTEXT CHARACTER SET utf8mb4,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `visible` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8

-- ----------------------------
-- Records of drools_rule
-- ----------------------------
INSERT INTO `drools_rule` VALUES ('3', 'rule_005', 'package com.purcotton.engine;\r\nimport Person;\r\nrule \"2\"\r\n	when\r\n        $p : Person(age < 30);\r\n    then\r\n		System.out.println(\"hello, young xu2!\");\r\n		$p.setDesc(\"young \"+$p.getName());\r\n		retract($p)\r\nend', '2017-01-17 10:43:14', '2017-08-29 20:15:37', '1');
