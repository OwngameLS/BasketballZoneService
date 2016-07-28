package com.owngame.dto;

import com.owngame.dao.TotalStatsDao;
import com.owngame.entity.PlayerInfos;
import com.owngame.entity.TotalStats;

/**
 * 数据传输对象
 * 将球员的基本信息和生涯数据综合展示
 * Created by Administrator on 2016-7-28.
 */
public class PlayerInfosFullExposer {
    private PlayerInfos playerBasicInfos;// 基本信息
    private TotalStats playerCareerStats;// 生涯技术统计信息


    public PlayerInfos getPlayerBasicInfos() {
        return playerBasicInfos;
    }

    public void setPlayerBasicInfos(PlayerInfos playerBasicInfos) {
        this.playerBasicInfos = playerBasicInfos;
    }

    public TotalStats getPlayerCareerStats() {
        return playerCareerStats;
    }

    public void setPlayerCareerStats(TotalStats playerCareerStats) {
        this.playerCareerStats = playerCareerStats;
    }
}
