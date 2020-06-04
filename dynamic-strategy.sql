/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost:3306
 Source Schema         : dynamic-strategy

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 04/06/2020 15:42:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_services
-- ----------------------------
DROP TABLE IF EXISTS `t_services`;
CREATE TABLE `t_services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '服务名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of t_services
-- ----------------------------
BEGIN;
INSERT INTO `t_services` VALUES (1, 'CA证书', '2020-06-04 10:14:36');
COMMIT;

-- ----------------------------
-- Table structure for t_strategys
-- ----------------------------
DROP TABLE IF EXISTS `t_strategys`;
CREATE TABLE `t_strategys` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` int(11) DEFAULT NULL COMMENT '服务id',
  `strategy_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '策略名称',
  `strategy_class` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '策略实现类',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of t_strategys
-- ----------------------------
BEGIN;
INSERT INTO `t_strategys` VALUES (1, 1, '浙江CA', 'cn.isuyu.dynamic.strategy.strategys.impl.ZheJiangCAStrategy', '2020-06-04 10:15:23');
INSERT INTO `t_strategys` VALUES (2, 1, '湖北CA', 'cn.isuyu.dynamic.strategy.strategys.impl.HuBeiCAStrategy', '2020-06-04 10:15:51');
INSERT INTO `t_strategys` VALUES (3, 1, '沃通CA', 'cn.isuyu.dynamic.strategy.strategys.impl.WoTongCAStrategy', '2020-06-04 10:16:09');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, '苏雨', '2020-06-04 10:26:40');
INSERT INTO `t_user` VALUES (2, '小苏', '2020-06-04 10:26:54');
INSERT INTO `t_user` VALUES (3, '小雨', '2020-06-04 10:27:02');
COMMIT;

-- ----------------------------
-- Table structure for t_user_service_strategy
-- ----------------------------
DROP TABLE IF EXISTS `t_user_service_strategy`;
CREATE TABLE `t_user_service_strategy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `service_id` int(11) DEFAULT NULL,
  `strategy_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of t_user_service_strategy
-- ----------------------------
BEGIN;
INSERT INTO `t_user_service_strategy` VALUES (1, 1, 1, 1);
INSERT INTO `t_user_service_strategy` VALUES (2, 2, 1, 2);
INSERT INTO `t_user_service_strategy` VALUES (3, 3, 1, 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
