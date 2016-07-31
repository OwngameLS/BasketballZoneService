package com.owngame.dto;

import com.owngame.entity.GameInfos;
import com.owngame.entity.GameStats;

import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 * 比赛信息的暴露类，它包含了各种复杂的对象，不只是对应数据库
 */
public class GameInfosFullExposer {
    private GameInfos gameInfos;//比赛基础信息
    private List<GameStats> homeTeamStats; // 主队的比赛数据统计
    private List<GameStats> guestTeamStats; // 客队的比赛数据统计

    public GameInfos getGameInfos() {
        return gameInfos;
    }

    public void setGameInfos(GameInfos gameInfos) {
        this.gameInfos = gameInfos;
    }

    public List<GameStats> getHomeTeamStats() {
        return homeTeamStats;
    }

    public void setHomeTeamStats(List<GameStats> homeTeamStats) {
        this.homeTeamStats = homeTeamStats;
    }

    public List<GameStats> getGuestTeamStats() {
        return guestTeamStats;
    }

    public void setGuestTeamStats(List<GameStats> guestTeamStats) {
        this.guestTeamStats = guestTeamStats;
    }

    @Override
    public String toString() {
        return "GameInfosFullExposer{" +
                "gameInfos=" + gameInfos.toString() +
                ", homeTeamStats=" + homeTeamStats +
                ", guestTeamStats=" + guestTeamStats +
                '}';
    }
}
