/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : demo1

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 15/02/2023 17:16:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '昵称',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', '管理员', 'admin@qq.com', '123456', '河南郑州', '2023-02-14 19:14:05', 'https://www.qqkw.com/d/file/p/2022/04-20/75ad32ce87c79d2a116bc9f75fbe8745.jpg');
INSERT INTO `user` VALUES (3, 'yangyi', '123456', '洋溢', 'yangyi@qq.com', '1365555555', '河南郑州', '2023-02-08 16:32:31', NULL);
INSERT INTO `user` VALUES (4, 'shuangxi', '123456', 'shuangxi', 'shuangxi@gmail.com', '18633333333', '河南郑州', '2023-02-14 20:53:04', 'https://img1.kuwo.cn/star/userhead/87/90/1661522024466_160469487b.jpg');
INSERT INTO `user` VALUES (6, '安安', NULL, '安安', NULL, NULL, NULL, '2023-02-11 19:03:22', NULL);
INSERT INTO `user` VALUES (7, '宝宝', NULL, '宝宝', NULL, NULL, NULL, '2023-02-11 19:03:22', NULL);
INSERT INTO `user` VALUES (12, '改改', NULL, '改改', NULL, NULL, NULL, '2023-02-11 19:03:23', NULL);
INSERT INTO `user` VALUES (13, 'nezha', NULL, '哪吒', NULL, NULL, NULL, '2023-02-11 18:09:26', 'ccccc');
INSERT INTO `user` VALUES (14, 'tangseng', NULL, '1', NULL, NULL, '东土大唐', '2023-02-12 05:09:37', NULL);
INSERT INTO `user` VALUES (21, '111', '111', NULL, NULL, NULL, NULL, '2023-02-14 17:15:32', NULL);
INSERT INTO `user` VALUES (23, '11111', '11111', NULL, NULL, NULL, NULL, '2023-02-15 17:07:16', NULL);

SET FOREIGN_KEY_CHECKS = 1;
