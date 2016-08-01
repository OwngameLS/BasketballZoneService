package com.owngame.service.impl;

import com.owngame.dao.GameInfosDao;
import com.owngame.dao.GameStatsDao;
import com.owngame.dto.GameInfosFullExposer;
import com.owngame.entity.GameInfos;
import com.owngame.entity.GameStats;
import com.owngame.service.GameInfosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 */
@Service
public class GameInfosServiceImpl implements GameInfosService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private GameStatsDao gameStatsDao;
    @Autowired
    private GameInfosDao gameInfosDao;

    public GameInfos getGameInfos(long id) {
        return gameInfosDao.queryById(id);
    }

    public GameInfosFullExposer getGameInofsFull(long id) {
        // 先拿到基础信息
        GameInfos gameInfos = gameInfosDao.queryById(id);
        // 根据基础信息进行初始化
        return initGameStatsOfGameInfos(gameInfos);
    }

    // 初始化技术统计信息已实现完整的比赛信息
    private GameInfosFullExposer initGameStatsOfGameInfos(GameInfos gameInfos){
        GameInfosFullExposer gameInfosFullExposer = new GameInfosFullExposer();
        gameInfosFullExposer.setGameInfos(gameInfos);
        String ids = gameInfos.getTeamidHome() + "," + gameInfos.getPlayerStatIdsHome();
        gameInfosFullExposer.setHomeTeamStats(queryStats(ids));
        ids = gameInfos.getTeamidGuest() + "," + gameInfos.getPlayerStatIdsGuest();
        gameInfosFullExposer.setGuestTeamStats(queryStats(ids));
        return gameInfosFullExposer;
    }

    private List queryStats(String idsString){
        ArrayList<GameStats> gameStatses = new ArrayList<GameStats>();
        // 将数组字符串转换成long数组
        long[] ids = parseLongString(idsString);
        for(int i=0;i<ids.length;i++){
            if(ids[i] != 0) {//得到合理的id才去查询
                gameStatses.add(gameStatsDao.queryById(ids[i]));
            }
        }
        return gameStatses;
    }

    // 将long型的字符串数组改成long型数组
    private long[] parseLongString(String longStr){
        String[] str = longStr.split(",");
        int length = str.length;
        long[] ids = new long[length];
        for(int i=0;i<length;i++){
            long temp = -1;
            try {
                temp = Long.parseLong(str[i]);
            }catch (NumberFormatException e){
                continue;
            }
            ids[i] = temp;
        }
        return ids;
    }
}
