package com.owngame.dao;

import com.owngame.entity.PlayerInfos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/7/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class PlayerinfosDaoTest {
    @Resource
    private PlayerInfosDao playerinfosDao;

    @Test
    public void queryById() throws Exception {
        PlayerInfos playerinfos = playerinfosDao.queryById(1);
    }

    @Test
    public void addPlayerinfos() throws Exception {

    }

}