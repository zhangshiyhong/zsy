/*
Navicat MySQL Data Transfer

Source Server         : zhangsy
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : zsy

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-08-19 13:36:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_td_colviewitem`
-- ----------------------------
DROP TABLE IF EXISTS `t_td_colviewitem`;
CREATE TABLE `t_td_colviewitem` (
  `gid` varchar(40) NOT NULL,
  `xsxh` int(11) DEFAULT NULL,
  `xmxh` int(11) NOT NULL,
  `zdmc` varchar(40) DEFAULT NULL,
  `xsmc` varchar(300) DEFAULT NULL,
  `OWNERID` varchar(50) DEFAULT NULL,
  `F_BIZSTATE` int(11) DEFAULT NULL,
  `zdlx` int(11) DEFAULT NULL,
  `zdz` varchar(2000) DEFAULT NULL,
  `sfcxtj` int(11) DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of t_td_colviewitem
-- ----------------------------
INSERT INTO `t_td_colviewitem` VALUES ('10001', '1', '1', 'mxxh', '编号', '1', '0', null, '', '1');
INSERT INTO `t_td_colviewitem` VALUES ('10002', '2', '1', 'char13', '已提供', '', '0', '1', '否,是', '1');
INSERT INTO `t_td_colviewitem` VALUES ('10003', '3', '1', 'char14', '已消费', '', '0', '1', '否,是', '1');
INSERT INTO `t_td_colviewitem` VALUES ('10004', '4', '1', 'char15', '测试情况反馈', '', '0', '1', '成功消费,未提供服务,提供服务异常', '0');
INSERT INTO `t_td_colviewitem` VALUES ('10005', '5', '1', 'char01', '服务类型', '1', '0', '1', 'OSGI,Class,Webservice', '0');
INSERT INTO `t_td_colviewitem` VALUES ('10006', '6', '1', 'char02', '原有服务接口\n', '1', '0', null, '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('10007', '7', '1', 'char03', '原服务方法及参数\n', '1', '0', null, '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('10008', '8', '1', 'char04', '原服务描述\n', '1', '0', null, '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('10009', '9', '1', 'char05', '优先级\n', '1', '0', '1', '高,中,低', '1');
INSERT INTO `t_td_colviewitem` VALUES ('10010', '10', '1', 'char06', '新服务OSGI类\n', '1', '0', null, '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('10011', '11', '1', 'long_char01', '新方法中文描述、方法、参数说明\n', '1', '0', null, '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('10012', '12', '1', 'long_char02', '不提供服务原因\n', '1', '0', null, '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('10013', '13', '1', 'char07', '服务提供负责人\n', '1', '0', '1', '田志亮,徐卫涛,蔡志冀,蔡爱平,付俊,农斌,丁大勇,刘峰,李棉,李鹏6,王国安,胡岩松,叶树强,董晓辉,陈豪5,成运来,肖云,冯建明,陈凯,吴健,涂泽文,周卫卫,唐光瑞,张豆豆', '0');
INSERT INTO `t_td_colviewitem` VALUES ('10014', '14', '1', 'char08', '服务提供模块\n', '1', '0', '1', '合并抵销,基建管控,应收应付,供应链管理,资产管理,电价管理,投融资管理,资金监控,成本管理,共享服务,内容管理,预算执行控制,预算编制,产权管理,税务管理,总账管理,报表管理,资金结算，其他', '1');
INSERT INTO `t_td_colviewitem` VALUES ('10015', '15', '1', 'char09', '服务提供项目组\n', '1', '0', '1', '报表项目组,支付结算项目组,电费结算项目组,预算多维编制项目组,共享应用项目组,智能物资项目组,合并抵销项目组,投融资项目组,工程项目项目组,YG ECM项目组,资产价值项目组,预算执行控制项目组,资金监控项目组,成本管理项目组,应收应付项目组,税务管理项目组,YG ECM 项目组,总账项目组,产权管理项目组', '0');
INSERT INTO `t_td_colviewitem` VALUES ('10016', '16', '1', 'char10', '服务消费模块\n', '1', '0', '1', '合并抵销,基建管控,应收应付,供应链管理,资产管理,电价管理,投融资管理,资金监控,成本管理,共享服务,内容管理,预算执行控制,预算编制,产权管理,税务管理,总账管理,报表管理,资金结算,其他', '1');
INSERT INTO `t_td_colviewitem` VALUES ('10017', '17', '1', 'char11', '服务消费项目组\n', '1', '0', '1', '报表项目组,支付结算项目组,电费结算项目组,预算多维编制项目组,共享应用项目组,智能物资项目组,合并抵销项目组,投融资项目组,工程项目项目组,YG ECM项目组,资产价值项目组,预算执行控制项目组,资金监控项目组,成本管理项目组,应收应付项目组,税务管理项目组,YG ECM 项目组,总账项目组,产权管理项目组，数据库组', '0');
INSERT INTO `t_td_colviewitem` VALUES ('10018', '18', '1', 'char12', '服务消费负责人\n', '1', '0', '1', '田志亮,徐卫涛,蔡志冀,蔡爱平,付俊,农斌,丁大勇,刘峰,李棉,李鹏6,王国安,胡岩松,叶树强,董晓辉,陈豪5,成运来,肖云,冯建明,陈凯,吴健,涂泽文,周卫卫,唐光瑞,张豆豆', '0');
INSERT INTO `t_td_colviewitem` VALUES ('20001', '1', '2', 'mxxh', '编号', '1', '0', null, '', '1');
INSERT INTO `t_td_colviewitem` VALUES ('20002', '2', '2', 'char14', '已消费', '', '0', '1', '否,是', '1');
INSERT INTO `t_td_colviewitem` VALUES ('20003', '3', '2', 'char13', '已提供', '', '0', '1', '否,是', '1');
INSERT INTO `t_td_colviewitem` VALUES ('20004', '4', '2', 'char01', '调用类型', '1', '0', '1', '表,存储过程', '0');
INSERT INTO `t_td_colviewitem` VALUES ('20005', '5', '2', 'char02', '调用表、存储过程', '1', '0', null, '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('20006', '6', '2', 'long_char03', '调用场景及其描述1', '1', '0', null, '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('20007', '7', '2', 'long_char04', '调用场景及其描述2', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('20008', '8', '2', 'char05', '优先级\n', '1', '0', '1', '高,中,低', '1');
INSERT INTO `t_td_colviewitem` VALUES ('20009', '9', '2', 'char06', '新服务OSGI类\n', '1', '0', null, '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('20010', '10', '2', 'long_char01', '新方法中文描述、方法、参数说明\n', '1', '0', null, '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('20011', '11', '2', 'long_char02', '不提供服务原因\n', '1', '0', null, '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('20012', '12', '2', 'char07', '服务提供负责人\n', '1', '0', '1', '田志亮,徐卫涛,蔡志冀,蔡爱平,付俊,农斌,丁大勇,刘峰,李棉,李鹏6,王国安,胡岩松,叶树强,董晓辉,陈豪5,成运来,肖云,冯建明,陈凯,吴健,涂泽文,周卫卫,覃梦,付小攀', '0');
INSERT INTO `t_td_colviewitem` VALUES ('20013', '13', '2', 'char08', '服务提供模块\n', '1', '0', '1', '合并抵销,基建管控,应收应付,供应链管理,资产管理,电价管理,投融资管理,资金监控,成本管理,共享服务,内容管理,预算执行控制,预算编制,产权管理,税务管理,总账管理,报表管理,资金结算，ECP平台', '1');
INSERT INTO `t_td_colviewitem` VALUES ('20014', '14', '2', 'char09', '服务提供项目组\n', '1', '0', '1', '报表项目组,支付结算项目组,电费结算项目组,预算多维编制项目组,共享应用项目组,智能物资项目组,合并抵销项目组,投融资项目组,工程项目项目组,YG ECM项目组,资产价值项目组,预算执行控制项目组,资金监控项目组,成本管理项目组,应收应付项目组,税务管理项目组,YG ECM 项目组,总账项目组,产权管理项目组,ECP技术支持组', '0');
INSERT INTO `t_td_colviewitem` VALUES ('20015', '15', '2', 'char10', '服务消费模块\n', '1', '0', '1', '合并抵销,基建管控,应收应付,供应链管理,资产管理,电价管理,投融资管理,资金监控,成本管理,共享服务,内容管理,预算执行控制,预算编制,产权管理,税务管理,总账管理,报表管理,资金结算', '1');
INSERT INTO `t_td_colviewitem` VALUES ('20016', '16', '2', 'char11', '服务消费项目组\n', '1', '0', '1', '报表项目组,支付结算项目组,电费结算项目组,预算多维编制项目组,共享应用项目组,智能物资项目组,合并抵销项目组,投融资项目组,工程项目项目组,YG ECM项目组,资产价值项目组,预算执行控制项目组,资金监控项目组,成本管理项目组,应收应付项目组,税务管理项目组,YG ECM 项目组,总账项目组,产权管理项目组', '0');
INSERT INTO `t_td_colviewitem` VALUES ('20017', '17', '2', 'char12', '服务消费负责人\n', '1', '0', '1', '田志亮,徐卫涛,蔡志冀,蔡爱平,付俊,农斌,丁大勇,刘峰,李棉,李鹏6,王国安,胡岩松,叶树强,董晓辉,陈豪5,成运来,肖云,冯建明,陈凯,吴健,涂泽文,周卫卫,覃梦', '0');
INSERT INTO `t_td_colviewitem` VALUES ('20018', '18', '2', 'char15', '测试情况反馈', '', '0', '1', '成功消费,未提供服务,提供服务异常', '0');
INSERT INTO `t_td_colviewitem` VALUES ('30001', '1', '3', 'mxxh', '依赖序号', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('30002', '2', '3', 'char01', '是否整改完成', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('30003', '3', '3', 'char02', '所属模块', '', '0', '1', '公共,基建管控,应收应付,合并抵销,电价管理,投融资管理,资产管理,供应链管理,项目预算,成本管理,财务领域公共,预算编制,预算执行控制,产权管理,税务管理,综合管理,总账管理,报表管理,资金结算', '1');
INSERT INTO `t_td_colviewitem` VALUES ('30004', '4', '3', 'char03', '所属项目组', '', '0', '0', '', '1');
INSERT INTO `t_td_colviewitem` VALUES ('30005', '5', '3', 'char04', '依赖包', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('30006', '6', '3', 'char05', '被依赖包路径', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('30007', '7', '3', 'char06', '被依赖包', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('30008', '8', '3', 'char07', '依赖项目', null, '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('40001', '1', '4', 'char01', '对外服务接口服务包路径', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('40002', '2', '4', 'char06', '扩展项目包', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('40003', '3', '4', 'char02', 'vipaddress', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('40004', '4', '4', 'char05', '测试服务地址IP端口', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('40005', '5', '4', 'char03', '提供模块', '', '0', '1', '合并抵销,基建管控,应收应付,供应链管理,资产管理,电价管理,投融资管理,资金监控,成本管理,共享服务,内容管理,预算执行控制,预算编制,产权管理,税务管理,总账管理,报表管理,资金结算', '1');
INSERT INTO `t_td_colviewitem` VALUES ('40006', '6', '4', 'char04', '提供人', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('40007', '7', '4', 'long_char01', '资源路径', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('50001', '1', '5', 'char01', '所属项目组', '', '0', '1', '总账项目组,报表项目组,合并抵消项目组,成本管理项目组,预算多维编制项目组,预算执行控制项目组,项目预算项目组,预算创新应用项目组,支付结算项目组,投融资项目组,资金创新应用项目组,电费结算项目组,共享应用项目组,移动业务项目组,税务管理项目组,资金监控项目组,风险内控项目组,监控及稽核项目组,审计项目组,储备项目项目组,工程项目项目组,智能物资项目组,资产价值项目组,产权管理项目组,应收应付项目组,设备实施项目组,安健环项目组,安全生产项目组,商旅管理项目组,YG Brain 软件项目组,YG Brain 硬件项目组, YG ECM 项目组,合同管理项目组,客户化事业部', '1');
INSERT INTO `t_td_colviewitem` VALUES ('50002', '2', '5', 'char02', '填报人', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('50003', '3', '5', 'long_char01', '包含程序包', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('50004', '4', '5', 'char03', '无需填写', '', '0', '1', '是,否', '1');
INSERT INTO `t_td_colviewitem` VALUES ('50005', '5', '5', 'long_char03', '包含程序包2', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('50006', '6', '5', 'long_char02', '无需填写原因', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('60001', '1', '6', 'mxxh', '编号', '', '0', '0', '', '1');
INSERT INTO `t_td_colviewitem` VALUES ('60002', '2', '6', 'char01', '是否整改完成', '', '0', '1', '是,否', '1');
INSERT INTO `t_td_colviewitem` VALUES ('60003', '3', '6', 'char09', '是否分析完成', '', '0', '1', '是,否', '1');
INSERT INTO `t_td_colviewitem` VALUES ('60004', '4', '6', 'char08', '分析负责人', '', '0', '1', '陈泉,张世永,蒋健峰,邹文阳,刘高安', '1');
INSERT INTO `t_td_colviewitem` VALUES ('60005', '5', '6', 'char02', '依赖类型', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('60006', '6', '6', 'char03', '依赖包', '', '0', '1', 'com.ygsoft.grm.fmisapp.api,com.ygsoft.grm.fmisbilldj,com.ygsoft.grm.fmiscommon,com.ygsoft.grm.fmisdal,com.ygsoft.grm.fmiszw,com.ygsoft.grm.ygfmisbasebp,com.ygsoft.grm.ygfmisbcinput,com.ygsoft.grm.ygfmisfuncs,com.ygsoft.grm.ygfmisgldx,com.ygsoft.grm.ygfmispc,com.ygsoft.grm.ygfmispcaddin,com.ygsoft.grm.ygfmispcehtml,com.ygsoft.grm.ygfmisworkflow,com.ygsoft.grm.zhcx.impl,com.ygsoft.gap.ims.impl', '1');
INSERT INTO `t_td_colviewitem` VALUES ('60007', '7', '6', 'char04', '被依赖包', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('60008', '8', '6', 'char05', '整改项目组', '', '0', '1', '工程项目项目组,智能物资项目组,数据库组,预算多维编制项目组,产权管理项目组,资金监控项目组,支付结算项目组,总账项目组,投融资项目组,报表项目组,移动业务项目组,ECP平台开发部/技术支持组,YG ECM 项目组', '1');
INSERT INTO `t_td_colviewitem` VALUES ('60009', '9', '6', 'char07', '依赖包对应组件', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('60010', '10', '6', 'char06', '整改人', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('60011', '11', '6', 'long_char01', '处理意见', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('70001', '1', '7', 'char01', '包名', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('70002', '2', '7', 'char02', '所属项目组', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('70003', '3', '7', 'char03', '功能说明', '', '0', '0', '', '0');
INSERT INTO `t_td_colviewitem` VALUES ('70004', '4', '7', 'char04', '提交人', '', '0', '0', '', '0');
