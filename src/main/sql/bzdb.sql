/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : bzdb

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-07-22 11:50:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `gameinfos`
-- ----------------------------
DROP TABLE IF EXISTS `gameinfos`;
CREATE TABLE `gameinfos` (
  `Id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `CountType` char(1) DEFAULT NULL COMMENT '比赛类型（T/S）',
  `GameType` char(1) DEFAULT NULL COMMENT '比赛类型（F/U/C）友谊赛friend，联赛Union，杯赛（Cup）',
  `UnionId` char(10) DEFAULT NULL COMMENT '比赛所属联赛Id，当为某个联赛（或杯赛）的比赛，填写其Id',
  `Desc` text COMMENT '比赛描述，简介',
  `GameTime` datetime DEFAULT NULL COMMENT '比赛时间',
  `IsMOT` char(1) DEFAULT NULL COMMENT '是否多个OverTime(y/n)，多个OT则在OT字段会是组合数据统计',
  `TeamIdHome` char(10) DEFAULT NULL COMMENT '参赛主队Id',
  `TeamIdGuest` char(10) DEFAULT NULL COMMENT '参赛客队Id',
  `TeamStatIdHome` bigint(20) DEFAULT NULL COMMENT '主队该场比赛数据统计条目Id',
  `TeamStatIdGuest` bigint(20) DEFAULT NULL COMMENT '客队该场比赛数据统计条目Id',
  `PlayerStatIdsHome` text COMMENT '主队球员该场比赛数据统计条目Ids',
  `PlayerStatIdsGuest` text COMMENT '客队球员该场比赛数据统计条目Ids',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gameinfos
-- ----------------------------

-- ----------------------------
-- Table structure for `gamestats`
-- ----------------------------
DROP TABLE IF EXISTS `gamestats`;
CREATE TABLE `gamestats` (
  `Id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `GameId` bigint(10) DEFAULT NULL COMMENT '所属比赛的Id',
  `IsMOT` char(1) DEFAULT NULL COMMENT '是否为多个加时赛 y/n',
  `FGA` smallint(6) DEFAULT NULL COMMENT '出手次数',
  `FGM` smallint(6) DEFAULT NULL COMMENT '命中次数',
  `FG` float DEFAULT NULL COMMENT '命中率',
  `3PA` smallint(6) DEFAULT NULL COMMENT '3分球出手次数',
  `3PM` smallint(6) DEFAULT NULL COMMENT '3分球命中次数',
  `3FG` float DEFAULT NULL COMMENT '3分球命中率',
  `2PA` smallint(6) DEFAULT NULL COMMENT '2分球出手次数',
  `2PM` smallint(6) DEFAULT NULL COMMENT '2分球命中次数',
  `2FG` float DEFAULT NULL COMMENT '2分球命中率',
  `1PA` smallint(6) DEFAULT NULL COMMENT '1分球出手次数',
  `1PM` smallint(6) DEFAULT NULL COMMENT '1分球命中次数',
  `1FG` float DEFAULT NULL COMMENT '1分球命中率',
  `REBS` smallint(6) DEFAULT NULL COMMENT '篮板球',
  `OREBS` smallint(6) DEFAULT NULL COMMENT '进攻篮板',
  `BLKS` smallint(6) DEFAULT NULL COMMENT '盖帽',
  `FOULS` smallint(6) DEFAULT NULL COMMENT '犯规',
  `OFOULS` smallint(6) DEFAULT NULL COMMENT '进攻犯规',
  `STLS` smallint(6) DEFAULT NULL COMMENT '抢断',
  `ASTS` smallint(6) DEFAULT NULL COMMENT '助攻',
  `TOS` smallint(6) DEFAULT NULL COMMENT '失误',
  `1STScore` smallint(6) DEFAULT NULL COMMENT '第1节得分',
  `2NDScore` smallint(6) DEFAULT NULL COMMENT '第2节得分',
  `3RDScore` smallint(6) DEFAULT NULL COMMENT '第3节得分',
  `4THScore` smallint(6) DEFAULT NULL COMMENT '第4节得分',
  `OTScore` smallint(6) DEFAULT NULL COMMENT '加时赛得分',
  `TotalScore` smallint(6) DEFAULT NULL COMMENT '总得分',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gamestats
-- ----------------------------

-- ----------------------------
-- Table structure for `playerinfos`
-- ----------------------------
DROP TABLE IF EXISTS `playerinfos`;
CREATE TABLE `playerinfos` (
  `Id` bigint(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '球员的唯一标识',
  `CurTeamId` bigint(10) DEFAULT NULL COMMENT '当前所在球队标识（允许一人效力多支球队）',
  `HistoryTeams` text COMMENT '历史效力球队标识',
  `Age` smallint(6) DEFAULT NULL COMMENT '年龄',
  `Birthday` datetime DEFAULT NULL COMMENT '生日',
  `Resume` text COMMENT '简历',
  `Name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `Sex` char(1) DEFAULT NULL COMMENT '性别',
  `JersyNo` varchar(3) DEFAULT NULL COMMENT '球衣号码',
  `Height` smallint(6) DEFAULT NULL COMMENT '身高',
  `Weight` smallint(6) DEFAULT NULL COMMENT '体重',
  `Armspan` smallint(6) DEFAULT NULL COMMENT '臂展',
  `Position` char(2) DEFAULT NULL COMMENT '位置',
  `Games` smallint(6) DEFAULT NULL COMMENT '参加的比赛次数',
  `MVP` smallint(6) DEFAULT NULL COMMENT '全场最佳次数',
  `Prides` text COMMENT '荣誉',
  `StatId` bigint(20) DEFAULT NULL COMMENT '在TotalStat表中球员累计技术统计Id',
  `IconImg` text COMMENT '球员Icon图片的名称',
  `Grade` char(1) DEFAULT NULL COMMENT '球员等级（社区）',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of playerinfos
-- ----------------------------

-- ----------------------------
-- Table structure for `teaminfos`
-- ----------------------------
DROP TABLE IF EXISTS `teaminfos`;
CREATE TABLE `teaminfos` (
  `Id` bigint(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '球队的唯一标识',
  `Name` varchar(20) DEFAULT NULL COMMENT '球队名称',
  `Desc` text COMMENT '球队简述',
  `Prides` text COMMENT '球队荣誉',
  `GameCount` int(11) DEFAULT NULL COMMENT '比赛数量',
  `WinCount` int(11) DEFAULT NULL COMMENT '获胜次数',
  `StatId` bigint(20) DEFAULT NULL COMMENT '在TotalStat表中球队综合数据统计Id',
  `PTId` char(10) DEFAULT '' COMMENT '父球队Id',
  `IconImg` text COMMENT '球队Icon图片的名称',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teaminfos
-- ----------------------------

-- ----------------------------
-- Table structure for `totalstats`
-- ----------------------------
DROP TABLE IF EXISTS `totalstats`;
CREATE TABLE `totalstats` (
  `Id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `FGA` bigint(11) DEFAULT NULL COMMENT '总出手次数',
  `FGM` bigint(11) DEFAULT NULL COMMENT '总命中次数',
  `FG` float DEFAULT NULL COMMENT '总命中率',
  `3PA` bigint(11) DEFAULT NULL COMMENT '总3分球出手次数',
  `3PM` bigint(11) DEFAULT NULL COMMENT '总3分球命中次数',
  `3PG` float DEFAULT NULL COMMENT '3分球命中率',
  `2PA` bigint(11) DEFAULT NULL COMMENT '总2分球出手次数',
  `2PM` bigint(11) DEFAULT NULL COMMENT '总2分球命中次数',
  `2PG` float DEFAULT NULL COMMENT '2分球命中率',
  `1PA` bigint(11) DEFAULT NULL COMMENT '总1分球出手次数',
  `1PM` bigint(11) DEFAULT NULL COMMENT '总1分球命中次数',
  `1PG` float DEFAULT NULL COMMENT '1分球命中率',
  `REBS` bigint(20) DEFAULT NULL COMMENT '篮板球',
  `OREBS` bigint(20) DEFAULT NULL COMMENT '进攻篮板',
  `BLKS` bigint(20) DEFAULT NULL COMMENT '盖帽',
  `FOULS` bigint(20) DEFAULT NULL COMMENT '犯规',
  `OFOULS` bigint(20) DEFAULT NULL COMMENT '进攻犯规',
  `STLS` bigint(20) DEFAULT NULL COMMENT '抢断',
  `ASTS` bigint(20) DEFAULT NULL COMMENT '助攻',
  `TOS` bigint(20) DEFAULT NULL COMMENT '失误',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of totalstats
-- ----------------------------
