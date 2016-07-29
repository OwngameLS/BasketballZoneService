package com.owngame.service;

import com.owngame.dto.PlayerInfosFullExposer;
import com.owngame.entity.GameStats;
import com.owngame.entity.TotalStats;

/**
 * Created by Administrator on 2016-7-28.
 *
 * 球员信息操作服务类
 */
public interface PlayerInfosService {
    /**
     * 查询某一个球员的所有信息
     * @param id
     * @return
     */
    PlayerInfosFullExposer getPlayerInfosFullById(long id);

    /**
     * 查询某一个球员的生涯技术统计
     * @param statid
     * @return
     */
    TotalStats getTotalStats(long statid);
    /**
     * 更新或创建生涯数据
     * 某一场比赛的数据为已经存储进数据库的信息
     * @param totalStatid 生涯数据的id
     * @param gameStatid 某一场比赛的数据id
     * @return 更新结果
     */
    public int setPlayerTotalStatsWithGameStats(long totalStatid, long gameStatid);
    /**
     * 更新或创建生涯数据
     * 某一场比赛的数据为复杂对象
     * @param totalStatid 生涯数据的id
     * @param gameStats 某一场比赛的数据
     * @return 更新结果
     */
    public int setPlayerTotalStatsWithGameStats(long totalStatid, GameStats gameStats);

}
