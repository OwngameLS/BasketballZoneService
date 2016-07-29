/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : bzdb

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-07-29 09:45:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `gameinfos`
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
-- Records of gameinfos
-- ----------------------------

-- ----------------------------
-- Table structure for `gamestats`
-- ----------------------------
DROP TABLE IF EXISTS `gamestats`;
CREATE TABLE `gamestats` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `gameid` bigint(10) DEFAULT NULL COMMENT '所属比赛的Id',
  `ismot` char(1) DEFAULT NULL COMMENT '是否为多个加时赛 y/n',
  `fga` smallint(6) DEFAULT '0' COMMENT '出手次数',
  `fgm` smallint(6) DEFAULT '0' COMMENT '命中次数',
  `fg` float(4,2) DEFAULT '0.00' COMMENT '命中率',
  `pa3` smallint(6) DEFAULT '0' COMMENT '3分球出手次数',
  `pm3` smallint(6) DEFAULT '0' COMMENT '3分球命中次数',
  `fg3` float(4,2) DEFAULT '0.00' COMMENT '3分球命中率',
  `pa2` smallint(6) DEFAULT '0' COMMENT '2分球出手次数',
  `pm2` smallint(6) DEFAULT '0' COMMENT '2分球命中次数',
  `fg2` float(4,2) DEFAULT '0.00' COMMENT '2分球命中率',
  `pa1` smallint(6) DEFAULT '0' COMMENT '1分球出手次数',
  `pm1` smallint(6) DEFAULT '0' COMMENT '1分球命中次数',
  `fg1` float(4,2) DEFAULT '0.00' COMMENT '1分球命中率',
  `rebs` smallint(6) DEFAULT '0' COMMENT '篮板球',
  `orebs` smallint(6) DEFAULT '0' COMMENT '进攻篮板',
  `blks` smallint(6) DEFAULT '0' COMMENT '盖帽',
  `fouls` smallint(6) DEFAULT '0' COMMENT '犯规',
  `ofouls` smallint(6) DEFAULT '0' COMMENT '进攻犯规',
  `stls` smallint(6) DEFAULT '0' COMMENT '抢断',
  `asts` smallint(6) DEFAULT '0' COMMENT '助攻',
  `tos` smallint(6) DEFAULT '0' COMMENT '失误',
  `score1st` smallint(6) DEFAULT '0' COMMENT '第1节得分',
  `score2nd` smallint(6) DEFAULT '0' COMMENT '第2节得分',
  `score3rd` smallint(6) DEFAULT '0' COMMENT '第3节得分',
  `score4th` smallint(6) DEFAULT '0' COMMENT '第4节得分',
  `score_ot` smallint(6) DEFAULT '0' COMMENT '加时赛得分',
  `total_score` smallint(6) DEFAULT '0' COMMENT '总得分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gamestats
-- ----------------------------
INSERT INTO `gamestats` VALUES ('1', '1', 'N', '15', '10', '66.67', '5', '2', '40.00', '5', '4', '80.00', '5', '4', '80.00', '5', '1', '3', '4', '1', '1', '5', '0', '5', '5', '4', '4', '0', '18');

-- ----------------------------
-- Table structure for `playerinfos`
-- ----------------------------
DROP TABLE IF EXISTS `playerinfos`;
CREATE TABLE `playerinfos` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '球员的唯一标识',
  `cur_teamid` bigint(10) DEFAULT NULL COMMENT '当前所在球队标识（允许一人效力多支球队）',
  `history_teams` text COMMENT '历史效力球队标识',
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
-- Records of playerinfos
-- ----------------------------

-- ----------------------------
-- Table structure for `teaminfos`
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
-- Records of teaminfos
-- ----------------------------

-- ----------------------------
-- Table structure for `totalstats`
-- ----------------------------
DROP TABLE IF EXISTS `totalstats`;
CREATE TABLE `totalstats` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `fga` bigint(11) DEFAULT '0' COMMENT '总出手次数',
  `fgm` bigint(11) DEFAULT '0' COMMENT '总命中次数',
  `fg` float(4,2) DEFAULT '0.00' COMMENT '总命中率',
  `pa3` bigint(11) DEFAULT '0' COMMENT '总3分球出手次数',
  `pm3` bigint(11) DEFAULT '0' COMMENT '总3分球命中次数',
  `fg3` float(4,2) DEFAULT '0.00' COMMENT '3分球命中率',
  `pa2` bigint(11) DEFAULT '0' COMMENT '总2分球出手次数',
  `pm2` bigint(11) DEFAULT '0' COMMENT '总2分球命中次数',
  `fg2` float(4,2) DEFAULT '0.00' COMMENT '2分球命中率',
  `pa1` bigint(11) DEFAULT '0' COMMENT '总1分球出手次数',
  `pm1` bigint(11) DEFAULT '0' COMMENT '总1分球命中次数',
  `fg1` float(4,2) DEFAULT '0.00' COMMENT '1分球命中率',
  `rebs` bigint(20) DEFAULT '0' COMMENT '篮板球',
  `orebs` bigint(20) DEFAULT '0' COMMENT '进攻篮板',
  `blks` bigint(20) DEFAULT '0' COMMENT '盖帽',
  `fouls` bigint(20) DEFAULT '0' COMMENT '犯规',
  `ofouls` bigint(20) DEFAULT '0' COMMENT '进攻犯规',
  `stls` bigint(20) DEFAULT '0' COMMENT '抢断',
  `asts` bigint(20) DEFAULT '0' COMMENT '助攻',
  `tos` bigint(20) DEFAULT '0' COMMENT '失误',
  `total_score` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of totalstats
-- ----------------------------
INSERT INTO `totalstats` VALUES ('1', '5', '3', '60.00', '5', '3', '60.00', '0', '0', '0.00', '0', '0', '0.00', '10', '8', '2', '3', '1', '2', '5', '0', '15');
