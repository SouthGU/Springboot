/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2019-10-17 22:39:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=11112 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES ('1', '66', '123');
INSERT INTO `stu` VALUES ('2', '45', '456');
INSERT INTO `stu` VALUES ('100', '445', '123');
INSERT INTO `stu` VALUES ('123', '123456', '123456');
INSERT INTO `stu` VALUES ('11111', '1111', '333');

-- ----------------------------
-- Table structure for tb_depart
-- ----------------------------
DROP TABLE IF EXISTS `tb_depart`;
CREATE TABLE `tb_depart` (
  `departNo` int(10) NOT NULL,
  `departName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`departNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_depart
-- ----------------------------
INSERT INTO `tb_depart` VALUES ('1', '软件-1');
INSERT INTO `tb_depart` VALUES ('2', '软件-2');
INSERT INTO `tb_depart` VALUES ('3', '软件-3');

-- ----------------------------
-- Table structure for tb_employee
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `id` int(20) NOT NULL,
  `age` int(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `depart_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `depart_id` (`depart_id`) USING BTREE,
  CONSTRAINT `depar_id` FOREIGN KEY (`depart_id`) REFERENCES `tb_depart` (`departNo`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_employee
-- ----------------------------
INSERT INTO `tb_employee` VALUES ('0', '20', 'Tom', '1');
INSERT INTO `tb_employee` VALUES ('1', '15', 'tac', '1');
INSERT INTO `tb_employee` VALUES ('2', '19', 'Alex', '1');
INSERT INTO `tb_employee` VALUES ('3', '52', 'May', '2');
INSERT INTO `tb_employee` VALUES ('4', '5', 'Terry', '3');
INSERT INTO `tb_employee` VALUES ('8', '15', 'lisen', '2');
