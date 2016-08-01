package com.owngame.service.impl;

import com.owngame.dao.GameStatsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/8/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class GameStatsServiceImplTest {
    @Resource
    GameStatsDao gameStatsDao;
    @Autowired
    GameStatsServiceImpl gameStatsService;

    @Test
    public void getGameStats() throws Exception {

    }

    @Test
    public void createGameStats() throws Exception {

    }

    @Test
    public void updateGameStats() throws Exception {

    }

    @Test
    public void deleteGameStats() throws Exception {

    }

}