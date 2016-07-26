package com.owngame.entity;

import java.sql.Date;

/**
 * Created by Administrator on 2016-7-25.
 * 球队信息类
 */
public class TeamInfos {
    private long id;
    private long cur_teamid;
    private String history_teams;
    private int age;
    private Date birthday;
    private String resume;
    private String name;
    private char sex;
    private String jersyno;
    private float height;
    private float weight;
    private String position;
    private int games;
    private int mvp;
    private String prides;
    private long statid;
    private String iconimg;
    private char grade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCur_teamid() {
        return cur_teamid;
    }

    public void setCur_teamid(long cur_teamid) {
        this.cur_teamid = cur_teamid;
    }

    public String getHistory_teams() {
        return history_teams;
    }

    public void setHistory_teams(String history_teams) {
        this.history_teams = history_teams;
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

    public String getJersyno() {
        return jersyno;
    }

    public void setJersyno(String jersyno) {
        this.jersyno = jersyno;
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

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}
