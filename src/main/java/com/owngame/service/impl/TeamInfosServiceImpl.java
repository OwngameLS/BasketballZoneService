package com.owngame.service.impl;

import com.owngame.dao.PlayerInfosDao;
import com.owngame.dao.TeamInfosDao;
import com.owngame.dao.TotalStatsDao;
import com.owngame.dto.TeamInfosFullExposer;
import com.owngame.entity.TeamInfos;
import com.owngame.service.TeamInfosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/7/31.
 */
@Service
public class TeamInfosServiceImpl implements TeamInfosService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TeamInfosDao teamInfosDao;
    @Autowired
    private TotalStatsDao totalStatsDao;

    public TeamInfos queryById(long id) {
        return teamInfosDao.queryById(id);
    }

    public TeamInfosFullExposer queryFullById(long id){
        TeamInfosFullExposer teamInfosFullExposer = new TeamInfosFullExposer();
        teamInfosFullExposer.setTeamInfos(teamInfosDao.queryById(id));
        teamInfosFullExposer.setTotalStats(totalStatsDao.queryById(teamInfosFullExposer.getTeamInfos().getStatid()));
        return teamInfosFullExposer;
    }

    public int insert(TeamInfos teamInfos) {
        return teamInfosDao.insert(teamInfos);
    }

    public int update(TeamInfos teamInfos) {
        return teamInfosDao.update(teamInfos);
    }

    public int delete(long id) {
        return teamInfosDao.delete(id);
    }
}
