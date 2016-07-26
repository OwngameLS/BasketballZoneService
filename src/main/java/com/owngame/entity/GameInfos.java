package com.owngame.entity;

import java.sql.Date;

/**
 * Created by Administrator on 2016-7-25.
 * 比赛信息类
 */
public class GameInfos {
    private long id;
    private char countType;
    private char gameType;
    private long unionId;
    private String desc;
    private Date gametime;
    private char isMOT;
    private long teamIdHome;
    private long teamIdGuest;
    private String playerStatIdsHome;
    private String playerStatIdsGuest;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getCountType() {
        return countType;
    }

    public void setCountType(char countType) {
        this.countType = countType;
    }

    public char getGameType() {
        return gameType;
    }

    public void setGameType(char gameType) {
        this.gameType = gameType;
    }

    public long getUnionId() {
        return unionId;
    }

    public void setUnionId(long unionId) {
        this.unionId = unionId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getGametime() {
        return gametime;
    }

    public void setGametime(Date gametime) {
        this.gametime = gametime;
    }

    public char getIsMOT() {
        return isMOT;
    }

    public void setIsMOT(char isMOT) {
        this.isMOT = isMOT;
    }

    public long getTeamIdHome() {
        return teamIdHome;
    }

    public void setTeamIdHome(long teamIdHome) {
        this.teamIdHome = teamIdHome;
    }

    public long getTeamIdGuest() {
        return teamIdGuest;
    }

    public void setTeamIdGuest(long teamIdGuest) {
        this.teamIdGuest = teamIdGuest;
    }

    public String getPlayerStatIdsHome() {
        return playerStatIdsHome;
    }

    public void setPlayerStatIdsHome(String playerStatIdsHome) {
        this.playerStatIdsHome = playerStatIdsHome;
    }

    public String getPlayerStatIdsGuest() {
        return playerStatIdsGuest;
    }

    public void setPlayerStatIdsGuest(String playerStatIdsGuest) {
        this.playerStatIdsGuest = playerStatIdsGuest;
    }


}
