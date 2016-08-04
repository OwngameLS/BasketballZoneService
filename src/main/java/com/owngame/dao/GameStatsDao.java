package com.owngame.dao;

import com.owngame.entity.GameStats;

/**
 * Created by Administrator on 2016-7-26.
 */
public interface GameStatsDao {
    GameStats queryById(long id);

    int insert(GameStats gameStats);

    int update(GameStats gameStats);

    int delete(long id);
}
