package com.owngame.dao;

import com.owngame.entity.GameInfos;

/**
 * Created by Administrator on 2016-7-25.
 */
public interface GameInfosDao {
    /**
     * 通过比赛Id号查询比赛信息
     * @param id
     * @return
     */
    GameInfos queryById(long id);

    /**
     * 插入比赛信息
     * @param gameInfos
     * @return
     */
    int insert(GameInfos gameInfos);
}
