package com.owngame.service.impl;

import com.owngame.dao.GameStatsDao;
import com.owngame.dao.PlayerInfosDao;
import com.owngame.dao.TotalStatsDao;
import com.owngame.dto.PlayerInfosFullExposer;
import com.owngame.entity.GameStats;
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
    @Autowired
    private GameStatsDao gameStatsDao;


    /**
     * 获得球员的所有信息（基本信息和技术统计）
     * @param id 球员的id
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
     * @param statid 技术统计id
     * @return
     */
    public TotalStats getTotalStats(long statid) {
        return totalStatsDao.queryById(statid);
    }

    /**
     * 更新生涯数据
     * 某一场比赛的数据为复杂对象
     * @param totalStatid 生涯数据的id
     * @param gameStats 某一场比赛的数据
     * @return 更新结果
     */
    public int setPlayerTotalStats(long totalStatid, GameStats gameStats){
        // 1.先读取totalStats
        TotalStats totalStats = totalStatsDao.queryById(totalStatid);
        if(totalStats == null){
            // 第一次创建该生涯数据，先向数据库插入一条记录
            totalStats = new TotalStats();
            long id = totalStatsDao.insert(totalStats);
            totalStats.setId(id);
        }
        totalStats = updateTotalStats(totalStats, gameStats);
        // 2.对应更新
        return totalStatsDao.update(totalStats);
    }

    /**
     * 更新生涯数据
     * 某一场比赛的数据为已经存储进数据库的信息
     * @param totalStatid 生涯数据的id
     * @param gameStatid 某一场比赛的数据id
     * @return 更新结果
     */

    public int setPlayerTotalStats(long totalStatid, long gameStatid){
        // 1.先根据gameStatid读取到比赛信息
        GameStats gameStats = gameStatsDao.queryById(gameStatid);
        // 2.更新逻辑
        return setPlayerTotalStats(totalStatid, gameStats);
    }

    /**
     * 具体更新生涯数据的逻辑
     * @param totalStats 生涯数据对象
     * @param gameStats 某一场比赛的数据对象
     * @return 生涯数据对象
     */
    private TotalStats updateTotalStats(TotalStats totalStats, GameStats gameStats){
        totalStats.setFga(totalStats.getFga() + gameStats.getFga());
        totalStats.setFgm(totalStats.getFgm() + gameStats.getFgm());
        totalStats.setFg((float)(totalStats.getFgm()/totalStats.getFgm()));
        totalStats.set_3pa(totalStats.get_3pa() + gameStats.get_3pa());
        totalStats.set_3pm(totalStats.get_3pm() + gameStats.get_3pm());
        totalStats.set_3fg((float)(totalStats.get_3pm())/totalStats.get_3pm());
        totalStats.set_2pa(totalStats.get_2pa() + gameStats.get_2pa());
        totalStats.set_2pa(totalStats.get_2pa() + gameStats.get_2pa());
        totalStats.set_2fg((float)(totalStats.get_2pm())/totalStats.get_2pm());
        totalStats.set_1pa(totalStats.get_1pa() + gameStats.get_1pa());
        totalStats.set_1pa(totalStats.get_1pa() + gameStats.get_1pa());
        totalStats.set_1fg((float)(totalStats.get_1pm())/totalStats.get_1pm());
        totalStats.setRebs(totalStats.getRebs() + gameStats.getRebs());
        totalStats.setOrebs(totalStats.getOrebs() + gameStats.getOrebs());
        totalStats.setBlks(totalStats.getBlks() + gameStats.getBlks());
        totalStats.setFouls(totalStats.getFouls() + gameStats.getFouls());
        totalStats.setOfouls(totalStats.getOfouls() + gameStats.getOfouls());
        totalStats.setStls(totalStats.getStls() + gameStats.getStls());
        totalStats.setAsts(totalStats.getAsts() + gameStats.getAsts());
        totalStats.setTos(totalStats.getTos() + gameStats.getTos());
        totalStats.setTotalScore(totalStats.getTotalScore() + gameStats.getTotalScore());
        return totalStats;
    }
}
