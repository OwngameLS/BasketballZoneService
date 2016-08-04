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
 * PlayerInfos 暴露给使用者的接口
 */
@Service
public class PlayerInfosServiceImpl implements PlayerInfosService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PlayerInfosDao playerInfosDao;
    @Autowired
    private TotalStatsDao totalStatsDao;
    @Autowired
    private GameStatsDao gameStatsDao;


    /**
     * 获得球员的所有信息（基本信息和技术统计）
     *
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
     *
     * @param statid 技术统计id
     * @return 技术统计结果
     */
    public TotalStats getTotalStats(long statid) {
        return totalStatsDao.queryById(statid);
    }

    /**
     * 更新生涯数据
     * 某一场比赛的数据为复杂对象
     *
     * @param totalStatid 生涯数据的id
     * @param gameStats   某一场比赛的数据
     * @return 更新结果
     */
    public int setPlayerTotalStatsWithGameStats(long totalStatid, GameStats gameStats) {
        // 1.先读取totalStats
        TotalStats totalStats = totalStatsDao.queryById(totalStatid);
        if (totalStats == null) {
            // 第一次创建该生涯数据，先向数据库插入一条记录
            totalStats = new TotalStats();
            // 根据配置，插入后自动生成的主键id会被赋值到这个对象对应的属性上
            int result = totalStatsDao.insert(totalStats);
            if (result <= 0) {
                return result;
            }
//            System.out.println("totalStats.id:" + totalStats.getId());
        }
        totalStats = updateTotalStatsWithGameStats(totalStats, gameStats);
        // 2.对应更新
        return totalStatsDao.update(totalStats);
    }

    /**
     * 更新生涯数据
     * 某一场比赛的数据为已经存储进数据库的信息
     *
     * @param totalStatid 生涯数据的id
     * @param gameStatid  某一场比赛的数据id
     * @return 更新结果
     */
    public int setPlayerTotalStatsWithGameStats(long totalStatid, long gameStatid) {
        // 1.先根据gameStatid读取到比赛信息
        GameStats gameStats = gameStatsDao.queryById(gameStatid);
        // 2.更新逻辑
        return setPlayerTotalStatsWithGameStats(totalStatid, gameStats);
    }

    /**
     * 具体更新生涯数据的逻辑
     *
     * @param totalStats 生涯数据对象
     * @param gameStats  某一场比赛的数据对象
     * @return 生涯数据对象
     */
    private TotalStats updateTotalStatsWithGameStats(TotalStats totalStats, GameStats gameStats) {
        totalStats.setFga(totalStats.getFga() + gameStats.getFga());
        totalStats.setFgm(totalStats.getFgm() + gameStats.getFgm());
        totalStats.setFg((float) totalStats.getFgm() * 100 / totalStats.getFga());
        totalStats.setPa3(totalStats.getPa3() + gameStats.getPa3());
        totalStats.setPm3(totalStats.getPm3() + gameStats.getPm3());
        totalStats.setFg3((float) totalStats.getPm3() * 100 / totalStats.getPa3());
        totalStats.setPa2(totalStats.getPa2() + gameStats.getPa2());
        totalStats.setPm2(totalStats.getPm2() + gameStats.getPm2());
        totalStats.setFg2((float) totalStats.getPm2() * 100 / totalStats.getPa2());
        totalStats.setPa1(totalStats.getPa1() + gameStats.getPa1());
        totalStats.setPm1(totalStats.getPm1() + gameStats.getPm1());
        totalStats.setFg1((float) totalStats.getPm1() * 100 / totalStats.getPa1());
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
