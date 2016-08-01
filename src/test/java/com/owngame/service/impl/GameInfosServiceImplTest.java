package com.owngame.service.impl;

import com.owngame.dao.GameInfosDao;
import com.owngame.dto.GameInfosFullExposer;
import com.owngame.entity.GameInfos;
import com.owngame.service.GameInfosService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016-8-1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class GameInfosServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    GameInfosDao gameInfosDao;
    @Autowired
    GameInfosService gameInfosService;

    @Test
    public void getGameInfos() throws Exception {
        GameInfos gameInfos = gameInfosService.getGameInfos(1);
        logger.info("gameInfos={}", gameInfos);
    }

    @Test
    public void getGameInofsFull() throws Exception {
        GameInfosFullExposer gameInfosFullExposer = gameInfosService.getGameInofsFull(1);
        logger.info("gameInfosFullExposer={}", gameInfosFullExposer);
    }

}