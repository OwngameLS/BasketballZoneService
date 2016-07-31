package com.owngame.service;

import com.owngame.dto.GameInfosFullExposer;
import com.owngame.entity.GameInfos;
import com.owngame.entity.GameStats;

/**
 *
 * 查询比赛信息的服务
 * Created by Administrator on 2016-7-27.
 */
public interface GameInfosService {
    /**
     * 根据比赛id查询比赛基础信息
     * @param id 比赛id
     * @return 基础信息对象
     */
    GameInfos getGameInfos(long id);

    /**
     * 根据比赛id查询比赛全部信息
     * @param id 比赛id
     * @return 全部信息对象
     */
    GameInfosFullExposer getGameInofsFull(long id);


}
