/*
Navicat MySQL Data Transfer

Source Server         : fang
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : hospitalpro

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2021-01-01 10:38:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `account` char(16) NOT NULL,
  `password` char(16) DEFAULT NULL,
  `name` char(16) DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', 'admin', '管理员');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `account` char(16) DEFAULT NULL,
  `password` char(16) DEFAULT NULL,
  `dname` char(16) DEFAULT NULL,
  `fee` int(11) DEFAULT NULL,
  `gender` char(2) DEFAULT NULL,
  `age` int(4) DEFAULT NULL,
  `office` char(16) DEFAULT NULL,
  `career` char(16) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `picpath` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`did`),
  KEY `office1` (`office`),
  CONSTRAINT `office1` FOREIGN KEY (`office`) REFERENCES `office` (`officename`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('1', '00001', '654321', '邱伟华', '100', '男', '30', '不孕不育科', '主任医师', '上海交通大学医学院附属瑞金医院', '/mavenHospital/images/docpic/1.png');
INSERT INTO `doctor` VALUES ('2', '00002', '123456', '汤正义', '11', '女', '24', '中内科', '主任医师', '上海交通大学医学院附属瑞金医院', '/mavenHospital/images/docpic/2.png');
INSERT INTO `doctor` VALUES ('3', '00003', '123456', '吴生元', '150', '男', '65', '中内科', '中医内科专家', '上海交通大学医学院附属瑞金医院', '/mavenHospital/images/docpic/3.png');
INSERT INTO `doctor` VALUES ('4', '00004', '123456', '钟南山', '150', '男', '51', '中内科', '中医内科专家', '上海交通大学医学院附属瑞金医院', '/mavenHospital/images/docpic/4.png');
INSERT INTO `doctor` VALUES ('5', '00005', '123456', '纪立农', '100', '男', '45', '内分泌科', '内分泌科主任', '上海交通大学医学院附属瑞金医院', '/mavenHospital/images/docpic/5.png');
INSERT INTO `doctor` VALUES ('6', '00006', '123456', '邢小平', '100', '女', '45', '内分泌科', '内分泌科专家', '上海交通大学医学院附属瑞金医院', '/mavenHospital/images/docpic/6.png');
INSERT INTO `doctor` VALUES ('7', '00007', '123456', '杨宗于', '150', '女', '40', '内分泌科', '内分泌科副主任', '上海交通大学医学院附属瑞金医院', '/mavenHospital/images/docpic/7.png');
INSERT INTO `doctor` VALUES ('8', '00008', '123456', '吴问汉', '150', '男', '35', '外科', '外科主任', '上海交通大学医学院附属瑞金医院', '/mavenHospital/images/docpic/8.png');
INSERT INTO `doctor` VALUES ('9', '00009', '123456', '朱小文', '123', '女', '34', '外科', '专家', '湖南中医药大学', '/mavenHospital/images/docpic/9.png');
INSERT INTO `doctor` VALUES ('10', '00012', '123456', '傅慎行', '56', '男', '34', '外科', '主任医师', '我们来玩个玩个游戏吧', '/mavenHospital/images/docpic/10.png');
INSERT INTO `doctor` VALUES ('11', '00013', '123456', '康小羽', '54', '女', '33', '内分泌科', '主任医师', '既美丽有大方，能力强', '/mavenHospital/images/docpic/11.png');

-- ----------------------------
-- Table structure for office
-- ----------------------------
DROP TABLE IF EXISTS `office`;
CREATE TABLE `office` (
  `officename` char(16) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `doctornum` int(111) DEFAULT NULL,
  PRIMARY KEY (`officename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of office
-- ----------------------------
INSERT INTO `office` VALUES ('不孕不育科', '不孕不育作为医院的重点科室，率先引进世界高成功率技术！', '1');
INSERT INTO `office` VALUES ('中内科', '暂无描述', '3');
INSERT INTO `office` VALUES ('中医妇科', ' 汇集全城妇科专家，帮您解决疑难杂症！', '0');
INSERT INTO `office` VALUES ('儿科泌尿专科', '暂无描述', '0');
INSERT INTO `office` VALUES ('儿科神经内科', '暂无描述', '0');
INSERT INTO `office` VALUES ('内分泌科', '暂无描述', '4');
INSERT INTO `office` VALUES ('口腔科', '种植中心、正畸中心、修复等是特色专科。', '0');
INSERT INTO `office` VALUES ('呼吸内科', '暂无描述', '0');
INSERT INTO `office` VALUES ('外科', '暂无描述', '3');
INSERT INTO `office` VALUES ('心血管内科', '暂无描述', '0');
INSERT INTO `office` VALUES ('新生儿科', '暂无描述', '0');
INSERT INTO `office` VALUES ('眼科', '专业眼科，帮助您更好的恢复视力，有一双明亮的眼！', '0');
INSERT INTO `office` VALUES ('神经内科', '暂无描述', '0');
INSERT INTO `office` VALUES ('骨外科', '暂无描述', '0');

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `account` char(16) DEFAULT NULL,
  `email` char(32) DEFAULT NULL,
  `password` char(32) DEFAULT NULL,
  `name` char(11) DEFAULT NULL,
  `integity` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES ('1', '123', '1509438463@qq.com', '1234', 'Li', '100');
INSERT INTO `patient` VALUES ('2', '222', 'llf1234@qq.com', '222', 'LiLian', '100');
INSERT INTO `patient` VALUES ('3', '333', '1603656163@qq.com', '333', 'er', '100');
INSERT INTO `patient` VALUES ('4', '890', '379840451@qq.com', '890', 'FFL', '100');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `wid` int(11) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  `serialnumber` int(11) DEFAULT NULL,
  `visitdate` date DEFAULT NULL,
  `visittime` char(8) DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `state` char(8) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `did` (`wid`),
  KEY `pid` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('15', '1', '11', '1', '2', '2021-01-01', '8:54', '2020-12-30 10:20:29', '成功');
INSERT INTO `record` VALUES ('16', '1', '6', '1', '11', '2021-01-05', '17:0', '2020-12-30 10:28:17', '成功');
INSERT INTO `record` VALUES ('17', '1', '111', '8', '8', '2021-01-02', '11:18', '2020-12-30 10:51:25', '成功');
INSERT INTO `record` VALUES ('18', '1', '81', '6', '8', '2021-01-01', '11:18', '2020-12-30 10:54:21', '成功');
INSERT INTO `record` VALUES ('19', '1', '69', '5', '10', '2021-01-02', '12:6', '2020-12-30 10:57:59', '成功');
INSERT INTO `record` VALUES ('20', '1', '1', '1', '1', '2021-01-03', '8:30', '2020-12-30 11:04:49', '成功');
INSERT INTO `record` VALUES ('21', '1', '3', '1', '9', '2021-01-04', '11:42', '2020-12-30 11:07:14', '成功');
INSERT INTO `record` VALUES ('22', '2', '3', '1', '1', '2021-01-04', '8:30', '2020-12-31 16:59:14', '爽约');
INSERT INTO `record` VALUES ('23', '2', '6', '1', '1', '2021-01-05', '13:30', '2020-12-30 17:08:50', '完成');
INSERT INTO `record` VALUES ('24', '4', '99', '8', '7', '2021-01-03', '10:54', '2020-12-30 17:38:53', '成功');
INSERT INTO `record` VALUES ('25', '1', '37', '3', '7', '2020-12-31', '10:54', '2020-12-30 21:14:30', '成功');
INSERT INTO `record` VALUES ('26', '1', '9', '1', '10', '2020-12-31', '11:3', '2020-12-30 21:14:56', '成功');
INSERT INTO `record` VALUES ('27', '1', '7', '1', '8', '2021-01-06', '11:18', '2020-12-31 11:34:06', '成功');
INSERT INTO `record` VALUES ('28', '1', '7', '1', '7', '2021-01-06', '11:6', '2020-12-31 11:34:46', '成功');
INSERT INTO `record` VALUES ('29', '1', '141', '11', '3', '2021-01-03', '9:18', '2020-12-31 11:38:48', '成功');
INSERT INTO `record` VALUES ('30', '1', '105', '8', '6', '2021-01-06', '10:30', '2020-12-31 16:32:14', '成功');

-- ----------------------------
-- Table structure for workday
-- ----------------------------
DROP TABLE IF EXISTS `workday`;
CREATE TABLE `workday` (
  `wid` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) DEFAULT NULL,
  `worktime` char(4) DEFAULT NULL,
  `ampm` char(4) DEFAULT NULL,
  `nsnum` int(11) DEFAULT NULL,
  `state` char(8) DEFAULT NULL,
  PRIMARY KEY (`wid`),
  KEY `did1` (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of workday
-- ----------------------------
INSERT INTO `workday` VALUES ('1', '1', '0', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('2', '1', '0', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('3', '1', '1', '上午', '1', '预约');
INSERT INTO `workday` VALUES ('4', '1', '1', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('5', '1', '2', '上午', '0', '停诊');
INSERT INTO `workday` VALUES ('6', '1', '2', '下午', '0', '预约');
INSERT INTO `workday` VALUES ('7', '1', '3', '上午', '8', '预约');
INSERT INTO `workday` VALUES ('8', '1', '3', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('9', '1', '4', '上午', '13', '预约');
INSERT INTO `workday` VALUES ('10', '1', '4', '下午', '7', '预约');
INSERT INTO `workday` VALUES ('11', '1', '5', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('12', '1', '5', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('13', '1', '6', '上午', '0', '停诊');
INSERT INTO `workday` VALUES ('14', '1', '6', '下午', '12', '预约');
INSERT INTO `workday` VALUES ('15', '2', '0', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('16', '2', '0', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('17', '2', '1', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('18', '2', '1', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('19', '2', '2', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('20', '2', '2', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('21', '2', '3', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('22', '2', '3', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('23', '2', '4', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('24', '2', '4', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('25', '2', '5', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('26', '2', '5', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('27', '2', '6', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('28', '2', '6', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('29', '3', '0', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('30', '3', '0', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('31', '3', '1', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('32', '3', '1', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('33', '3', '2', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('34', '3', '2', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('35', '3', '3', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('36', '3', '3', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('37', '3', '4', '上午', '9', '预约');
INSERT INTO `workday` VALUES ('38', '3', '4', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('39', '3', '5', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('40', '3', '5', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('41', '3', '6', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('42', '3', '6', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('43', '4', '0', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('44', '4', '0', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('45', '4', '1', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('46', '4', '1', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('47', '4', '2', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('48', '4', '2', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('49', '4', '3', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('50', '4', '3', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('51', '4', '4', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('52', '4', '4', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('53', '4', '5', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('54', '4', '5', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('55', '4', '6', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('56', '4', '6', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('57', '5', '0', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('58', '5', '0', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('59', '5', '1', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('60', '5', '1', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('61', '5', '2', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('62', '5', '2', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('63', '5', '3', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('64', '5', '3', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('65', '5', '4', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('66', '5', '4', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('67', '5', '5', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('68', '5', '5', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('69', '5', '6', '上午', '9', '预约');
INSERT INTO `workday` VALUES ('70', '5', '6', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('71', '6', '0', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('72', '6', '0', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('73', '6', '1', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('74', '6', '1', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('75', '6', '2', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('76', '6', '2', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('77', '6', '3', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('78', '6', '3', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('79', '6', '4', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('80', '6', '4', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('81', '6', '5', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('82', '6', '5', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('83', '6', '6', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('84', '6', '6', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('85', '7', '0', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('86', '7', '0', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('87', '7', '1', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('88', '7', '1', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('89', '7', '2', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('90', '7', '2', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('91', '7', '3', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('92', '7', '3', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('93', '7', '4', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('94', '7', '4', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('95', '7', '5', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('96', '7', '5', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('97', '7', '6', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('98', '7', '6', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('99', '8', '0', '上午', '9', '预约');
INSERT INTO `workday` VALUES ('100', '8', '0', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('101', '8', '1', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('102', '8', '1', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('103', '8', '2', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('104', '8', '2', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('105', '8', '3', '上午', '9', '预约');
INSERT INTO `workday` VALUES ('106', '8', '3', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('107', '8', '4', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('108', '8', '4', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('109', '8', '5', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('110', '8', '5', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('111', '8', '6', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('112', '8', '6', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('113', '9', '0', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('114', '9', '0', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('115', '9', '1', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('116', '9', '1', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('117', '9', '2', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('118', '9', '2', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('119', '9', '3', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('120', '9', '3', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('121', '9', '4', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('122', '9', '4', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('123', '9', '5', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('124', '9', '5', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('125', '9', '6', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('126', '9', '6', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('127', '10', '0', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('128', '10', '0', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('129', '10', '1', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('130', '10', '1', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('131', '10', '2', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('132', '10', '2', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('133', '10', '3', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('134', '10', '3', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('135', '10', '4', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('136', '10', '4', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('137', '10', '5', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('138', '10', '5', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('139', '10', '6', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('140', '10', '6', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('141', '11', '0', '上午', '9', '预约');
INSERT INTO `workday` VALUES ('142', '11', '0', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('143', '11', '1', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('144', '11', '1', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('145', '11', '2', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('146', '11', '2', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('147', '11', '3', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('148', '11', '3', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('149', '11', '4', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('150', '11', '4', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('151', '11', '5', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('152', '11', '5', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('153', '11', '6', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('154', '11', '6', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('155', '12', '0', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('156', '12', '0', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('157', '12', '1', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('158', '12', '1', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('159', '12', '2', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('160', '12', '2', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('161', '12', '3', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('162', '12', '3', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('163', '12', '4', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('164', '12', '4', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('165', '12', '5', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('166', '12', '5', '下午', '0', '停诊');
INSERT INTO `workday` VALUES ('167', '12', '6', '上午', '10', '预约');
INSERT INTO `workday` VALUES ('168', '12', '6', '下午', '0', '停诊');
