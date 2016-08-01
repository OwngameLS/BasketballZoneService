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
    private String description;
    private Date gametime;
    private char ismot;
    private long teamidHome;
    private long teamidGuest;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getGametime() {
        return gametime;
    }

    public void setGametime(Date gametime) {
        this.gametime = gametime;
    }

    public char getIsmot() {
        return ismot;
    }

    public void setIsmot(char ismot) {
        this.ismot = ismot;
    }

    public long getTeamidHome() {
        return teamidHome;
    }

    public void setTeamidHome(long teamidHome) {
        this.teamidHome = teamidHome;
    }

    public long getTeamidGuest() {
        return teamidGuest;
    }

    public void setTeamidGuest(long teamidGuest) {
        this.teamidGuest = teamidGuest;
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

    @Override
    public String toString() {
        return "GameInfos{" +
                "id=" + id +
                ", countType=" + countType +
                ", gameType=" + gameType +
                ", unionId=" + unionId +
                ", description='" + description + '\'' +
                ", gametime=" + gametime +
                ", ismot=" + ismot +
                ", teamidHome=" + teamidHome +
                ", teamidGuest=" + teamidGuest +
                ", playerStatIdsHome='" + playerStatIdsHome + '\'' +
                ", playerStatIdsGuest='" + playerStatIdsGuest + '\'' +
                '}';
    }
}
