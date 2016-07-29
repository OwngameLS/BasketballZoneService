package com.owngame.entity;

/**
 * Created by Administrator on 2016-7-25.
 * 一个队伍或者一名球员的生涯（总）数据
 */
public class TotalStats {
    private long id;
    private int fga;
    private int fgm;
    private float fg;
    private int pa3;
    private int pm3;
    private float fg3;
    private int pa2;
    private int pm2;
    private float fg2;
    private int pa1;
    private int pm1;
    private float fg1;
    private int rebs;
    private int orebs;
    private int blks;
    private int fouls;
    private int ofouls;
    private int stls;
    private int asts;
    private int tos;
    private int totalScore;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFga() {
        return fga;
    }

    public void setFga(int fga) {
        this.fga = fga;
    }

    public int getFgm() {
        return fgm;
    }

    public void setFgm(int fgm) {
        this.fgm = fgm;
    }

    public float getFg() {
        return fg;
    }

    public void setFg(float fg) {
        this.fg = fg;
    }

    public int getPa3() {
        return pa3;
    }

    public void setPa3(int pa3) {
        this.pa3 = pa3;
    }

    public int getPm3() {
        return pm3;
    }

    public void setPm3(int pm3) {
        this.pm3 = pm3;
    }

    public float getFg3() {
        return fg3;
    }

    public void setFg3(float fg3) {
        this.fg3 = fg3;
    }

    public int getPa2() {
        return pa2;
    }

    public void setPa2(int pa2) {
        this.pa2 = pa2;
    }

    public int getPm2() {
        return pm2;
    }

    public void setPm2(int pm2) {
        this.pm2 = pm2;
    }

    public float getFg2() {
        return fg2;
    }

    public void setFg2(float fg2) {
        this.fg2 = fg2;
    }

    public int getPa1() {
        return pa1;
    }

    public void setPa1(int pa1) {
        this.pa1 = pa1;
    }

    public int getPm1() {
        return pm1;
    }

    public void setPm1(int pm1) {
        this.pm1 = pm1;
    }

    public float getFg1() {
        return fg1;
    }

    public void setFg1(float fg1) {
        this.fg1 = fg1;
    }

    public int getRebs() {
        return rebs;
    }

    public void setRebs(int rebs) {
        this.rebs = rebs;
    }

    public int getOrebs() {
        return orebs;
    }

    public void setOrebs(int orebs) {
        this.orebs = orebs;
    }

    public int getBlks() {
        return blks;
    }

    public void setBlks(int blks) {
        this.blks = blks;
    }

    public int getFouls() {
        return fouls;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }

    public int getOfouls() {
        return ofouls;
    }

    public void setOfouls(int ofouls) {
        this.ofouls = ofouls;
    }

    public int getStls() {
        return stls;
    }

    public void setStls(int stls) {
        this.stls = stls;
    }

    public int getAsts() {
        return asts;
    }

    public void setAsts(int asts) {
        this.asts = asts;
    }

    public int getTos() {
        return tos;
    }

    public void setTos(int tos) {
        this.tos = tos;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "TotalStats{" +
                "id=" + id +
                ", fga=" + fga +
                ", fgm=" + fgm +
                ", fg=" + fg +
                ", pa3=" + pa3 +
                ", pm3=" + pm3 +
                ", fg3=" + fg3 +
                ", pa2=" + pa2 +
                ", pm2=" + pm2 +
                ", fg2=" + fg2 +
                ", pa1=" + pa1 +
                ", pm1=" + pm1 +
                ", fg1=" + fg1 +
                ", rebs=" + rebs +
                ", orebs=" + orebs +
                ", blks=" + blks +
                ", fouls=" + fouls +
                ", ofouls=" + ofouls +
                ", stls=" + stls +
                ", asts=" + asts +
                ", tos=" + tos +
                ", totalScore=" + totalScore +
                '}';
    }
}
