package com.owngame.service.impl;

import com.owngame.dao.GameStatsDao;
import com.owngame.dto.PlayerInfosFullExposer;
import com.owngame.entity.GameStats;
import com.owngame.entity.TotalStats;
import com.owngame.service.PlayerInfosService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/7/28.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class PlayerInfosServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    GameStatsDao gameStatsDao;

    @Autowired
    PlayerInfosService playerInfosService;

    @Test
    public void getPlayerInfosFullById() throws Exception {
        PlayerInfosFullExposer playerInfosFullExposer = playerInfosService.getPlayerInfosFullById(1);
        logger.info("playerInfosFullExposer={}", playerInfosFullExposer);

    }

    @Test
    public void getTotalStats() throws Exception {
        TotalStats totalStats = playerInfosService.getTotalStats(1);
        logger.info("totalStats={}", totalStats);
    }

    @Test
    public void setPlayerTotalStatsWithGameStats() throws Exception {
        GameStats gameStats = gameStatsDao.queryById(1);
        gameStats.setBlks(5);
        logger.info("gameStats={}", gameStats);
        playerInfosService.setPlayerTotalStatsWithGameStats(-1, gameStats);
    }

    @Test
    public void setPlayerTotalStatsWithGameStats1() throws Exception {

    }

}