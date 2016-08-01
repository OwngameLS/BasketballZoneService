package com.owngame.entity;

import java.sql.Date;

/**
 * Created by Administrator on 2016-7-25.
 * 球队信息类
 */
public class TeamInfos {
    private long id;
    private String name;
    private String description;
    private String prides;
    private int gamecount;
    private int wincount;
    private long statid;
    private String iconimg;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrides() {
        return prides;
    }

    public void setPrides(String prides) {
        this.prides = prides;
    }

    public int getGamecount() {
        return gamecount;
    }

    public void setGamecount(int gamecount) {
        this.gamecount = gamecount;
    }

    public int getWincount() {
        return wincount;
    }

    public void setWincount(int wincount) {
        this.wincount = wincount;
    }

    public long getStatid() {
        return statid;
    }

    public void setStatid(long statid) {
        this.statid = statid;
    }

    public String getIconimg() {
        return iconimg;
    }

    public void setIconimg(String iconimg) {
        this.iconimg = iconimg;
    }

    @Override
    public String toString() {
        return "TeamInfos{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", prides='" + prides + '\'' +
                ", gamecount=" + gamecount +
                ", wincount=" + wincount +
                ", statid=" + statid +
                ", iconimg='" + iconimg + '\'' +
                '}';
    }
}
