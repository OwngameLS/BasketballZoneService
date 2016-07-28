package com.owngame.service.impl;

import com.owngame.dao.PlayerInfosDao;
import com.owngame.dao.TotalStatsDao;
import com.owngame.dto.PlayerInfosFullExposer;
import com.owngame.entity.TotalStats;
import com.owngame.service.PlayerInfosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2016-7-28.
 */
@Service
public class PlayerInfosServiceImpl implements PlayerInfosService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PlayerInfosDao playerInfosDao;
    @Autowired
    private TotalStatsDao totalStatsDao;

    /**
     * 获得球员的所有信息（基本信息和技术统计）
     * @param id
     * @return
     */
    public PlayerInfosFullExposer getPlayerInfosFullById(long id) {
        PlayerInfosFullExposer playerInfosFullExposer = new PlayerInfosFullExposer();
        playerInfosFullExposer.setPlayerBasicInfos(playerInfosDao.queryById(id));
        playerInfosFullExposer.setPlayerCareerStats(getTotalStats(playerInfosFullExposer.getPlayerBasicInfos().getStatid()));
        return playerInfosFullExposer;
    }

    /**
     * 获得球员的技术统计信息
     * @param statid
     * @return
     */
    public TotalStats getTotalStats(long statid) {
        return totalStatsDao.queryById(statid);
    }
}
