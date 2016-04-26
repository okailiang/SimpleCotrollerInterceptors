/*
MySQL Data Transfer
Source Host: localhost
Source Database: simplecontroller
Target Host: localhost
Target Database: simplecontroller
Date: 2015/12/12 17:04:27
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for users
-- ----------------------------
CREATE TABLE `users` (
  `id` varchar(48) NOT NULL,
  `userName` varchar(32) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `users` VALUES ('072c09ad-106f-486e-93b5-d0b94c6f82ec', '123456', '123456');
