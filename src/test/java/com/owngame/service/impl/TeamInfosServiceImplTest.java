package com.owngame.service.impl;

import com.owngame.dao.TeamInfosDao;
import com.owngame.dto.TeamInfosFullExposer;
import com.owngame.entity.TeamInfos;
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
 * Created by Administrator on 2016/8/1.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class TeamInfosServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    TeamInfosDao teamInfosDao;

    @Autowired
    TeamInfosServiceImpl teamInfosServiceImpl;

    @Test
    public void queryById() throws Exception {
        TeamInfos teamInfos = teamInfosServiceImpl.queryById(1);
        logger.info("teamInfos={}", teamInfos);
    }

    @Test
    public void queryFullById() throws Exception {
        TeamInfosFullExposer teamInfosFullExposer = teamInfosServiceImpl.queryFullById(1);
        logger.info("teamInfosFullExposer={}", teamInfosFullExposer);
    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

}