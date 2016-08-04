package com.owngame.service.impl;

import com.owngame.dao.GameStatsDao;
import com.owngame.entity.GameStats;
import com.owngame.service.GameStatsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/7/29.
 * GameStats
 * 暴露给使用者的接口
 */
@Service
public class GameStatsServiceImpl implements GameStatsService {

    @Autowired
    private GameStatsDao gameStatsDao;

    public GameStats getGameStats(long id) {
        GameStats gameStats = gameStatsDao.queryById(id);
        return gameStats;
    }

    public long createGameStats(GameStats gameStats) {
        return gameStatsDao.insert(gameStats);
    }

    public int updateGameStats(GameStats gameStats) {
        return gameStatsDao.update(gameStats);
    }

    public int deleteGameStats(long id) {
        return gameStatsDao.delete(id);
    }
}
