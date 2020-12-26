/*
Navicat MySQL Data Transfer

Source Server         : MYSQL
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : audiomgs

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2020-12-26 20:56:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for audio
-- ----------------------------
DROP TABLE IF EXISTS `audio`;
CREATE TABLE `audio` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audio_name` varchar(100) DEFAULT NULL,
  `day_rent` double DEFAULT NULL,
  `deposit` double DEFAULT NULL,
  `inventory` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_Key_2` (`audio_name`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for lease
-- ----------------------------
DROP TABLE IF EXISTS `lease`;
CREATE TABLE `lease` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `real_name` varchar(20) DEFAULT NULL,
  `audio_id` bigint(20) DEFAULT NULL,
  `audio_name` varchar(100) DEFAULT NULL,
  `deposit` double DEFAULT NULL,
  `start_rent_date` datetime DEFAULT NULL,
  `end_rent_date` datetime DEFAULT NULL,
  `rent` double DEFAULT NULL,
  `return_rent` double DEFAULT NULL,
  `lease_status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `real_name` varchar(20) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `identity` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_Key_2` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
