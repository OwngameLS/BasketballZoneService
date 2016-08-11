package com.owngame.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.owngame.dao.GameInfosDao;
import com.owngame.dao.GameStatsDao;
import com.owngame.dto.GameInfosFullExposer;
import com.owngame.entity.GameInfos;
import com.owngame.entity.GameStats;
import com.owngame.service.GameInfosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 */
@Service
public class GameInfosServiceImpl implements GameInfosService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private GameStatsDao gameStatsDao;
    @Autowired
    private GameInfosDao gameInfosDao;

    public GameInfos getGameInfos(long id) {
        return gameInfosDao.queryById(id);
    }

    public GameInfosFullExposer getGameInofsFull(long id) {
        // 先拿到基础信息
        GameInfos gameInfos = gameInfosDao.queryById(id);
        // 根据基础信息进行初始化
        return initGameStatsOfGameInfos(gameInfos);
    }

    // 初始化技术统计信息已实现完整的比赛信息
    private GameInfosFullExposer initGameStatsOfGameInfos(GameInfos gameInfos) {
        GameInfosFullExposer gameInfosFullExposer = new GameInfosFullExposer();
        gameInfosFullExposer.setGameInfos(gameInfos);
        String ids = gameInfos.getTeamidHome() + "," + gameInfos.getPlayerStatIdsHome();
        gameInfosFullExposer.setHomeTeamStats(queryStats(ids));
        ids = gameInfos.getTeamidGuest() + "," + gameInfos.getPlayerStatIdsGuest();
        gameInfosFullExposer.setGuestTeamStats(queryStats(ids));
        return gameInfosFullExposer;
    }

    private List queryStats(String idsString) {
        ArrayList<GameStats> gameStatses = new ArrayList<GameStats>();
        // 将数组字符串转换成long数组
        long[] ids = parseLongString(idsString);
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] != 0) {//得到合理的id才去查询
                gameStatses.add(gameStatsDao.queryById(ids[i]));
            }
        }
        return gameStatses;
    }

    // 将long型的字符串数组改成long型数组
    private long[] parseLongString(String longStr) {
        String[] str = longStr.split(",");
        int length = str.length;
        long[] ids = new long[length];
        for (int i = 0; i < length; i++) {
            long temp = -1;
            try {
                temp = Long.parseLong(str[i]);
            } catch (NumberFormatException e) {
                continue;
            }
            ids[i] = temp;
        }
        return ids;
    }

    private GameInfosFullExposer parseJsonString(String jsonString){
        GameInfosFullExposer gameInfosFullExposer = new GameInfosFullExposer();
        ObjectMapper mapper = new ObjectMapper();
        try{
            gameInfosFullExposer.setGameInfos(new GameInfos());
            JsonNode root = mapper.readTree(jsonString);
            // 提取比赛id
            JsonNode temp = root.path("id");
            gameInfosFullExposer.getGameInfos().setId(Long.parseLong(temp.toString()));
            // 提取countType
            temp = root.path("countType");
            char[] c = new char[1];
            temp.toString().getChars(0,1,c,0);
            gameInfosFullExposer.getGameInfos().setCountType(c[0]);
            // 提取gameType
            temp = root.path("gameType");
            temp.toString().getChars(0,1,c,0);
            gameInfosFullExposer.getGameInfos().setGameType(c[0]);
            // 提取unionId
            temp = root.path("unionId");
            gameInfosFullExposer.getGameInfos().setUnionId(Long.parseLong(temp.toString()));
            // description
            temp = root.path("description");
            gameInfosFullExposer.getGameInfos().setDescription(temp.toString());
            // 提取date
            temp = root.path("date");
            gameInfosFullExposer.getGameInfos().setGametime(Date.valueOf(temp.toString()));
            // 提取ismot
            temp = root.path("ismot");
            temp.toString().getChars(0,1,c,0);
            gameInfosFullExposer.getGameInfos().setIsmot(c[0]);
            // 提取stats
            temp = root.path("stats");
            JsonNode homeStats = temp.path("home");
            // 获取home数组
            gameInfosFullExposer.setHomeTeamStats(new ArrayList<GameStats>());
            for (JsonNode homeStat : homeStats) {
                GameStats gameStat = new GameStats();
                gameStat.setId(-1);
                gameStat.setGameid(gameInfosFullExposer.getGameInfos().getId());
                gameStat.setIsmot(gameInfosFullExposer.getGameInfos().getIsmot());
                String[] statStr = homeStat.path("stat").toString().split(",");
                gameStat.setFga(Integer.valueOf(statStr[0]));
                gameStat.setFgm(Integer.valueOf(statStr[1]));
                gameStat.setFg(Float.valueOf(statStr[2]));
                gameStat.setPa3(Integer.valueOf(statStr[3]));
                gameStat.setPm3(Integer.valueOf(statStr[4]));
                gameStat.setFg3(Float.valueOf(statStr[5]));
                gameStat.setPa2(Integer.valueOf(statStr[6]));
                gameStat.setPm2(Integer.valueOf(statStr[7]));
                gameStat.setFg2(Float.valueOf(statStr[8]));
                gameStat.setPa1(Integer.valueOf(statStr[9]));
                gameStat.setPm1(Integer.valueOf(statStr[10]));
                gameStat.setFg1(Float.valueOf(statStr[11]));
                gameStat.setRebs(Integer.valueOf(statStr[12]));
                gameStat.setOrebs(Integer.valueOf(statStr[13]));
                gameStat.setAsts(Integer.valueOf(statStr[14]));
                gameStat.setTos(Integer.valueOf(statStr[15]));
                gameStat.setBlks(Integer.valueOf(statStr[16]));
                gameStat.setStls(Integer.valueOf(statStr[17]));
                gameStat.setFouls(Integer.valueOf(statStr[18]));
                gameStat.setOfouls(Integer.valueOf(statStr[19]));
                gameStat.setTotalScore(Integer.valueOf(statStr[20]));
                int length = statStr.length;


                gameStat.setScore1st(Integer.valueOf(statStr[20]));

                gameStat.setFga(Integer.valueOf(statStr[14]));
                gameStat.setScore1st(Integer.valueOf(statStr[14]));
                gameStat.setScore1st(Integer.valueOf(statStr[14]));
                gameStat.setScore1st(Integer.valueOf(statStr[14]));gameStat.setScore1st(Integer.valueOf(statStr[14]));


                String id = homeStat.path("id").toString();
                if(id.equals("xxxx") == false){
                    // TODO 需要保存个人历史数据
                }



            }



        }catch (IOException e){
            e.printStackTrace();
        }

        return gameInfosFullExposer;
    }
}
