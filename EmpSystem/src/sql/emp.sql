/*
 Navicat Premium Data Transfer

 Source Server         : teaching
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : emp

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 14/08/2019 13:53:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_emp
-- ----------------------------
DROP TABLE IF EXISTS `tb_emp`;
CREATE TABLE `tb_emp`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empno` int(11) DEFAULT NULL,
  `ename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` double(11, 0) DEFAULT NULL,
  `comm` double(11, 0) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_emp
-- ----------------------------
INSERT INTO `tb_emp` VALUES (1, 122, '李庆照', '老王', '2018-09-10', 100, 1000, 1, 1);
INSERT INTO `tb_emp` VALUES (20, 14, '杨文健', '后端', '2019-08-15', 2000, 800, 1, 2);
INSERT INTO `tb_emp` VALUES (21, 14, '杨文健', '后端', '2019-08-15', 2000, 800, 1, 2);
INSERT INTO `tb_emp` VALUES (24, 15, '甘志伟', '后端', '2019-08-12', 2000, 900, 2, 1);
INSERT INTO `tb_emp` VALUES (25, 15, '甘志伟', '后端', '2019-08-12', 2000, 900, 2, 1);
INSERT INTO `tb_emp` VALUES (26, 15, '甘志伟', '后端', '2019-08-06', 2000, 900, 2, 1);
INSERT INTO `tb_emp` VALUES (27, 15, '甘志伟', '后端', '2019-08-06', 2000, 900, 2, 1);
INSERT INTO `tb_emp` VALUES (30, 16, '徐佳文', '前端', '2019-08-07', 1000, 100, 2, 1);
INSERT INTO `tb_emp` VALUES (31, 16, '徐佳文', '前端', '2019-08-07', 1000, 100, 2, 1);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userPwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'admin', '666');

SET FOREIGN_KEY_CHECKS = 1;
