/*
Navicat MySQL Data Transfer

Source Server         : 192.168.170.131
Source Server Version : 50726
Source Host           : 192.168.170.131:3306
Source Database       : fkr_pay_website

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-06-04 14:08:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pay_info
-- ----------------------------
DROP TABLE IF EXISTS `pay_info`;
CREATE TABLE `pay_info` (
  `id` varchar(40) NOT NULL COMMENT '编号',
  `pay_no` varchar(40) NOT NULL COMMENT '缴费号',
  `pay_project_id` varchar(40) NOT NULL COMMENT '缴费项目',
  `pay_money` double(10,0) NOT NULL COMMENT '缴费金额',
  `already_pay` double(10,0) DEFAULT NULL COMMENT '已缴费金额',
  `is_pay_over` varchar(10) NOT NULL COMMENT '是否缴费完成',
  `pay_over_time` datetime DEFAULT NULL COMMENT '缴费完成时间',
  `pay_content` varchar(500) DEFAULT NULL COMMENT '费用说明',
  `pay_years` varchar(20) DEFAULT NULL COMMENT '缴费年度',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='缴费数据';

-- ----------------------------
-- Records of pay_info
-- ----------------------------
INSERT INTO `pay_info` VALUES ('1D582BA67794406A882B38F34DC41E4D', '201810001', '31578ff3-800c-4f51-8763-f960ff4ce567', '1', null, '0', null, '无', '2019', '无');

-- ----------------------------
-- Table structure for pay_info_detail
-- ----------------------------
DROP TABLE IF EXISTS `pay_info_detail`;
CREATE TABLE `pay_info_detail` (
  `app_order_no` varchar(40) NOT NULL COMMENT '订单号',
  `pay_info_id` varchar(40) NOT NULL COMMENT '缴费信息编号（外键作用）',
  `cb_order_no` varchar(64) NOT NULL COMMENT '慧商通的订单号',
  `out_order_no` varchar(100) NOT NULL COMMENT '支付宝或者微信产生的订单号',
  `order_status` varchar(40) NOT NULL COMMENT '订单状态（参考慧商通接口文档）',
  `total_amount` double DEFAULT NULL COMMENT '订单总额',
  `receive_amount` double DEFAULT NULL COMMENT '实收总额',
  `payment_channel` varchar(50) DEFAULT NULL COMMENT '支付渠道, 详情参照：支付渠道详解',
  `subject` text COMMENT '订单简介',
  `discount_amount` double DEFAULT NULL COMMENT '优惠金额',
  `payment_way` varchar(50) DEFAULT NULL COMMENT '支付方式，详情参照：支付方式详解',
  `pay_time` varchar(50) DEFAULT NULL COMMENT '支付时间，数字格式，值为距离1970.1.1日的毫秒数',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`app_order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='缴费流水';

-- ----------------------------
-- Records of pay_info_detail
-- ----------------------------

-- ----------------------------
-- Table structure for pay_personnel
-- ----------------------------
DROP TABLE IF EXISTS `pay_personnel`;
CREATE TABLE `pay_personnel` (
  `id` varchar(40) NOT NULL COMMENT '编号',
  `organ_no` varchar(40) NOT NULL COMMENT '归属机构',
  `pay_no` varchar(40) NOT NULL COMMENT '缴费号（唯一）',
  `per_name` varchar(40) NOT NULL COMMENT '缴费人员名称',
  `tel` varchar(40) NOT NULL COMMENT '缴费人员手机号',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='缴费人员';

-- ----------------------------
-- Records of pay_personnel
-- ----------------------------
INSERT INTO `pay_personnel` VALUES ('593E9F0934674BED988DCA644694A9AA', '108', '201810002', '李健', '15075754545', '无');
INSERT INTO `pay_personnel` VALUES ('E692CC516D784152A5017D241292F8DC', '108', '201810001', '王泽', '15245454545', '测试');

-- ----------------------------
-- Table structure for pay_project
-- ----------------------------
DROP TABLE IF EXISTS `pay_project`;
CREATE TABLE `pay_project` (
  `id` varchar(40) NOT NULL COMMENT '编号',
  `organ_id` varchar(40) NOT NULL COMMENT '归属缴费机构',
  `name` varchar(100) NOT NULL COMMENT '缴费名称',
  `pay_single_money` double NOT NULL COMMENT '缴费单价金额',
  `amount` int(10) NOT NULL COMMENT '缴费数量（默认1）',
  `pay_total_money` double NOT NULL COMMENT '缴费总额',
  `pay_statues` varchar(20) DEFAULT NULL COMMENT '缴费状态（1正常/2结束）',
  `is_temporary_pro` varchar(20) NOT NULL COMMENT '是否临时缴费项目（1是/0否）',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '缴费开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '缴费结束时间',
  `pay_years` varchar(20) DEFAULT NULL COMMENT '缴费年度',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='缴费项目';

-- ----------------------------
-- Records of pay_project
-- ----------------------------
INSERT INTO `pay_project` VALUES ('31578ff3-800c-4f51-8763-f960ff4ce567', '108', '学杂费', '1', '1', '1', '1', '0', null, null, '2017', '测试');
INSERT INTO `pay_project` VALUES ('49F0ABC655144FDDA2B0DB5A156FE2A1', '108', '住宿费', '1', '1', '1', '1', '1', null, null, null, '无');

-- ----------------------------
-- Table structure for pay_secretkey_info
-- ----------------------------
DROP TABLE IF EXISTS `pay_secretkey_info`;
CREATE TABLE `pay_secretkey_info` (
  `id` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `business_id` varchar(40) COLLATE utf8_unicode_ci NOT NULL COMMENT '归属机构',
  `command` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `app` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '接入商标识',
  `operator_id` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '收银员的id，用于标识收款账户',
  `version` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '调用的接口版本，固定为：2.0',
  `redirect_url` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '支付成功之后的跳转页面',
  `app_key` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '商户对应的key',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='商户慧商通信息';

-- ----------------------------
-- Records of pay_secretkey_info
-- ----------------------------
INSERT INTO `pay_secretkey_info` VALUES ('1', '11112', 'caibao.pay.h5', 'h50008530000066', 'c777292c6becd2d7fd3f7d898e847d04', '1.0', 'http://www.baidu.com', 'fc471d2a8ec3670f7789e0dfcbb8dfb1');

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `blob_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `sched_name` varchar(120) NOT NULL,
  `calendar_name` varchar(200) NOT NULL,
  `calendar` blob NOT NULL,
  PRIMARY KEY (`sched_name`,`calendar_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `cron_expression` varchar(200) NOT NULL,
  `time_zone_id` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler', 'TASK_1', 'DEFAULT', '0/10 * * * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler', 'TASK_2', 'DEFAULT', '0/20 * * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `entry_id` varchar(95) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `fired_time` bigint(13) NOT NULL,
  `sched_time` bigint(13) NOT NULL,
  `priority` int(11) NOT NULL,
  `state` varchar(16) NOT NULL,
  `job_name` varchar(200) DEFAULT NULL,
  `job_group` varchar(200) DEFAULT NULL,
  `is_nonconcurrent` varchar(1) DEFAULT NULL,
  `requests_recovery` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `sched_name` varchar(120) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `job_class_name` varchar(250) NOT NULL,
  `is_durable` varchar(1) NOT NULL,
  `is_nonconcurrent` varchar(1) NOT NULL,
  `is_update_data` varchar(1) NOT NULL,
  `requests_recovery` varchar(1) NOT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler', 'TASK_1', 'DEFAULT', null, 'com.ruoyi.project.monitor.job.util.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720028636F6D2E72756F79692E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200074900067374617475734C000E63726F6E45787072657373696F6E7400124C6A6176612F6C616E672F537472696E673B4C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E000978720029636F6D2E72756F79692E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200064C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E078707070700000000174000E302F3130202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E697A0E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672795461736B74000A72794E6F506172616D737400007800);
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler', 'TASK_2', 'DEFAULT', null, 'com.ruoyi.project.monitor.job.util.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720028636F6D2E72756F79692E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200074900067374617475734C000E63726F6E45787072657373696F6E7400124C6A6176612F6C616E672F537472696E673B4C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E000978720029636F6D2E72756F79692E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200064C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E078707070700000000174000E302F3230202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E69C89E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000274000672795461736B7400087279506172616D7374000272797800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `sched_name` varchar(120) NOT NULL,
  `lock_name` varchar(40) NOT NULL,
  PRIMARY KEY (`sched_name`,`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RuoyiScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RuoyiScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `sched_name` varchar(120) NOT NULL,
  `instance_name` varchar(200) NOT NULL,
  `last_checkin_time` bigint(13) NOT NULL,
  `checkin_interval` bigint(13) NOT NULL,
  PRIMARY KEY (`sched_name`,`instance_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('RuoyiScheduler', 'CY-20190527LWFG1559533578681', '1559534678782', '15000');

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `repeat_count` bigint(7) NOT NULL,
  `repeat_interval` bigint(12) NOT NULL,
  `times_triggered` bigint(10) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `str_prop_1` varchar(512) DEFAULT NULL,
  `str_prop_2` varchar(512) DEFAULT NULL,
  `str_prop_3` varchar(512) DEFAULT NULL,
  `int_prop_1` int(11) DEFAULT NULL,
  `int_prop_2` int(11) DEFAULT NULL,
  `long_prop_1` bigint(20) DEFAULT NULL,
  `long_prop_2` bigint(20) DEFAULT NULL,
  `dec_prop_1` decimal(13,4) DEFAULT NULL,
  `dec_prop_2` decimal(13,4) DEFAULT NULL,
  `bool_prop_1` varchar(1) DEFAULT NULL,
  `bool_prop_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(200) NOT NULL,
  `trigger_group` varchar(200) NOT NULL,
  `job_name` varchar(200) NOT NULL,
  `job_group` varchar(200) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `next_fire_time` bigint(13) DEFAULT NULL,
  `prev_fire_time` bigint(13) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `trigger_state` varchar(16) NOT NULL,
  `trigger_type` varchar(8) NOT NULL,
  `start_time` bigint(13) NOT NULL,
  `end_time` bigint(13) DEFAULT NULL,
  `calendar_name` varchar(200) DEFAULT NULL,
  `misfire_instr` smallint(2) DEFAULT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', null, '1556373550000', '-1', '5', 'PAUSED', 'CRON', '1556373547000', '0', null, '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720028636F6D2E72756F79692E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200074900067374617475734C000E63726F6E45787072657373696F6E7400124C6A6176612F6C616E672F537472696E673B4C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E000978720029636F6D2E72756F79692E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200064C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E078707070700000000174000E302F3130202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E697A0E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000174000672795461736B74000A72794E6F506172616D737400007800);
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler', 'TASK_2', 'DEFAULT', 'TASK_2', 'DEFAULT', null, '1556373560000', '-1', '5', 'PAUSED', 'CRON', '1556373547000', '0', null, '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720028636F6D2E72756F79692E70726F6A6563742E6D6F6E69746F722E6A6F622E646F6D61696E2E4A6F6200000000000000010200074900067374617475734C000E63726F6E45787072657373696F6E7400124C6A6176612F6C616E672F537472696E673B4C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E000978720029636F6D2E72756F79692E6672616D65776F726B2E7765622E646F6D61696E2E42617365456E7469747900000000000000010200064C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001622CDE29E078707070700000000174000E302F3230202A202A202A202A203F740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E69C89E58F82EFBC897372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000274000672795461736B7400087279506172616D7374000272797800);

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(100) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='参数配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-default', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '默认 skin-default、蓝色 skin-blue、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES ('2', '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '初始化密码 123456');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` int(11) DEFAULT '0' COMMENT '父部门id',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT '' COMMENT '负责人',
  `phone` varchar(20) DEFAULT '' COMMENT '联系电话',
  `email` varchar(20) DEFAULT '' COMMENT '邮箱',
  `status` int(1) DEFAULT '0' COMMENT '部门状态:0正常,1停用',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11113 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('99', '0', '凡科睿简易支付平台', '0', '若依', '15888888888', 'ry@qq.com', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('100', '99', '广西工业职业技术学院', '0', '若依', '15888888888', 'ry@qq.com', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('101', '100', '南宁校区', '1', '若依', '15888888888', 'ry@qq.com', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('102', '100', '贵港校区', '2', '若依', '15888888888', 'ry@qq.com', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES ('106', '101', '计算机科学与技术学院', '1', '若依', '15888888888', 'ry@qq.com', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-05-31 10:11:57');
INSERT INTO `sys_dept` VALUES ('108', '102', '计算机学院', '1', '若依', '15888888888', 'ry@qq.com', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-05-31 10:13:15');
INSERT INTO `sys_dept` VALUES ('110', '101', '挖掘机技术哪家强', '20', '刘青国', '15875451212', '1212121@99.com', '0', 'admin', '2019-05-31 10:12:57', '', null);
INSERT INTO `sys_dept` VALUES ('11112', '99', '测试机构', '500', '小邓', '15077232323', '11645454@qq.com', '0', 'admin', '2019-05-31 16:27:43', '', null);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` int(1) DEFAULT '0' COMMENT '状态（0正常 1禁用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES ('1', '1', '工商银行', '01', 'sys_bank_code', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dict_data` VALUES ('2', '2', '建设银行', '02', 'sys_bank_code', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dict_data` VALUES ('3', '3', '农业银行', '03', 'sys_bank_code', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dict_data` VALUES ('4', '4', '光大银行', '04', 'sys_bank_code', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dict_data` VALUES ('5', '5', '兴业银行', '05', 'sys_bank_code', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dict_data` VALUES ('6', '6', '中国银行', '06', 'sys_bank_code', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dict_data` VALUES ('7', '7', '平安银行', '07', 'sys_bank_code', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dict_data` VALUES ('8', '8', '招商银行', '08', 'sys_bank_code', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dict_data` VALUES ('9', '1', '微信支付', 'WX', 'sys_pay_code', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dict_data` VALUES ('10', '2', '支付宝', 'ZFB', 'sys_pay_code', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dict_data` VALUES ('11', '3', 'QQ支付', 'JD', 'sys_pay_code', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_dict_data` VALUES ('12', '4', '京东支付', 'QQ', 'sys_pay_code', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` int(1) DEFAULT '0' COMMENT '状态（0正常 1禁用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('1', '银行列表', 'sys_bank_code', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '银行数据列表');
INSERT INTO `sys_dict_type` VALUES ('2', '支付通道', 'sys_pay_code', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '支付通道列表');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL DEFAULT '' COMMENT '任务组名',
  `method_name` varchar(500) DEFAULT '' COMMENT '任务方法',
  `params` varchar(200) DEFAULT '' COMMENT '方法参数',
  `cron_expression` varchar(255) DEFAULT '' COMMENT 'cron执行表达式',
  `status` int(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='定时任务调度表';

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES ('1', 'ryTask', '系统默认（无参）', 'ryNoParams', '', '0/10 * * * * ?', '1', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_job` VALUES ('2', 'ryTask', '系统默认（有参）', 'ryParams', 'ry', '0/20 * * * * ?', '1', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log` (
  `job_log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `method_name` varchar(500) DEFAULT NULL COMMENT '任务方法',
  `params` varchar(200) DEFAULT '' COMMENT '方法参数',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `is_exception` int(1) DEFAULT '0' COMMENT '是否异常',
  `exception_info` text COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务调度日志表';

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor` (
  `info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` int(1) DEFAULT '0' COMMENT '登录状态 0成功 1失败',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
INSERT INTO `sys_logininfor` VALUES ('100', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-04-27 22:01:42');
INSERT INTO `sys_logininfor` VALUES ('101', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-30 09:35:17');
INSERT INTO `sys_logininfor` VALUES ('102', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '退出成功', '2019-05-30 09:37:02');
INSERT INTO `sys_logininfor` VALUES ('103', 'ry', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '1', '密码输入错误1次，123456', '2019-05-30 09:37:11');
INSERT INTO `sys_logininfor` VALUES ('104', 'ry', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '1', '密码输入错误2次，123456', '2019-05-30 09:37:17');
INSERT INTO `sys_logininfor` VALUES ('105', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-30 09:37:30');
INSERT INTO `sys_logininfor` VALUES ('106', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '退出成功', '2019-05-30 09:44:53');
INSERT INTO `sys_logininfor` VALUES ('107', 'ry', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-30 09:45:03');
INSERT INTO `sys_logininfor` VALUES ('108', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-30 09:47:47');
INSERT INTO `sys_logininfor` VALUES ('109', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-30 10:01:03');
INSERT INTO `sys_logininfor` VALUES ('110', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-30 16:23:47');
INSERT INTO `sys_logininfor` VALUES ('111', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 09:21:46');
INSERT INTO `sys_logininfor` VALUES ('112', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 09:52:34');
INSERT INTO `sys_logininfor` VALUES ('113', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 10:47:31');
INSERT INTO `sys_logininfor` VALUES ('114', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 14:18:33');
INSERT INTO `sys_logininfor` VALUES ('115', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 14:27:20');
INSERT INTO `sys_logininfor` VALUES ('116', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 14:47:16');
INSERT INTO `sys_logininfor` VALUES ('117', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 15:13:49');
INSERT INTO `sys_logininfor` VALUES ('118', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 15:18:38');
INSERT INTO `sys_logininfor` VALUES ('119', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 15:25:39');
INSERT INTO `sys_logininfor` VALUES ('120', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 15:41:44');
INSERT INTO `sys_logininfor` VALUES ('121', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 15:45:25');
INSERT INTO `sys_logininfor` VALUES ('122', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 15:48:51');
INSERT INTO `sys_logininfor` VALUES ('123', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 15:50:15');
INSERT INTO `sys_logininfor` VALUES ('124', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 15:55:49');
INSERT INTO `sys_logininfor` VALUES ('125', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 16:02:31');
INSERT INTO `sys_logininfor` VALUES ('126', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 16:06:38');
INSERT INTO `sys_logininfor` VALUES ('127', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 16:08:01');
INSERT INTO `sys_logininfor` VALUES ('128', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '退出成功', '2019-05-31 16:09:16');
INSERT INTO `sys_logininfor` VALUES ('129', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 16:09:19');
INSERT INTO `sys_logininfor` VALUES ('130', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 16:09:45');
INSERT INTO `sys_logininfor` VALUES ('131', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 16:19:40');
INSERT INTO `sys_logininfor` VALUES ('132', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 16:38:01');
INSERT INTO `sys_logininfor` VALUES ('133', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 17:25:13');
INSERT INTO `sys_logininfor` VALUES ('134', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 17:29:01');
INSERT INTO `sys_logininfor` VALUES ('135', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-05-31 17:30:59');
INSERT INTO `sys_logininfor` VALUES ('136', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 09:04:09');
INSERT INTO `sys_logininfor` VALUES ('137', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 09:11:27');
INSERT INTO `sys_logininfor` VALUES ('138', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 09:16:11');
INSERT INTO `sys_logininfor` VALUES ('139', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '1', '验证码错误', '2019-06-03 09:28:14');
INSERT INTO `sys_logininfor` VALUES ('140', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 09:28:17');
INSERT INTO `sys_logininfor` VALUES ('141', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 09:29:05');
INSERT INTO `sys_logininfor` VALUES ('142', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '退出成功', '2019-06-03 09:30:01');
INSERT INTO `sys_logininfor` VALUES ('143', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 09:30:04');
INSERT INTO `sys_logininfor` VALUES ('144', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 09:30:23');
INSERT INTO `sys_logininfor` VALUES ('145', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 09:47:20');
INSERT INTO `sys_logininfor` VALUES ('146', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 10:15:17');
INSERT INTO `sys_logininfor` VALUES ('147', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 11:06:02');
INSERT INTO `sys_logininfor` VALUES ('148', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 11:19:37');
INSERT INTO `sys_logininfor` VALUES ('149', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 11:20:35');
INSERT INTO `sys_logininfor` VALUES ('150', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 11:38:18');
INSERT INTO `sys_logininfor` VALUES ('151', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 11:46:35');
INSERT INTO `sys_logininfor` VALUES ('152', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 14:42:13');
INSERT INTO `sys_logininfor` VALUES ('153', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 14:48:40');
INSERT INTO `sys_logininfor` VALUES ('154', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 14:58:48');
INSERT INTO `sys_logininfor` VALUES ('155', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 14:59:08');
INSERT INTO `sys_logininfor` VALUES ('156', 'admin', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', '0', '登录成功', '2019-06-03 15:16:22');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT NULL COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '' COMMENT '请求地址',
  `menu_type` char(1) DEFAULT '' COMMENT '类型:M目录,C菜单,F按钮',
  `visible` int(1) DEFAULT '0' COMMENT '菜单状态:0显示,1隐藏',
  `perms` varchar(100) DEFAULT '' COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', '1', '#', 'M', '0', '', 'fa fa-gear', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统管理目录');
INSERT INTO `sys_menu` VALUES ('2', '系统监控', '0', '2', '#', 'M', '0', '', 'fa fa-video-camera', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统监控目录');
INSERT INTO `sys_menu` VALUES ('3', '缴费管理', '0', '3', '#', 'M', '0', '', 'fa fa-bars', 'admin', '2018-03-16 11:33:00', 'admin', '2019-05-31 14:32:53', '系统工具目录');
INSERT INTO `sys_menu` VALUES ('4', '用户管理', '1', '1', '/system/user', 'C', '0', 'system:user:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户管理菜单');
INSERT INTO `sys_menu` VALUES ('5', '角色管理', '1', '2', '/system/role', 'C', '0', 'system:role:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '角色管理菜单');
INSERT INTO `sys_menu` VALUES ('6', '菜单管理', '1', '3', '/system/menu', 'C', '0', 'system:menu:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单管理菜单');
INSERT INTO `sys_menu` VALUES ('7', '部门管理', '1', '4', '/system/dept', 'C', '0', 'system:dept:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '部门管理菜单');
INSERT INTO `sys_menu` VALUES ('8', '岗位管理', '1', '5', '/system/post', 'C', '0', 'system:post:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '岗位管理菜单');
INSERT INTO `sys_menu` VALUES ('9', '字典管理', '1', '6', '/system/dict', 'C', '0', 'system:dict:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '字典管理菜单');
INSERT INTO `sys_menu` VALUES ('10', '参数设置', '1', '7', '/system/config', 'C', '0', 'system:config:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '参数设置菜单');
INSERT INTO `sys_menu` VALUES ('11', '操作日志', '2', '1', '/monitor/operlog', 'C', '0', 'monitor:operlog:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作日志菜单');
INSERT INTO `sys_menu` VALUES ('12', '登录日志', '2', '2', '/monitor/logininfor', 'C', '0', 'monitor:logininfor:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录日志菜单');
INSERT INTO `sys_menu` VALUES ('13', '在线用户', '2', '3', '/monitor/online', 'C', '0', 'monitor:online:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '在线用户菜单');
INSERT INTO `sys_menu` VALUES ('14', '定时任务', '2', '4', '/monitor/job', 'C', '0', 'monitor:job:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '定时任务菜单');
INSERT INTO `sys_menu` VALUES ('15', '数据监控', '2', '5', '/monitor/data', 'C', '0', 'monitor:data:view', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '数据监控菜单');
INSERT INTO `sys_menu` VALUES ('16', '表单构建', '111', '1', '/tool/build', 'C', '0', 'tool:build:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2019-05-31 14:31:49', '表单构建菜单');
INSERT INTO `sys_menu` VALUES ('17', '代码生成', '111', '2', '/tool/gen', 'C', '0', 'tool:gen:view', '#', 'admin', '2018-03-16 11:33:00', 'admin', '2019-05-31 14:31:35', '代码生成菜单');
INSERT INTO `sys_menu` VALUES ('18', '用户查询', '4', '1', '#', 'F', '0', 'system:user:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('19', '用户新增', '4', '2', '#', 'F', '0', 'system:user:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('20', '用户修改', '4', '3', '#', 'F', '0', 'system:user:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('21', '用户删除', '4', '4', '#', 'F', '0', 'system:user:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('22', '用户保存', '4', '5', '#', 'F', '0', 'system:user:save', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('23', '批量删除', '4', '6', '#', 'F', '0', 'system:user:batchRemove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('24', '重置密码', '4', '7', '#', 'F', '0', 'system:user:resetPwd', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('25', '角色查询', '5', '1', '#', 'F', '0', 'system:role:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('26', '角色新增', '5', '2', '#', 'F', '0', 'system:role:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('27', '角色修改', '5', '3', '#', 'F', '0', 'system:role:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('28', '角色删除', '5', '4', '#', 'F', '0', 'system:role:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('29', '角色保存', '5', '5', '#', 'F', '0', 'system:role:save', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('30', '批量删除', '5', '6', '#', 'F', '0', 'system:role:batchRemove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('31', '菜单查询', '6', '1', '#', 'F', '0', 'system:menu:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('32', '菜单新增', '6', '2', '#', 'F', '0', 'system:menu:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('33', '菜单修改', '6', '3', '#', 'F', '0', 'system:menu:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('34', '菜单删除', '6', '4', '#', 'F', '0', 'system:menu:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('35', '菜单保存', '6', '5', '#', 'F', '0', 'system:menu:save', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('36', '部门查询', '7', '1', '#', 'F', '0', 'system:dept:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('37', '部门新增', '7', '2', '#', 'F', '0', 'system:dept:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('38', '部门修改', '7', '3', '#', 'F', '0', 'system:dept:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('39', '部门删除', '7', '4', '#', 'F', '0', 'system:dept:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('40', '部门保存', '7', '5', '#', 'F', '0', 'system:dept:save', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('41', '岗位查询', '8', '1', '#', 'F', '0', 'system:post:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('42', '岗位新增', '8', '2', '#', 'F', '0', 'system:post:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('43', '岗位修改', '8', '3', '#', 'F', '0', 'system:post:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('44', '岗位删除', '8', '4', '#', 'F', '0', 'system:post:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('45', '岗位保存', '8', '5', '#', 'F', '0', 'system:post:save', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('46', '批量删除', '8', '6', '#', 'F', '0', 'system:post:batchRemove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('47', '字典查询', '9', '1', '#', 'F', '0', 'system:dict:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('48', '字典新增', '9', '2', '#', 'F', '0', 'system:dict:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('49', '字典修改', '9', '3', '#', 'F', '0', 'system:dict:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('50', '字典删除', '9', '4', '#', 'F', '0', 'system:dict:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('51', '字典保存', '9', '5', '#', 'F', '0', 'system:dict:save', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('52', '批量删除', '9', '6', '#', 'F', '0', 'system:dict:batchRemove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('53', '参数查询', '10', '1', '#', 'F', '0', 'system:config:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('54', '参数新增', '10', '2', '#', 'F', '0', 'system:config:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('55', '参数修改', '10', '3', '#', 'F', '0', 'system:config:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('56', '参数删除', '10', '4', '#', 'F', '0', 'system:config:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('57', '参数保存', '10', '5', '#', 'F', '0', 'system:config:save', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('58', '批量删除', '10', '6', '#', 'F', '0', 'system:config:batchRemove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('59', '操作查询', '11', '1', '#', 'F', '0', 'monitor:operlog:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('60', '批量删除', '11', '2', '#', 'F', '0', 'monitor:operlog:batchRemove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('61', '详细信息', '11', '3', '#', 'F', '0', 'monitor:operlog:detail', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('62', '登录查询', '12', '1', '#', 'F', '0', 'monitor:logininfor:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('63', '批量删除', '12', '2', '#', 'F', '0', 'monitor:logininfor:batchRemove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('64', '在线查询', '13', '1', '#', 'F', '0', 'monitor:online:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('65', '批量强退', '13', '2', '#', 'F', '0', 'monitor:online:batchForceLogout', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('66', '单条强退', '13', '3', '#', 'F', '0', 'monitor:online:forceLogout', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('67', '任务查询', '14', '1', '#', 'F', '0', 'monitor:job:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('68', '任务新增', '14', '2', '#', 'F', '0', 'monitor:job:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('69', '任务修改', '14', '3', '#', 'F', '0', 'monitor:job:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('70', '任务删除', '14', '4', '#', 'F', '0', 'monitor:job:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('71', '任务保存', '14', '5', '#', 'F', '0', 'monitor:job:save', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('72', '状态修改', '14', '6', '#', 'F', '0', 'monitor:job:changeStatus', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('73', '批量删除', '14', '7', '#', 'F', '0', 'monitor:job:batchRemove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('74', '生成查询', '16', '1', '#', 'F', '0', 'tool:gen:list', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('75', '生成代码', '16', '2', '#', 'F', '0', 'tool:gen:code', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES ('76', '缴费流水', '3', '40', '/pay/infoDetail', 'C', '0', 'pay:infoDetail:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2019-06-03 11:41:28', '缴费流水菜单');
INSERT INTO `sys_menu` VALUES ('77', '缴费流水查询', '76', '1', '#', 'F', '0', 'pay:infoDetail:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('78', '缴费流水新增', '76', '2', '#', 'F', '0', 'pay:infoDetail:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('79', '缴费流水修改', '76', '3', '#', 'F', '0', 'pay:infoDetail:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('80', '缴费流水删除', '76', '4', '#', 'F', '0', 'pay:infoDetail:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('81', '缴费流水保存', '76', '5', '#', 'F', '0', 'pay:infoDetail:save', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('82', '批量删除', '76', '6', '#', 'F', '0', 'pay:infoDetail:batchRemove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('83', '缴费数据', '3', '30', '/pay/info', 'C', '0', 'pay:info:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2019-06-03 11:41:12', '缴费数据菜单');
INSERT INTO `sys_menu` VALUES ('84', '缴费数据查询', '83', '1', '#', 'F', '0', 'pay:info:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('85', '缴费数据新增', '83', '2', '#', 'F', '0', 'pay:info:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('86', '缴费数据修改', '83', '3', '#', 'F', '0', 'pay:info:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('87', '缴费数据删除', '83', '4', '#', 'F', '0', 'pay:info:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('88', '缴费数据保存', '83', '5', '#', 'F', '0', 'pay:info:save', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('89', '批量删除', '83', '6', '#', 'F', '0', 'pay:info:batchRemove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('90', '缴费人员', '3', '1', '/pay/personnel', 'C', '0', 'pay:personnel:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '缴费人员菜单');
INSERT INTO `sys_menu` VALUES ('91', '缴费人员查询', '90', '1', '#', 'F', '0', 'pay:personnel:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('92', '缴费人员新增', '90', '2', '#', 'F', '0', 'pay:personnel:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('93', '缴费人员修改', '90', '3', '#', 'F', '0', 'pay:personnel:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('94', '缴费人员删除', '90', '4', '#', 'F', '0', 'pay:personnel:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('95', '缴费人员保存', '90', '5', '#', 'F', '0', 'pay:personnel:save', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('96', '批量删除', '90', '6', '#', 'F', '0', 'pay:personnel:batchRemove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('97', '缴费项目', '3', '20', '/pay/project', 'C', '0', 'pay:project:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2019-06-03 11:40:57', '缴费项目菜单');
INSERT INTO `sys_menu` VALUES ('98', '缴费项目查询', '97', '1', '#', 'F', '0', 'pay:project:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('99', '缴费项目新增', '97', '2', '#', 'F', '0', 'pay:project:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('100', '缴费项目修改', '97', '3', '#', 'F', '0', 'pay:project:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('101', '缴费项目删除', '97', '4', '#', 'F', '0', 'pay:project:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('102', '缴费项目保存', '97', '5', '#', 'F', '0', 'pay:project:save', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('103', '批量删除', '97', '6', '#', 'F', '0', 'pay:project:batchRemove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('104', '商户慧商通', '3', '50', '/pay/secretkeyInfo', 'C', '0', 'pay:secretkeyInfo:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2019-06-03 11:41:44', '商户慧商通菜单');
INSERT INTO `sys_menu` VALUES ('105', '商户慧商通查询', '104', '1', '#', 'F', '0', 'pay:secretkeyInfo:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('106', '商户慧商通新增', '104', '2', '#', 'F', '0', 'pay:secretkeyInfo:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('107', '商户慧商通修改', '104', '3', '#', 'F', '0', 'pay:secretkeyInfo:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('108', '商户慧商通删除', '104', '4', '#', 'F', '0', 'pay:secretkeyInfo:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('109', '商户慧商通保存', '104', '5', '#', 'F', '0', 'pay:secretkeyInfo:save', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('110', '批量删除', '104', '6', '#', 'F', '0', 'pay:secretkeyInfo:batchRemove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES ('111', '系统工具', '0', '10', '', 'M', '0', '', 'fa fa-wrench', 'admin', '2019-05-31 14:31:17', 'admin', '2019-05-31 14:33:00', '');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
  `oper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `action` varchar(100) DEFAULT '' COMMENT '功能请求',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `channel` varchar(20) DEFAULT '' COMMENT '来源渠道',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(30) DEFAULT '' COMMENT '主机地址',
  `oper_param` varchar(255) DEFAULT '' COMMENT '请求参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态 0正常 1异常',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES ('100', '系统管理', '用户管理-新增用户', 'com.ruoyi.project.system.user.controller.UserController.add()', 'web', 'admin', '研发一部', '/system/user/add', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-04-27 22:01:59');
INSERT INTO `sys_oper_log` VALUES ('101', '系统管理', '字典管理-修改字典类型', 'com.ruoyi.project.system.dict.controller.DictTypeController.edit()', 'web', 'admin', '研发一部', '/system/dict/edit/1', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-04-27 22:02:13');
INSERT INTO `sys_oper_log` VALUES ('102', '系统管理', '字典管理-查询字典数据', 'com.ruoyi.project.system.dict.controller.DictTypeController.detail()', 'web', 'admin', '研发一部', '/system/dict/detail/1', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-04-27 22:02:17');
INSERT INTO `sys_oper_log` VALUES ('103', '系统管理', '字典管理-新增字典数据', 'com.ruoyi.project.system.dict.controller.DictDataController.add()', 'web', 'admin', '研发一部', '/system/dict/data/add/sys_bank_code', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-04-27 22:02:22');
INSERT INTO `sys_oper_log` VALUES ('104', '系统管理', '参数配置-修改参数', 'com.ruoyi.project.system.config.controller.ConfigController.edit()', 'web', 'admin', '研发一部', '/system/config/edit/2', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-04-27 22:03:00');
INSERT INTO `sys_oper_log` VALUES ('105', '系统管理', '个人信息-修改用户', 'com.ruoyi.project.system.user.controller.ProfileController.edit()', 'web', 'admin', '研发一部', '/system/user/profile/edit/1', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-04-27 22:04:28');
INSERT INTO `sys_oper_log` VALUES ('106', '系统管理', '个人信息-保存用户', 'com.ruoyi.project.system.user.controller.ProfileController.update()', 'web', 'admin', '研发一部', '/system/user/profile/update', '0:0:0:0:0:0:0:1', '{\"userId\":[\"1\"],\"userName\":[\"若依\"],\"email\":[\"ry@163.com\"],\"phonenumber\":[\"15888888888\"],\"sex\":[\"0\"]}', '0', null, '2019-04-27 22:04:33');
INSERT INTO `sys_oper_log` VALUES ('107', '系统管理', '字典管理-查询字典数据', 'com.ruoyi.project.system.dict.controller.DictTypeController.detail()', 'web', 'admin', '研发一部', '/system/dict/detail/1', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-30 09:36:00');
INSERT INTO `sys_oper_log` VALUES ('108', '系统管理', '角色管理-修改角色', 'com.ruoyi.project.system.role.controller.RoleController.edit()', 'web', 'admin', '研发一部', '/system/role/edit/2', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-30 09:36:23');
INSERT INTO `sys_oper_log` VALUES ('109', '系统管理', '用户管理-修改用户', 'com.ruoyi.project.system.user.controller.UserController.edit()', 'web', 'admin', '研发一部', '/system/user/edit/2', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-30 09:36:52');
INSERT INTO `sys_oper_log` VALUES ('110', '系统管理', '用户管理-保存用户', 'com.ruoyi.project.system.user.controller.UserController.save()', 'web', 'admin', '研发一部', '/system/user/save', '0:0:0:0:0:0:0:1', '{\"userId\":[\"2\"],\"deptId\":[\"108\"],\"userName\":[\"若依\"],\"email\":[\"ry@qq.com\"],\"phonenumber\":[\"15666666666\"],\"sex\":[\"1\"],\"status\":[\"0\"],\"roleIds\":[\"2\"],\"postIds\":[\"2\"]}', '0', null, '2019-05-30 09:36:59');
INSERT INTO `sys_oper_log` VALUES ('111', '系统管理', '部门管理-新增部门', 'com.ruoyi.project.system.dept.controller.DeptController.add()', 'web', 'admin', '研发一部', '/system/dept/add/100', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-30 09:38:46');
INSERT INTO `sys_oper_log` VALUES ('112', '系统管理', '部门管理-修改部门', 'com.ruoyi.project.system.dept.controller.DeptController.edit()', 'web', 'admin', '研发一部', '/system/dept/edit/109', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-30 09:39:17');
INSERT INTO `sys_oper_log` VALUES ('113', '系统管理', '用户管理-修改用户', 'com.ruoyi.project.system.user.controller.UserController.edit()', 'web', 'admin', '研发一部', '/system/user/edit/2', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-30 09:44:16');
INSERT INTO `sys_oper_log` VALUES ('114', '系统管理', '用户管理-保存用户', 'com.ruoyi.project.system.user.controller.UserController.save()', 'web', 'admin', '研发一部', '/system/user/save', '0:0:0:0:0:0:0:1', '{\"userId\":[\"2\"],\"deptId\":[\"108\"],\"userName\":[\"若依\"],\"email\":[\"ry@qq.com\"],\"phonenumber\":[\"15666666666\"],\"sex\":[\"1\"],\"status\":[\"0\"],\"roleIds\":[\"1\"],\"postIds\":[\"2\"]}', '0', null, '2019-05-30 09:44:24');
INSERT INTO `sys_oper_log` VALUES ('115', '系统管理', '用户管理-重置密码', 'com.ruoyi.project.system.user.controller.UserController.resetPwd()', 'web', 'admin', '研发一部', '/system/user/resetPwd/2', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-30 09:44:27');
INSERT INTO `sys_oper_log` VALUES ('116', '系统管理', '用户管理-重置密码', 'com.ruoyi.project.system.user.controller.UserController.resetPwd()', 'web', 'admin', '研发一部', '/system/user/resetPwd', '0:0:0:0:0:0:0:1', '{\"userId\":[\"2\"],\"loginName\":[\"ry\"],\"password\":[\"123456\"]}', '0', null, '2019-05-30 09:44:35');
INSERT INTO `sys_oper_log` VALUES ('117', '系统管理', '角色管理-修改角色', 'com.ruoyi.project.system.role.controller.RoleController.edit()', 'web', 'admin', '研发一部', '/system/role/edit/2', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-30 09:44:43');
INSERT INTO `sys_oper_log` VALUES ('118', '系统管理', '角色管理-保存角色', 'com.ruoyi.project.system.role.controller.RoleController.save()', 'web', 'admin', '研发一部', '/system/role/save', '0:0:0:0:0:0:0:1', '{\"roleId\":[\"2\"],\"roleName\":[\"普通角色\"],\"roleKey\":[\"common\"],\"roleSort\":[\"2\"],\"status\":[\"0\"],\"remark\":[\"普通角色\"],\"menuIds\":[\"1,4,18,19,20,21,22,23,24,5,25,26,27,28,29,30,6,31,32,33,34,35,7,36,37,38,39,40,8,41,42,43,44,45,46,9,47,48,49,50,51,52,10,53,54,55,56,57', '0', null, '2019-05-30 09:44:48');
INSERT INTO `sys_oper_log` VALUES ('119', '系统工具', '代码生成-生成代码', 'com.ruoyi.project.tool.gen.controller.GenController.genCode()', 'web', 'admin', '研发一部', '/tool/gen/genCode/db_test_table', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-30 10:01:11');
INSERT INTO `sys_oper_log` VALUES ('120', '系统管理', '个人信息-修改用户', 'com.ruoyi.project.system.user.controller.ProfileController.edit()', 'web', 'admin', '研发一部', '/system/user/profile/edit/1', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-30 16:27:47');
INSERT INTO `sys_oper_log` VALUES ('121', '系统管理', '部门管理-新增部门', 'com.ruoyi.project.system.dept.controller.DeptController.add()', 'web', 'admin', '研发一部', '/system/dept/add/100', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 09:28:12');
INSERT INTO `sys_oper_log` VALUES ('122', '系统管理', '用户管理-新增用户', 'com.ruoyi.project.system.user.controller.UserController.add()', 'web', 'admin', '研发一部', '/system/user/add', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 09:28:41');
INSERT INTO `sys_oper_log` VALUES ('123', '系统管理', '部门管理-新增部门', 'com.ruoyi.project.system.dept.controller.DeptController.add()', 'web', 'admin', '研发一部', '/system/dept/add/100', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 09:55:15');
INSERT INTO `sys_oper_log` VALUES ('124', '系统管理', '岗位管理-新增岗位', 'com.ruoyi.project.system.post.controller.PostController.add()', 'web', 'admin', '研发一部', '/system/post/add', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 09:56:13');
INSERT INTO `sys_oper_log` VALUES ('125', '系统管理', '部门管理-删除部门', 'com.ruoyi.project.system.dept.controller.DeptController.remove()', 'web', 'admin', '研发一部', '/system/dept/remove/103', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 09:57:56');
INSERT INTO `sys_oper_log` VALUES ('126', '系统管理', '部门管理-删除部门', 'com.ruoyi.project.system.dept.controller.DeptController.remove()', 'web', 'admin', '研发一部', '/system/dept/remove/104', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 09:57:58');
INSERT INTO `sys_oper_log` VALUES ('127', '系统管理', '部门管理-删除部门', 'com.ruoyi.project.system.dept.controller.DeptController.remove()', 'web', 'admin', '研发一部', '/system/dept/remove/105', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 09:58:01');
INSERT INTO `sys_oper_log` VALUES ('128', '系统管理', '部门管理-删除部门', 'com.ruoyi.project.system.dept.controller.DeptController.remove()', 'web', 'admin', '研发一部', '/system/dept/remove/109', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 09:58:06');
INSERT INTO `sys_oper_log` VALUES ('129', '系统管理', '部门管理-删除部门', 'com.ruoyi.project.system.dept.controller.DeptController.remove()', 'web', 'admin', '研发一部', '/system/dept/remove/107', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 09:59:35');
INSERT INTO `sys_oper_log` VALUES ('130', '系统管理', '部门管理-修改部门', 'com.ruoyi.project.system.dept.controller.DeptController.edit()', 'web', 'admin', '研发一部', '/system/dept/edit/106', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 10:10:29');
INSERT INTO `sys_oper_log` VALUES ('131', '系统管理', '部门管理-保存部门', 'com.ruoyi.project.system.dept.controller.DeptController.save()', 'web', 'admin', '研发一部', '/system/dept/save', '0:0:0:0:0:0:0:1', '{\"deptId\":[\"106\"],\"parentId\":[\"101\"],\"deptName\":[\"食品加工技术\"],\"orderNum\":[\"1\"],\"leader\":[\"若依\"],\"phone\":[\"15888888888\"],\"email\":[\"ry@qq.com\"],\"status\":[\"0\"]}', '0', null, '2019-05-31 10:10:36');
INSERT INTO `sys_oper_log` VALUES ('132', '系统管理', '部门管理-修改部门', 'com.ruoyi.project.system.dept.controller.DeptController.edit()', 'web', 'admin', '研发一部', '/system/dept/edit/106', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 10:11:46');
INSERT INTO `sys_oper_log` VALUES ('133', '系统管理', '部门管理-保存部门', 'com.ruoyi.project.system.dept.controller.DeptController.save()', 'web', 'admin', '研发一部', '/system/dept/save', '0:0:0:0:0:0:0:1', '{\"deptId\":[\"106\"],\"parentId\":[\"101\"],\"deptName\":[\"计算机科学与技术学院\"],\"orderNum\":[\"1\"],\"leader\":[\"若依\"],\"phone\":[\"15888888888\"],\"email\":[\"ry@qq.com\"],\"status\":[\"0\"]}', '0', null, '2019-05-31 10:11:57');
INSERT INTO `sys_oper_log` VALUES ('134', '系统管理', '部门管理-新增部门', 'com.ruoyi.project.system.dept.controller.DeptController.add()', 'web', 'admin', '研发一部', '/system/dept/add/101', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 10:12:13');
INSERT INTO `sys_oper_log` VALUES ('135', '系统管理', '部门管理-保存部门', 'com.ruoyi.project.system.dept.controller.DeptController.save()', 'web', 'admin', '研发一部', '/system/dept/save', '0:0:0:0:0:0:0:1', '{\"parentId\":[\"101\"],\"deptName\":[\"挖掘机技术哪家强\"],\"orderNum\":[\"20\"],\"leader\":[\"刘青国\"],\"phone\":[\"15875451212\"],\"email\":[\"1212121@99.com\"],\"status\":[\"0\"]}', '0', null, '2019-05-31 10:12:57');
INSERT INTO `sys_oper_log` VALUES ('136', '系统管理', '部门管理-修改部门', 'com.ruoyi.project.system.dept.controller.DeptController.edit()', 'web', 'admin', '研发一部', '/system/dept/edit/108', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 10:13:04');
INSERT INTO `sys_oper_log` VALUES ('137', '系统管理', '部门管理-保存部门', 'com.ruoyi.project.system.dept.controller.DeptController.save()', 'web', 'admin', '研发一部', '/system/dept/save', '0:0:0:0:0:0:0:1', '{\"deptId\":[\"108\"],\"parentId\":[\"102\"],\"deptName\":[\"计算机学院\"],\"orderNum\":[\"1\"],\"leader\":[\"若依\"],\"phone\":[\"15888888888\"],\"email\":[\"ry@qq.com\"],\"status\":[\"0\"]}', '0', null, '2019-05-31 10:13:15');
INSERT INTO `sys_oper_log` VALUES ('138', '系统工具', '代码生成-批量生成代码', 'com.ruoyi.project.tool.gen.controller.GenController.batchGenCode()', 'web', 'admin', '计算机科学与技术学院', '/tool/gen/batchGenCode', '0:0:0:0:0:0:0:1', '{\"tables\":[\"[\\\"pay_secretkey_info\\\",\\\"pay_project\\\",\\\"pay_personnel\\\",\\\"pay_info_detail\\\",\\\"pay_info\\\"]\"]}', '0', null, '2019-05-31 14:21:07');
INSERT INTO `sys_oper_log` VALUES ('139', '系统管理', '菜单管理-修改菜单', 'com.ruoyi.project.system.menu.controller.MenuController.edit()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/edit/76', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 14:30:19');
INSERT INTO `sys_oper_log` VALUES ('140', '系统管理', '菜单管理-新增菜单', 'com.ruoyi.project.system.menu.controller.MenuController.add()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/add/0', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 14:30:30');
INSERT INTO `sys_oper_log` VALUES ('141', '系统管理', '菜单管理-修改菜单', 'com.ruoyi.project.system.menu.controller.MenuController.edit()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/edit/3', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 14:30:41');
INSERT INTO `sys_oper_log` VALUES ('142', '系统管理', '菜单管理-新增菜单', 'com.ruoyi.project.system.menu.controller.MenuController.add()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/add/0', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 14:30:53');
INSERT INTO `sys_oper_log` VALUES ('143', '系统管理', '菜单管理-保存菜单', 'com.ruoyi.project.system.menu.controller.MenuController.save()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/save', '0:0:0:0:0:0:0:1', '{\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"测试\"],\"url\":[\"\"],\"perms\":[\"\"],\"orderNum\":[\"10\"],\"icon\":[\"fa fa-database\"],\"visible\":[\"0\"]}', '0', null, '2019-05-31 14:31:17');
INSERT INTO `sys_oper_log` VALUES ('144', '系统管理', '菜单管理-修改菜单', 'com.ruoyi.project.system.menu.controller.MenuController.edit()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/edit/17', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 14:31:25');
INSERT INTO `sys_oper_log` VALUES ('145', '系统管理', '菜单管理-保存菜单', 'com.ruoyi.project.system.menu.controller.MenuController.save()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/save', '0:0:0:0:0:0:0:1', '{\"menuId\":[\"17\"],\"parentId\":[\"111\"],\"menuType\":[\"C\"],\"menuName\":[\"代码生成\"],\"url\":[\"/tool/gen\"],\"perms\":[\"tool:gen:view\"],\"orderNum\":[\"2\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2019-05-31 14:31:35');
INSERT INTO `sys_oper_log` VALUES ('146', '系统管理', '菜单管理-修改菜单', 'com.ruoyi.project.system.menu.controller.MenuController.edit()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/edit/16', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 14:31:44');
INSERT INTO `sys_oper_log` VALUES ('147', '系统管理', '菜单管理-保存菜单', 'com.ruoyi.project.system.menu.controller.MenuController.save()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/save', '0:0:0:0:0:0:0:1', '{\"menuId\":[\"16\"],\"parentId\":[\"111\"],\"menuType\":[\"C\"],\"menuName\":[\"表单构建\"],\"url\":[\"/tool/build\"],\"perms\":[\"tool:build:view\"],\"orderNum\":[\"1\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2019-05-31 14:31:49');
INSERT INTO `sys_oper_log` VALUES ('148', '系统管理', '菜单管理-修改菜单', 'com.ruoyi.project.system.menu.controller.MenuController.edit()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/edit/111', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 14:31:57');
INSERT INTO `sys_oper_log` VALUES ('149', '系统管理', '菜单管理-保存菜单', 'com.ruoyi.project.system.menu.controller.MenuController.save()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/save', '0:0:0:0:0:0:0:1', '{\"menuId\":[\"111\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"系统工具1\"],\"url\":[\"\"],\"perms\":[\"\"],\"orderNum\":[\"10\"],\"icon\":[\"fa fa-wrench\"],\"visible\":[\"0\"]}', '0', null, '2019-05-31 14:32:34');
INSERT INTO `sys_oper_log` VALUES ('150', '系统管理', '菜单管理-修改菜单', 'com.ruoyi.project.system.menu.controller.MenuController.edit()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/edit/3', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 14:32:40');
INSERT INTO `sys_oper_log` VALUES ('151', '系统管理', '菜单管理-保存菜单', 'com.ruoyi.project.system.menu.controller.MenuController.save()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/save', '0:0:0:0:0:0:0:1', '{\"menuId\":[\"3\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"缴费管理\"],\"url\":[\"#\"],\"perms\":[\"\"],\"orderNum\":[\"3\"],\"icon\":[\"fa fa-bars\"],\"visible\":[\"0\"]}', '0', null, '2019-05-31 14:32:53');
INSERT INTO `sys_oper_log` VALUES ('152', '系统管理', '菜单管理-修改菜单', 'com.ruoyi.project.system.menu.controller.MenuController.edit()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/edit/111', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 14:32:57');
INSERT INTO `sys_oper_log` VALUES ('153', '系统管理', '菜单管理-保存菜单', 'com.ruoyi.project.system.menu.controller.MenuController.save()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/save', '0:0:0:0:0:0:0:1', '{\"menuId\":[\"111\"],\"parentId\":[\"0\"],\"menuType\":[\"M\"],\"menuName\":[\"系统工具\"],\"url\":[\"\"],\"perms\":[\"\"],\"orderNum\":[\"10\"],\"icon\":[\"fa fa-wrench\"],\"visible\":[\"0\"]}', '0', null, '2019-05-31 14:33:00');
INSERT INTO `sys_oper_log` VALUES ('154', '系统管理', '角色管理-修改角色', 'com.ruoyi.project.system.role.controller.RoleController.edit()', 'web', 'admin', '计算机科学与技术学院', '/system/role/edit/1', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 14:33:13');
INSERT INTO `sys_oper_log` VALUES ('155', '系统管理', '角色管理-保存角色', 'com.ruoyi.project.system.role.controller.RoleController.save()', 'web', 'admin', '计算机科学与技术学院', '/system/role/save', '0:0:0:0:0:0:0:1', '{\"roleId\":[\"1\"],\"roleName\":[\"管理员\"],\"roleKey\":[\"admin\"],\"roleSort\":[\"1\"],\"status\":[\"0\"],\"remark\":[\"管理员\"],\"menuIds\":[\"1,4,18,19,20,21,22,23,24,5,25,26,27,28,29,30,6,31,32,33,34,35,7,36,37,38,39,40,8,41,42,43,44,45,46,9,47,48,49,50,51,52,10,53,54,55,56,57,58', '0', null, '2019-05-31 14:33:18');
INSERT INTO `sys_oper_log` VALUES ('156', '系统管理', '角色管理-修改角色', 'com.ruoyi.project.system.role.controller.RoleController.edit()', 'web', 'admin', '计算机科学与技术学院', '/system/role/edit/1', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 14:34:27');
INSERT INTO `sys_oper_log` VALUES ('157', '系统管理', '角色管理-保存角色', 'com.ruoyi.project.system.role.controller.RoleController.save()', 'web', 'admin', '计算机科学与技术学院', '/system/role/save', '0:0:0:0:0:0:0:1', '{\"roleId\":[\"1\"],\"roleName\":[\"管理员\"],\"roleKey\":[\"admin\"],\"roleSort\":[\"1\"],\"status\":[\"0\"],\"remark\":[\"管理员\"],\"menuIds\":[\"1,4,18,19,20,21,22,23,24,5,25,26,27,28,29,30,6,31,32,33,34,35,7,36,37,38,39,40,8,41,42,43,44,45,46,9,47,48,49,50,51,52,10,53,54,55,56,57,58', '0', null, '2019-05-31 14:34:38');
INSERT INTO `sys_oper_log` VALUES ('158', '系统管理', '部门管理-新增部门', 'com.ruoyi.project.system.dept.controller.DeptController.add()', 'web', 'admin', '计算机科学与技术学院', '/system/dept/add/100', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 14:37:04');
INSERT INTO `sys_oper_log` VALUES ('159', '系统管理', '部门管理-新增部门', 'com.ruoyi.project.system.dept.controller.DeptController.add()', 'web', 'admin', '计算机科学与技术学院', '/system/dept/add/100', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 16:22:42');
INSERT INTO `sys_oper_log` VALUES ('160', '系统管理', '部门管理-新增部门', 'com.ruoyi.project.system.dept.controller.DeptController.add()', 'web', 'admin', '计算机科学与技术学院', '/system/dept/add/100', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 16:22:54');
INSERT INTO `sys_oper_log` VALUES ('161', '系统管理', '部门管理-新增部门', 'com.ruoyi.project.system.dept.controller.DeptController.add()', 'web', 'admin', '计算机科学与技术学院', '/system/dept/add/100', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-05-31 16:27:04');
INSERT INTO `sys_oper_log` VALUES ('162', '系统管理', '部门管理-保存部门', 'com.ruoyi.project.system.dept.controller.DeptController.save()', 'web', 'admin', '计算机科学与技术学院', '/system/dept/save', '0:0:0:0:0:0:0:1', '{\"parentId\":[\"99\"],\"deptName\":[\"测试机构\"],\"orderNum\":[\"500\"],\"leader\":[\"小邓\"],\"phone\":[\"15077232323\"],\"email\":[\"11645454@qq.com\"],\"status\":[\"0\"]}', '0', null, '2019-05-31 16:27:43');
INSERT INTO `sys_oper_log` VALUES ('163', '系统管理', '角色管理-新增角色', 'com.ruoyi.project.system.role.controller.RoleController.add()', 'web', 'admin', '计算机科学与技术学院', '/system/role/add', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-06-03 09:05:10');
INSERT INTO `sys_oper_log` VALUES ('164', '系统管理', '角色管理-新增角色', 'com.ruoyi.project.system.role.controller.RoleController.add()', 'web', 'admin', '计算机科学与技术学院', '/system/role/add', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-06-03 09:06:36');
INSERT INTO `sys_oper_log` VALUES ('165', '系统管理', '角色管理-新增角色', 'com.ruoyi.project.system.role.controller.RoleController.add()', 'web', 'admin', '计算机科学与技术学院', '/system/role/add', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-06-03 09:15:04');
INSERT INTO `sys_oper_log` VALUES ('166', '系统管理', '用户管理-新增用户', 'com.ruoyi.project.system.user.controller.UserController.add()', 'web', 'admin', '计算机科学与技术学院', '/system/user/add', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-06-03 09:19:56');
INSERT INTO `sys_oper_log` VALUES ('167', '系统管理', '用户管理-新增用户', 'com.ruoyi.project.system.user.controller.UserController.add()', 'web', 'admin', '计算机科学与技术学院', '/system/user/add', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-06-03 11:13:07');
INSERT INTO `sys_oper_log` VALUES ('168', '系统管理', '用户管理-新增用户', 'com.ruoyi.project.system.user.controller.UserController.add()', 'web', 'admin', '计算机科学与技术学院', '/system/user/add', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-06-03 11:23:11');
INSERT INTO `sys_oper_log` VALUES ('169', '系统管理', '菜单管理-修改菜单', 'com.ruoyi.project.system.menu.controller.MenuController.edit()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/edit/97', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-06-03 11:40:51');
INSERT INTO `sys_oper_log` VALUES ('170', '系统管理', '菜单管理-保存菜单', 'com.ruoyi.project.system.menu.controller.MenuController.save()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/save', '0:0:0:0:0:0:0:1', '{\"menuId\":[\"97\"],\"parentId\":[\"3\"],\"menuType\":[\"C\"],\"menuName\":[\"缴费项目\"],\"url\":[\"/pay/project\"],\"perms\":[\"pay:project:view\"],\"orderNum\":[\"20\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2019-06-03 11:40:57');
INSERT INTO `sys_oper_log` VALUES ('171', '系统管理', '菜单管理-修改菜单', 'com.ruoyi.project.system.menu.controller.MenuController.edit()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/edit/83', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-06-03 11:41:08');
INSERT INTO `sys_oper_log` VALUES ('172', '系统管理', '菜单管理-保存菜单', 'com.ruoyi.project.system.menu.controller.MenuController.save()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/save', '0:0:0:0:0:0:0:1', '{\"menuId\":[\"83\"],\"parentId\":[\"3\"],\"menuType\":[\"C\"],\"menuName\":[\"缴费数据\"],\"url\":[\"/pay/info\"],\"perms\":[\"pay:info:view\"],\"orderNum\":[\"30\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2019-06-03 11:41:12');
INSERT INTO `sys_oper_log` VALUES ('173', '系统管理', '菜单管理-修改菜单', 'com.ruoyi.project.system.menu.controller.MenuController.edit()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/edit/76', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-06-03 11:41:24');
INSERT INTO `sys_oper_log` VALUES ('174', '系统管理', '菜单管理-保存菜单', 'com.ruoyi.project.system.menu.controller.MenuController.save()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/save', '0:0:0:0:0:0:0:1', '{\"menuId\":[\"76\"],\"parentId\":[\"3\"],\"menuType\":[\"C\"],\"menuName\":[\"缴费流水\"],\"url\":[\"/pay/infoDetail\"],\"perms\":[\"pay:infoDetail:view\"],\"orderNum\":[\"40\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2019-06-03 11:41:28');
INSERT INTO `sys_oper_log` VALUES ('175', '系统管理', '菜单管理-修改菜单', 'com.ruoyi.project.system.menu.controller.MenuController.edit()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/edit/104', '0:0:0:0:0:0:0:1', '{}', '0', null, '2019-06-03 11:41:41');
INSERT INTO `sys_oper_log` VALUES ('176', '系统管理', '菜单管理-保存菜单', 'com.ruoyi.project.system.menu.controller.MenuController.save()', 'web', 'admin', '计算机科学与技术学院', '/system/menu/save', '0:0:0:0:0:0:0:1', '{\"menuId\":[\"104\"],\"parentId\":[\"3\"],\"menuType\":[\"C\"],\"menuName\":[\"商户慧商通\"],\"url\":[\"/pay/secretkeyInfo\"],\"perms\":[\"pay:secretkeyInfo:view\"],\"orderNum\":[\"50\"],\"icon\":[\"#\"],\"visible\":[\"0\"]}', '0', null, '2019-06-03 11:41:44');

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(100) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` int(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='岗位信息表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES ('1', 'ceo', '董事长', '1', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('2', 'se', '项目经理', '2', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('3', 'hr', '人力资源', '3', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_post` VALUES ('4', 'user', '普通员工', '4', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(10) NOT NULL COMMENT '显示顺序',
  `status` int(1) DEFAULT '0' COMMENT '角色状态:0正常,1禁用',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', 'admin', '1', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-05-31 14:34:38', '管理员');
INSERT INTO `sys_role` VALUES ('2', '普通角色', 'common', '2', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-05-30 09:44:48', '普通角色');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1');
INSERT INTO `sys_role_menu` VALUES ('1', '2');
INSERT INTO `sys_role_menu` VALUES ('1', '3');
INSERT INTO `sys_role_menu` VALUES ('1', '4');
INSERT INTO `sys_role_menu` VALUES ('1', '5');
INSERT INTO `sys_role_menu` VALUES ('1', '6');
INSERT INTO `sys_role_menu` VALUES ('1', '7');
INSERT INTO `sys_role_menu` VALUES ('1', '8');
INSERT INTO `sys_role_menu` VALUES ('1', '9');
INSERT INTO `sys_role_menu` VALUES ('1', '10');
INSERT INTO `sys_role_menu` VALUES ('1', '11');
INSERT INTO `sys_role_menu` VALUES ('1', '12');
INSERT INTO `sys_role_menu` VALUES ('1', '13');
INSERT INTO `sys_role_menu` VALUES ('1', '14');
INSERT INTO `sys_role_menu` VALUES ('1', '15');
INSERT INTO `sys_role_menu` VALUES ('1', '16');
INSERT INTO `sys_role_menu` VALUES ('1', '17');
INSERT INTO `sys_role_menu` VALUES ('1', '18');
INSERT INTO `sys_role_menu` VALUES ('1', '19');
INSERT INTO `sys_role_menu` VALUES ('1', '20');
INSERT INTO `sys_role_menu` VALUES ('1', '21');
INSERT INTO `sys_role_menu` VALUES ('1', '22');
INSERT INTO `sys_role_menu` VALUES ('1', '23');
INSERT INTO `sys_role_menu` VALUES ('1', '24');
INSERT INTO `sys_role_menu` VALUES ('1', '25');
INSERT INTO `sys_role_menu` VALUES ('1', '26');
INSERT INTO `sys_role_menu` VALUES ('1', '27');
INSERT INTO `sys_role_menu` VALUES ('1', '28');
INSERT INTO `sys_role_menu` VALUES ('1', '29');
INSERT INTO `sys_role_menu` VALUES ('1', '30');
INSERT INTO `sys_role_menu` VALUES ('1', '31');
INSERT INTO `sys_role_menu` VALUES ('1', '32');
INSERT INTO `sys_role_menu` VALUES ('1', '33');
INSERT INTO `sys_role_menu` VALUES ('1', '34');
INSERT INTO `sys_role_menu` VALUES ('1', '35');
INSERT INTO `sys_role_menu` VALUES ('1', '36');
INSERT INTO `sys_role_menu` VALUES ('1', '37');
INSERT INTO `sys_role_menu` VALUES ('1', '38');
INSERT INTO `sys_role_menu` VALUES ('1', '39');
INSERT INTO `sys_role_menu` VALUES ('1', '40');
INSERT INTO `sys_role_menu` VALUES ('1', '41');
INSERT INTO `sys_role_menu` VALUES ('1', '42');
INSERT INTO `sys_role_menu` VALUES ('1', '43');
INSERT INTO `sys_role_menu` VALUES ('1', '44');
INSERT INTO `sys_role_menu` VALUES ('1', '45');
INSERT INTO `sys_role_menu` VALUES ('1', '46');
INSERT INTO `sys_role_menu` VALUES ('1', '47');
INSERT INTO `sys_role_menu` VALUES ('1', '48');
INSERT INTO `sys_role_menu` VALUES ('1', '49');
INSERT INTO `sys_role_menu` VALUES ('1', '50');
INSERT INTO `sys_role_menu` VALUES ('1', '51');
INSERT INTO `sys_role_menu` VALUES ('1', '52');
INSERT INTO `sys_role_menu` VALUES ('1', '53');
INSERT INTO `sys_role_menu` VALUES ('1', '54');
INSERT INTO `sys_role_menu` VALUES ('1', '55');
INSERT INTO `sys_role_menu` VALUES ('1', '56');
INSERT INTO `sys_role_menu` VALUES ('1', '57');
INSERT INTO `sys_role_menu` VALUES ('1', '58');
INSERT INTO `sys_role_menu` VALUES ('1', '59');
INSERT INTO `sys_role_menu` VALUES ('1', '60');
INSERT INTO `sys_role_menu` VALUES ('1', '61');
INSERT INTO `sys_role_menu` VALUES ('1', '62');
INSERT INTO `sys_role_menu` VALUES ('1', '63');
INSERT INTO `sys_role_menu` VALUES ('1', '64');
INSERT INTO `sys_role_menu` VALUES ('1', '65');
INSERT INTO `sys_role_menu` VALUES ('1', '66');
INSERT INTO `sys_role_menu` VALUES ('1', '67');
INSERT INTO `sys_role_menu` VALUES ('1', '68');
INSERT INTO `sys_role_menu` VALUES ('1', '69');
INSERT INTO `sys_role_menu` VALUES ('1', '70');
INSERT INTO `sys_role_menu` VALUES ('1', '71');
INSERT INTO `sys_role_menu` VALUES ('1', '72');
INSERT INTO `sys_role_menu` VALUES ('1', '73');
INSERT INTO `sys_role_menu` VALUES ('1', '74');
INSERT INTO `sys_role_menu` VALUES ('1', '75');
INSERT INTO `sys_role_menu` VALUES ('1', '76');
INSERT INTO `sys_role_menu` VALUES ('1', '77');
INSERT INTO `sys_role_menu` VALUES ('1', '78');
INSERT INTO `sys_role_menu` VALUES ('1', '79');
INSERT INTO `sys_role_menu` VALUES ('1', '80');
INSERT INTO `sys_role_menu` VALUES ('1', '81');
INSERT INTO `sys_role_menu` VALUES ('1', '82');
INSERT INTO `sys_role_menu` VALUES ('1', '83');
INSERT INTO `sys_role_menu` VALUES ('1', '84');
INSERT INTO `sys_role_menu` VALUES ('1', '85');
INSERT INTO `sys_role_menu` VALUES ('1', '86');
INSERT INTO `sys_role_menu` VALUES ('1', '87');
INSERT INTO `sys_role_menu` VALUES ('1', '88');
INSERT INTO `sys_role_menu` VALUES ('1', '89');
INSERT INTO `sys_role_menu` VALUES ('1', '90');
INSERT INTO `sys_role_menu` VALUES ('1', '91');
INSERT INTO `sys_role_menu` VALUES ('1', '92');
INSERT INTO `sys_role_menu` VALUES ('1', '93');
INSERT INTO `sys_role_menu` VALUES ('1', '94');
INSERT INTO `sys_role_menu` VALUES ('1', '95');
INSERT INTO `sys_role_menu` VALUES ('1', '96');
INSERT INTO `sys_role_menu` VALUES ('1', '97');
INSERT INTO `sys_role_menu` VALUES ('1', '98');
INSERT INTO `sys_role_menu` VALUES ('1', '99');
INSERT INTO `sys_role_menu` VALUES ('1', '100');
INSERT INTO `sys_role_menu` VALUES ('1', '101');
INSERT INTO `sys_role_menu` VALUES ('1', '102');
INSERT INTO `sys_role_menu` VALUES ('1', '103');
INSERT INTO `sys_role_menu` VALUES ('1', '104');
INSERT INTO `sys_role_menu` VALUES ('1', '105');
INSERT INTO `sys_role_menu` VALUES ('1', '106');
INSERT INTO `sys_role_menu` VALUES ('1', '107');
INSERT INTO `sys_role_menu` VALUES ('1', '108');
INSERT INTO `sys_role_menu` VALUES ('1', '109');
INSERT INTO `sys_role_menu` VALUES ('1', '110');
INSERT INTO `sys_role_menu` VALUES ('1', '111');
INSERT INTO `sys_role_menu` VALUES ('2', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '2');
INSERT INTO `sys_role_menu` VALUES ('2', '3');
INSERT INTO `sys_role_menu` VALUES ('2', '4');
INSERT INTO `sys_role_menu` VALUES ('2', '5');
INSERT INTO `sys_role_menu` VALUES ('2', '6');
INSERT INTO `sys_role_menu` VALUES ('2', '7');
INSERT INTO `sys_role_menu` VALUES ('2', '8');
INSERT INTO `sys_role_menu` VALUES ('2', '9');
INSERT INTO `sys_role_menu` VALUES ('2', '10');
INSERT INTO `sys_role_menu` VALUES ('2', '11');
INSERT INTO `sys_role_menu` VALUES ('2', '12');
INSERT INTO `sys_role_menu` VALUES ('2', '13');
INSERT INTO `sys_role_menu` VALUES ('2', '14');
INSERT INTO `sys_role_menu` VALUES ('2', '15');
INSERT INTO `sys_role_menu` VALUES ('2', '16');
INSERT INTO `sys_role_menu` VALUES ('2', '17');
INSERT INTO `sys_role_menu` VALUES ('2', '18');
INSERT INTO `sys_role_menu` VALUES ('2', '19');
INSERT INTO `sys_role_menu` VALUES ('2', '20');
INSERT INTO `sys_role_menu` VALUES ('2', '21');
INSERT INTO `sys_role_menu` VALUES ('2', '22');
INSERT INTO `sys_role_menu` VALUES ('2', '23');
INSERT INTO `sys_role_menu` VALUES ('2', '24');
INSERT INTO `sys_role_menu` VALUES ('2', '25');
INSERT INTO `sys_role_menu` VALUES ('2', '26');
INSERT INTO `sys_role_menu` VALUES ('2', '27');
INSERT INTO `sys_role_menu` VALUES ('2', '28');
INSERT INTO `sys_role_menu` VALUES ('2', '29');
INSERT INTO `sys_role_menu` VALUES ('2', '30');
INSERT INTO `sys_role_menu` VALUES ('2', '31');
INSERT INTO `sys_role_menu` VALUES ('2', '32');
INSERT INTO `sys_role_menu` VALUES ('2', '33');
INSERT INTO `sys_role_menu` VALUES ('2', '34');
INSERT INTO `sys_role_menu` VALUES ('2', '35');
INSERT INTO `sys_role_menu` VALUES ('2', '36');
INSERT INTO `sys_role_menu` VALUES ('2', '37');
INSERT INTO `sys_role_menu` VALUES ('2', '38');
INSERT INTO `sys_role_menu` VALUES ('2', '39');
INSERT INTO `sys_role_menu` VALUES ('2', '40');
INSERT INTO `sys_role_menu` VALUES ('2', '41');
INSERT INTO `sys_role_menu` VALUES ('2', '42');
INSERT INTO `sys_role_menu` VALUES ('2', '43');
INSERT INTO `sys_role_menu` VALUES ('2', '44');
INSERT INTO `sys_role_menu` VALUES ('2', '45');
INSERT INTO `sys_role_menu` VALUES ('2', '46');
INSERT INTO `sys_role_menu` VALUES ('2', '47');
INSERT INTO `sys_role_menu` VALUES ('2', '48');
INSERT INTO `sys_role_menu` VALUES ('2', '49');
INSERT INTO `sys_role_menu` VALUES ('2', '50');
INSERT INTO `sys_role_menu` VALUES ('2', '51');
INSERT INTO `sys_role_menu` VALUES ('2', '52');
INSERT INTO `sys_role_menu` VALUES ('2', '53');
INSERT INTO `sys_role_menu` VALUES ('2', '54');
INSERT INTO `sys_role_menu` VALUES ('2', '55');
INSERT INTO `sys_role_menu` VALUES ('2', '56');
INSERT INTO `sys_role_menu` VALUES ('2', '57');
INSERT INTO `sys_role_menu` VALUES ('2', '58');
INSERT INTO `sys_role_menu` VALUES ('2', '59');
INSERT INTO `sys_role_menu` VALUES ('2', '60');
INSERT INTO `sys_role_menu` VALUES ('2', '61');
INSERT INTO `sys_role_menu` VALUES ('2', '62');
INSERT INTO `sys_role_menu` VALUES ('2', '63');
INSERT INTO `sys_role_menu` VALUES ('2', '64');
INSERT INTO `sys_role_menu` VALUES ('2', '65');
INSERT INTO `sys_role_menu` VALUES ('2', '66');
INSERT INTO `sys_role_menu` VALUES ('2', '67');
INSERT INTO `sys_role_menu` VALUES ('2', '68');
INSERT INTO `sys_role_menu` VALUES ('2', '69');
INSERT INTO `sys_role_menu` VALUES ('2', '70');
INSERT INTO `sys_role_menu` VALUES ('2', '71');
INSERT INTO `sys_role_menu` VALUES ('2', '72');
INSERT INTO `sys_role_menu` VALUES ('2', '73');
INSERT INTO `sys_role_menu` VALUES ('2', '74');
INSERT INTO `sys_role_menu` VALUES ('2', '75');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` int(20) DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) DEFAULT '' COMMENT '登录账号',
  `user_name` varchar(30) DEFAULT '' COMMENT '用户昵称',
  `email` varchar(100) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(20) DEFAULT '' COMMENT '手机号码',
  `sex` char(20) DEFAULT '0' COMMENT '用户性别:0男,1女',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `salt` varchar(100) DEFAULT '' COMMENT '盐加密',
  `user_type` char(1) DEFAULT 'N' COMMENT '类型:Y默认用户,N非默认用户',
  `status` int(1) DEFAULT '0' COMMENT '帐号状态:0正常,1禁用',
  `refuse_des` varchar(500) DEFAULT '' COMMENT '拒绝登录描述',
  `login_ip` varchar(100) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '106', 'admin', '若依', 'ry@163.com', '15888888888', '0', '', '29c67a30398638269fe600f73a054934', '111111', 'Y', '0', '正常', '0:0:0:0:0:0:0:1', '2019-06-03 15:16:28', 'admin', '2018-03-16 11:33:00', 'ry', '2019-06-03 15:16:22');
INSERT INTO `sys_user` VALUES ('2', '108', 'ry', '若依', 'ry@qq.com', '15666666666', '1', '', '7ee5c4be4feae4cefa912f94d0cd91b2', '091d4a', 'N', '0', '正常', '0:0:0:0:0:0:0:1', '2019-05-30 09:45:03', 'admin', '2018-03-16 11:33:00', 'admin', '2019-05-30 09:45:03');

-- ----------------------------
-- Table structure for sys_user_online
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_online`;
CREATE TABLE `sys_user_online` (
  `sessionId` varchar(50) NOT NULL DEFAULT '' COMMENT '用户会话id',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` varchar(10) DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
  `start_timestsamp` datetime DEFAULT NULL COMMENT 'session创建时间',
  `last_access_time` datetime DEFAULT NULL COMMENT 'session最后访问时间',
  `expire_time` int(5) DEFAULT '0' COMMENT '超时时间，单位为分钟',
  PRIMARY KEY (`sessionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='在线用户记录';

-- ----------------------------
-- Records of sys_user_online
-- ----------------------------
INSERT INTO `sys_user_online` VALUES ('835f448e-a9ba-4d34-8074-1ac48e4b8f18', 'admin', '计算机科学与技术学院', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', 'on_line', '2019-06-03 15:16:18', '2019-06-03 15:16:29', '1800000');
INSERT INTO `sys_user_online` VALUES ('a27cc2fc-1705-4e4e-8074-ed662fa6b413', 'admin', '计算机科学与技术学院', '0:0:0:0:0:0:0:1', 'Chrome', 'Windows 7', 'on_line', '2019-06-03 14:58:49', '2019-06-03 14:58:55', '1800000');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post` (
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `post_id` varchar(64) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与岗位关联表';

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES ('1', '1');
INSERT INTO `sys_user_post` VALUES ('2', '2');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '1');