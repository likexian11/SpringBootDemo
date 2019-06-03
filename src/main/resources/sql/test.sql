/*
Navicat MySQL Data Transfer

Source Server         : 192.168.170.131
Source Server Version : 50726
Source Host           : 192.168.170.131:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-06-03 14:52:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fkr_academy_info
-- ----------------------------
DROP TABLE IF EXISTS `fkr_academy_info`;
CREATE TABLE `fkr_academy_info` (
  `academy_id` int(11) DEFAULT NULL COMMENT '学院id',
  `school_id` int(11) DEFAULT NULL COMMENT '学校id',
  `school_area_id` int(11) DEFAULT NULL COMMENT '校区id',
  `academy_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学院名称',
  `remark` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of fkr_academy_info
-- ----------------------------
INSERT INTO `fkr_academy_info` VALUES ('1000001', '10000', '1', '食品与生物工程系', null);
INSERT INTO `fkr_academy_info` VALUES ('1000002', '10000', '1', '机械工程系', null);
INSERT INTO `fkr_academy_info` VALUES ('1000003', '10000', '1', '石油与化学工程系', null);
INSERT INTO `fkr_academy_info` VALUES ('1000004', '10000', '1', '中兴通信网络学院', null);
INSERT INTO `fkr_academy_info` VALUES ('1000005', '10000', '2', '汽车工程系', null);
INSERT INTO `fkr_academy_info` VALUES ('100006', '10000', '2', '中职校', null);

-- ----------------------------
-- Table structure for fkr_cost_list
-- ----------------------------
DROP TABLE IF EXISTS `fkr_cost_list`;
CREATE TABLE `fkr_cost_list` (
  `cost_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '缴费id',
  `school_id` int(11) DEFAULT NULL COMMENT '学校id',
  `school_area_id` int(11) DEFAULT NULL COMMENT '校区id',
  `academy_id` int(11) DEFAULT NULL COMMENT '学院id',
  `professional_id` int(11) DEFAULT NULL COMMENT '专业id',
  `cost_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '缴费类型',
  `money` double(11,2) DEFAULT NULL COMMENT '需缴费金额',
  `remark` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`cost_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of fkr_cost_list
-- ----------------------------
INSERT INTO `fkr_cost_list` VALUES ('1', '10000', '1', '1000001', '101', '学费', '320.55', null);
INSERT INTO `fkr_cost_list` VALUES ('2', '10000', '1', '1000001', '101', '住宿费', '200.00', null);
INSERT INTO `fkr_cost_list` VALUES ('3', '10000', '1', '1000001', '101', '其它费用', '100.00', null);
INSERT INTO `fkr_cost_list` VALUES ('4', '10000', '2', '1000002', '104', '学费', '280.00', null);
INSERT INTO `fkr_cost_list` VALUES ('5', '10000', '2', '1000002', '104', '住宿费', '200.00', null);

-- ----------------------------
-- Table structure for fkr_pay
-- ----------------------------
DROP TABLE IF EXISTS `fkr_pay`;
CREATE TABLE `fkr_pay` (
  `sid` varchar(30) DEFAULT NULL COMMENT '交易流水号',
  `business_id` varchar(20) DEFAULT NULL COMMENT '收款商户id',
  `money` double DEFAULT NULL COMMENT '缴费金额',
  `time` datetime DEFAULT NULL COMMENT '交易完成时间',
  `status` int(1) DEFAULT NULL COMMENT '1:收款 2:退款'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of fkr_pay
-- ----------------------------

-- ----------------------------
-- Table structure for fkr_paycost_detail
-- ----------------------------
DROP TABLE IF EXISTS `fkr_paycost_detail`;
CREATE TABLE `fkr_paycost_detail` (
  `paycost_num` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '缴费号',
  `school_id` int(5) DEFAULT NULL COMMENT '学校id',
  `school_area_id` int(11) DEFAULT NULL COMMENT '校区id',
  `school_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学校名称',
  `academy_id` int(11) DEFAULT NULL COMMENT '学院id',
  `academy_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学院名称',
  `professional_id` int(11) DEFAULT NULL COMMENT '专业id',
  `prf_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '专业名称',
  `class_num` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '班级',
  `money` double(10,2) DEFAULT NULL COMMENT '缴费金额',
  `cost_id` int(11) DEFAULT NULL COMMENT '缴费id',
  `cost_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '缴费项目名字',
  `student_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学生名字',
  `batch_num` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '导入批号',
  `remark` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  `is_pay` int(1) DEFAULT NULL COMMENT '是否缴费 1:是/0:否/2:部分缴费',
  `pay_time` datetime DEFAULT NULL COMMENT '缴费时间',
  `status` int(1) DEFAULT NULL COMMENT '是否有效 1:是0：否'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of fkr_paycost_detail
-- ----------------------------
INSERT INTO `fkr_paycost_detail` VALUES ('20190525103300', '10000', '1', '广西工职院-南宁校区', '1000001', '食品与生物工程系', '101', '食品加工技术', '001', '0.01', '2', '学费', '何小健', null, null, '0', null, '1');
INSERT INTO `fkr_paycost_detail` VALUES ('20190525103400', '10000', '1', '广西工职院-南宁校区', '1000001', '食品与生物工程系', '101', '食品加工技术', '001', '0.02', '1', '住宿费', '何小健', null, null, '0', null, '1');
INSERT INTO `fkr_paycost_detail` VALUES ('20190525103722', '10000', '1', '广西工职院-南宁校区', '1000001', '食品与生物工程系', '101', '食品加工技术', '001', '0.01', '3', '书籍费', '何小健', null, null, '0', null, '1');
INSERT INTO `fkr_paycost_detail` VALUES ('121', '10000', '1', '广西工职院-南宁校区', '1000001', '食品与生物工程系', '101', '食品加工技术', '001', '0.01', '4', '学费', '何小健', null, null, '0', null, '1');
INSERT INTO `fkr_paycost_detail` VALUES ('122', '10000', '1', '广西工职院-南宁校区', '1000001', '食品与生物工程系', '101', '食品加工技术', '001', '0.01', '5', '书籍费', '何小健', null, null, '0', null, '1');
INSERT INTO `fkr_paycost_detail` VALUES ('123', '10000', '1', '广西工职院-南宁校区', '1000001', '食品与生物工程系', '101', '食品加工技术', '001', '0.01', '6', 'xx费', '何小健', null, null, '0', null, '1');

-- ----------------------------
-- Table structure for fkr_professional
-- ----------------------------
DROP TABLE IF EXISTS `fkr_professional`;
CREATE TABLE `fkr_professional` (
  `professional_id` int(11) DEFAULT NULL COMMENT '专业id',
  `prf_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '专业名称',
  `school_id` int(11) DEFAULT NULL COMMENT '学校id',
  `school_area_id` int(11) DEFAULT NULL COMMENT '校区id',
  `academy_id` int(11) DEFAULT NULL COMMENT '学院id',
  `remark` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of fkr_professional
-- ----------------------------
INSERT INTO `fkr_professional` VALUES ('101', '食品加工技术', '10000', '1', '1000001', null);
INSERT INTO `fkr_professional` VALUES ('102', '药品生产技术', '10000', '1', '1000001', null);
INSERT INTO `fkr_professional` VALUES ('103', '食品药品监督管理', '10000', '1', '1000001', null);
INSERT INTO `fkr_professional` VALUES ('104', '数控技术', '10000', '1', '1000002', null);
INSERT INTO `fkr_professional` VALUES ('105', '机械设置与制造', '10000', '1', '1000002', null);

-- ----------------------------
-- Table structure for fkr_school_info
-- ----------------------------
DROP TABLE IF EXISTS `fkr_school_info`;
CREATE TABLE `fkr_school_info` (
  `school_id` int(11) NOT NULL COMMENT '学校id',
  `school_area_id` int(11) NOT NULL DEFAULT '1' COMMENT '校区id',
  `school_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学校名称',
  `area_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '校区名称',
  `remark` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`school_id`,`school_area_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of fkr_school_info
-- ----------------------------
INSERT INTO `fkr_school_info` VALUES ('10000', '1', '广西工职院', '南宁校区', null);
INSERT INTO `fkr_school_info` VALUES ('10000', '2', '广西工职院', '贵港校区', null);
INSERT INTO `fkr_school_info` VALUES ('10001', '1', 'xxx学院', '', null);

-- ----------------------------
-- Table structure for fkr_secretkey
-- ----------------------------
DROP TABLE IF EXISTS `fkr_secretkey`;
CREATE TABLE `fkr_secretkey` (
  `business_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '收款商户id',
  `command` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT 'br接口名',
  `app` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT 'br接入商标识',
  `operator_id` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'br收银员的id',
  `version` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '接口版本号',
  `redirect_url` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '支付成功之后的跳转页面',
  `key` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'br校验key',
  PRIMARY KEY (`business_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of fkr_secretkey
-- ----------------------------
INSERT INTO `fkr_secretkey` VALUES ('test123', 'caibao.pay.h5', 'h50008530000066', 'c777292c6becd2d7fd3f7d898e847d04', '1.0', 'www.baidu.com', 'fc471d2a8ec3670f7789e0dfcbb8dfb1');
