/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : bzdb

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-07-26 22:45:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gameinfos
-- ----------------------------
DROP TABLE IF EXISTS `gameinfos`;
CREATE TABLE `gameinfos` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `count_type` char(1) DEFAULT NULL COMMENT '比赛类型（T/S）',
  `game_type` char(1) DEFAULT NULL COMMENT '比赛类型（F/U/C）友谊赛friend，联赛Union，杯赛（Cup）',
  `union_id` bigint(10) DEFAULT NULL COMMENT '比赛所属联赛Id，当为某个联赛（或杯赛）的比赛，填写其Id',
  `description` text COMMENT '比赛描述，简介',
  `gametime` datetime DEFAULT NULL COMMENT '比赛时间',
  `ismot` char(1) DEFAULT NULL COMMENT '是否多个OverTime(y/n)，多个OT则在OT字段会是组合数据统计',
  `teamid_home` bigint(10) DEFAULT NULL COMMENT '参赛主队Id',
  `teamid_guest` bigint(10) DEFAULT NULL COMMENT '参赛客队Id',
  `team_statid_home` bigint(20) DEFAULT NULL COMMENT '主队该场比赛数据统计条目Id',
  `team_statid_guest` bigint(20) DEFAULT NULL COMMENT '客队该场比赛数据统计条目Id',
  `player_statids_home` text COMMENT '主队球员该场比赛数据统计条目Ids',
  `player_statIds_guest` text COMMENT '客队球员该场比赛数据统计条目Ids',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gamestats
-- ----------------------------
DROP TABLE IF EXISTS `gamestats`;
CREATE TABLE `gamestats` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `gameid` bigint(10) DEFAULT NULL COMMENT '所属比赛的Id',
  `ismot` char(1) DEFAULT NULL COMMENT '是否为多个加时赛 y/n',
  `fpa` smallint(6) DEFAULT NULL COMMENT '出手次数',
  `fgm` smallint(6) DEFAULT NULL COMMENT '命中次数',
  `fg` float DEFAULT NULL COMMENT '命中率',
  `_3pa` smallint(6) DEFAULT NULL COMMENT '3分球出手次数',
  `_3pm` smallint(6) DEFAULT NULL COMMENT '3分球命中次数',
  `_3fg` float DEFAULT NULL COMMENT '3分球命中率',
  `_2pa` smallint(6) DEFAULT NULL COMMENT '2分球出手次数',
  `_2pm` smallint(6) DEFAULT NULL COMMENT '2分球命中次数',
  `_2fg` float DEFAULT NULL COMMENT '2分球命中率',
  `_1pa` smallint(6) DEFAULT NULL COMMENT '1分球出手次数',
  `_1pm` smallint(6) DEFAULT NULL COMMENT '1分球命中次数',
  `_1fg` float DEFAULT NULL COMMENT '1分球命中率',
  `rebs` smallint(6) DEFAULT NULL COMMENT '篮板球',
  `orebs` smallint(6) DEFAULT NULL COMMENT '进攻篮板',
  `blks` smallint(6) DEFAULT NULL COMMENT '盖帽',
  `fouls` smallint(6) DEFAULT NULL COMMENT '犯规',
  `ofouls` smallint(6) DEFAULT NULL COMMENT '进攻犯规',
  `stls` smallint(6) DEFAULT NULL COMMENT '抢断',
  `asts` smallint(6) DEFAULT NULL COMMENT '助攻',
  `tos` smallint(6) DEFAULT NULL COMMENT '失误',
  `_1stScore` smallint(6) DEFAULT NULL COMMENT '第1节得分',
  `_2nd_score` smallint(6) DEFAULT NULL COMMENT '第2节得分',
  `_3rd_score` smallint(6) DEFAULT NULL COMMENT '第3节得分',
  `_4th_score` smallint(6) DEFAULT NULL COMMENT '第4节得分',
  `ot_score` smallint(6) DEFAULT NULL COMMENT '加时赛得分',
  `total_score` smallint(6) DEFAULT NULL COMMENT '总得分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for playerinfos
