/*
Navicat MySQL Data Transfer

Source Server         : zhangsy
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : zsy

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-08-19 13:36:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_td_colproject`
-- ----------------------------
DROP TABLE IF EXISTS `t_td_colproject`;
CREATE TABLE `t_td_colproject` (
  `gid` varchar(40) NOT NULL,
  `xmxh` int(11) NOT NULL,
  `xmmc` varchar(200) DEFAULT NULL,
  `sfty` int(11) DEFAULT NULL,
  `OWNERID` varchar(50) DEFAULT NULL,
  `F_BIZSTATE` int(11) DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of t_td_colproject
-- ----------------------------
INSERT INTO `t_td_colproject` VALUES ('1', '1', '应用分离服务收集', '0', '1', '0');
INSERT INTO `t_td_colproject` VALUES ('2', '2', '数据服务化场景收集', '0', '1', '0');
INSERT INTO `t_td_colproject` VALUES ('3', '3', '模块间依赖关系检查结果清单', '0', '1111', '0');
INSERT INTO `t_td_colproject` VALUES ('4', '4', '应用分离服务、资源和vipaddress对应关系', '0', '1111', '0');
INSERT INTO `t_td_colproject` VALUES ('5', '5', 'GRIS项目组和程序包对应关系', '0', '1111', '0');
INSERT INTO `t_td_colproject` VALUES ('6', '6', '基础包依赖整改情况', '0', '1111', '0');
INSERT INTO `t_td_colproject` VALUES ('7', '7', '基础包所属识别', '1', '1111', '0');
