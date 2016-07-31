package com.owngame.dto;

import com.owngame.entity.TeamInfos;
import com.owngame.entity.TotalStats;

/**
 * Created by Administrator on 2016/7/31.
 */
public class TeamInfosFullExposer {
    private TeamInfos teamInfos;
    private TotalStats totalStats;

    public TeamInfos getTeamInfos() {
        return teamInfos;
    }

    public void setTeamInfos(TeamInfos teamInfos) {
        this.teamInfos = teamInfos;
    }

    public TotalStats getTotalStats() {
        return totalStats;
    }

    public void setTotalStats(TotalStats totalStats) {
        this.totalStats = totalStats;
    }

    @Override
    public String toString() {
        return "TeamInfosFullExposer{" +
                "teamInfos=" + teamInfos.toString() +
                ", totalStats=" + totalStats.toString() +
                '}';
    }
}