-- ----------------------------
DROP TABLE IF EXISTS `playerinfos`;
CREATE TABLE `playerinfos` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '球员的唯一标识',
  `curTeamid` bigint(10) DEFAULT NULL COMMENT '当前所在球队标识（允许一人效力多支球队）',
  `historyTeams` text COMMENT '历史效力球队标识',
  `age` smallint(6) DEFAULT NULL COMMENT '年龄',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `resume` text COMMENT '简历',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `sex` char(1) NOT NULL DEFAULT 'm' COMMENT '性别',
  `jersyno` varchar(3) DEFAULT NULL COMMENT '球衣号码',
  `height` float(6,0) DEFAULT NULL COMMENT '身高',
  `weight` float(6,0) DEFAULT NULL COMMENT '体重',
  `armspan` float(6,0) DEFAULT NULL COMMENT '臂展',
  `position` char(2) DEFAULT NULL COMMENT '位置',
  `games` smallint(6) DEFAULT NULL COMMENT '参加的比赛次数',
  `mvp` smallint(6) DEFAULT NULL COMMENT '全场最佳次数',
  `prides` text COMMENT '荣誉',
  `statid` bigint(20) DEFAULT NULL COMMENT '在TotalStat表中球员累计技术统计Id',
  `iconimg` text COMMENT '球员Icon图片的名称',
  `grade` char(1) DEFAULT NULL COMMENT '球员等级（社区）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teaminfos
-- ----------------------------
DROP TABLE IF EXISTS `teaminfos`;
CREATE TABLE `teaminfos` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '球队的唯一标识',
  `name` varchar(20) DEFAULT NULL COMMENT '球队名称',
  `description` text COMMENT '球队简述',
  `prides` text COMMENT '球队荣誉',
  `gamecount` int(11) DEFAULT NULL COMMENT '比赛数量',
  `wincount` int(11) DEFAULT NULL COMMENT '获胜次数',
  `statid` bigint(20) DEFAULT NULL COMMENT '在TotalStat表中球队综合数据统计Id',
  `ptid` char(10) DEFAULT '' COMMENT '父球队Id parent team id',
  `iconimg` text COMMENT '球队Icon图片的名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for totalstats
-- ----------------------------
DROP TABLE IF EXISTS `totalstats`;
CREATE TABLE `totalstats` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `fga` bigint(11) DEFAULT NULL COMMENT '总出手次数',
  `fgm` bigint(11) DEFAULT NULL COMMENT '总命中次数',
  `fg` float DEFAULT NULL COMMENT '总命中率',
  `_3pa` bigint(11) DEFAULT NULL COMMENT '总3分球出手次数',
  `_3pm` bigint(11) DEFAULT NULL COMMENT '总3分球命中次数',
  `_3fg` float DEFAULT NULL COMMENT '3分球命中率',
  `_2pa` bigint(11) DEFAULT NULL COMMENT '总2分球出手次数',
  `_2pm` bigint(11) DEFAULT NULL COMMENT '总2分球命中次数',
  `_2fg` float DEFAULT NULL COMMENT '2分球命中率',
  `_1pa` bigint(11) DEFAULT NULL COMMENT '总1分球出手次数',
  `_1pm` bigint(11) DEFAULT NULL COMMENT '总1分球命中次数',
  `_1fg` float DEFAULT NULL COMMENT '1分球命中率',
  `rebs` bigint(20) DEFAULT NULL COMMENT '篮板球',
  `orebs` bigint(20) DEFAULT NULL COMMENT '进攻篮板',
  `blks` bigint(20) DEFAULT NULL COMMENT '盖帽',
  `fouls` bigint(20) DEFAULT NULL COMMENT '犯规',
  `ofouls` bigint(20) DEFAULT NULL COMMENT '进攻犯规',
  `stls` bigint(20) DEFAULT NULL COMMENT '抢断',
  `asts` bigint(20) DEFAULT NULL COMMENT '助攻',
  `tos` bigint(20) DEFAULT NULL COMMENT '失误',
  `totalscore` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
