package com.owngame.entity;

import java.sql.Date;

/**
 * Created by Administrator on 2016/7/23.
 */
public class Playerinfos {
    private long id;
    private long curTeamId;
    private String historyTeams;
    private int age;
    private Date birthday;
    private String resume;
    private String name;
    private char sex;
    private String jersyNo;
    private float height;
    private float weight;
    private float armspan;
    private String position;
    private int games;
    private int mvp;
    private String prides;
    private long statId;
    private String iconImg;
    private String grade;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getCurTeamId() {
        return curTeamId;
    }
    public void setCurTeamId(long curTeamId) {
        this.curTeamId = curTeamId;
    }
    public String getHistoryTeams() {
        return historyTeams;
    }
    public void setHistoryTeams(String historyTeams) {
        this.historyTeams = historyTeams;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getResume() {
        return resume;
    }
    public void setResume(String resume) {
        this.resume = resume;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public char getSex() {
        return sex;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }
    public String getJersyNo() {
        return jersyNo;
    }
    public void setJersyNo(String jersyNo) {
        this.jersyNo = jersyNo;
    }
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public float getArmspan() {
        return armspan;
    }
    public void setArmspan(float armspan) {
        this.armspan = armspan;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public int getGames() {
        return games;
    }
    public void setGames(int games) {
        this.games = games;
    }
    public int getMvp() {
        return mvp;
    }
    public void setMvp(int mvp) {
        this.mvp = mvp;
    }
    public String getPrides() {
        return prides;
    }
    public void setPrides(String prides) {
        this.prides = prides;
    }
    public long getStatId() {
        return statId;
    }
    public void setStatId(long statId) {
        this.statId = statId;
    }
    public String getIconImg() {
        return iconImg;
    }
    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Playerinfos [id=" + id + ", curTeamId=" + curTeamId
                + ", historyTeams=" + historyTeams + ", age=" + age
                + ", birthday=" + birthday + ", resume=" + resume + ", name="
                + name + ", sex=" + sex + ", jersyNo=" + jersyNo + ", height="
                + height + ", weight=" + weight + ", armspan=" + armspan
                + ", position=" + position + ", games=" + games + ", mvp="
                + mvp + ", prides=" + prides + ", statId=" + statId
                + ", iconImg=" + iconImg + ", grade=" + grade + "]";
    }
}
