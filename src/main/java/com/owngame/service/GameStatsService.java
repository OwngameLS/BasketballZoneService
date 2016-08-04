package com.owngame.service;

import com.owngame.entity.GameStats;

/**
 * Created by Administrator on 2016/7/29.
 * 比赛数据统计操作服务
 */
public interface GameStatsService {
    /**
     * 获得比赛数据统计
     *
     * @param id 数据统计id
     * @return 数据统计对象
     */
    GameStats getGameStats(long id);

    /**
     * 新增一条比赛数据统计
     *
     * @param gameStats 数据统计对象
     * @return 插入成功后返回该条记录的id
     */
    long createGameStats(GameStats gameStats);

    /**
     * 更新某条比赛数据统计记录
     *
     * @param gameStats 数据统计对象
     * @return 是否成功
     */
    int updateGameStats(GameStats gameStats);

    /**
     * 删除某条比赛记录
     *
     * @param id 数据统计的id
     * @return 是否成功
     */
    int deleteGameStats(long id);
}
