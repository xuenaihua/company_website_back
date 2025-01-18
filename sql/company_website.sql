/*
 Navicat Premium Dump SQL

 Source Server         : localhost_33096
 Source Server Type    : MySQL
 Source Server Version : 90100 (9.1.0)
 Source Host           : localhost:33096
 Source Schema         : company_website

 Target Server Type    : MySQL
 Target Server Version : 90100 (9.1.0)
 File Encoding         : 65001

 Date: 18/01/2025 16:31:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for web_goods
-- ----------------------------
DROP TABLE IF EXISTS `web_goods`;
CREATE TABLE `web_goods` (
  `id` bigint NOT NULL,
  `route_id` bigint NOT NULL,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `unit` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sort` int NOT NULL DEFAULT '0',
  `delete_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of web_goods
-- ----------------------------
BEGIN;
INSERT INTO `web_goods` (`id`, `route_id`, `name`, `price`, `unit`, `sort`, `delete_flag`, `create_date`, `update_date`) VALUES (1, 1, '小喇叭', 21.75, '💲', 0, '0', '2025-01-18 08:12:13', '2025-01-18 08:12:13');
INSERT INTO `web_goods` (`id`, `route_id`, `name`, `price`, `unit`, `sort`, `delete_flag`, `create_date`, `update_date`) VALUES (2, 1, '大喇叭', 99.99, '💲', 0, '0', '2025-01-18 08:13:36', '2025-01-18 08:13:36');
INSERT INTO `web_goods` (`id`, `route_id`, `name`, `price`, `unit`, `sort`, `delete_flag`, `create_date`, `update_date`) VALUES (3, 2, '小气球', 0.01, '💲', 0, '0', '2025-01-18 08:13:57', '2025-01-18 08:13:57');
INSERT INTO `web_goods` (`id`, `route_id`, `name`, `price`, `unit`, `sort`, `delete_flag`, `create_date`, `update_date`) VALUES (4, 3, '快餐盒', 10.01, '💲', 0, '0', '2025-01-18 08:14:21', '2025-01-18 08:14:21');
COMMIT;

-- ----------------------------
-- Table structure for web_goods_images
-- ----------------------------
DROP TABLE IF EXISTS `web_goods_images`;
CREATE TABLE `web_goods_images` (
  `id` bigint NOT NULL,
  `goods_id` bigint NOT NULL,
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `file_token` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sort` int NOT NULL DEFAULT '0',
  `delete_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of web_goods_images
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for web_route
-- ----------------------------
DROP TABLE IF EXISTS `web_route`;
CREATE TABLE `web_route` (
  `id` bigint NOT NULL,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sort` int NOT NULL DEFAULT '0',
  `delete_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '0：显示 -1：删除',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of web_route
-- ----------------------------
BEGIN;
INSERT INTO `web_route` (`id`, `name`, `sort`, `delete_flag`, `create_date`, `update_date`) VALUES (1, '分类一', 1, '0', '2025-01-18 08:12:33', '2025-01-18 08:12:33');
INSERT INTO `web_route` (`id`, `name`, `sort`, `delete_flag`, `create_date`, `update_date`) VALUES (2, '分类二', 2, '0', '2025-01-18 08:12:45', '2025-01-18 08:12:45');
INSERT INTO `web_route` (`id`, `name`, `sort`, `delete_flag`, `create_date`, `update_date`) VALUES (3, '分类三', 3, '0', '2025-01-18 08:13:01', '2025-01-18 08:13:01');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
