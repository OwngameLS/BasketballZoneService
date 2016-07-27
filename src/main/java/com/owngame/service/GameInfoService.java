package com.owngame.service;

import com.owngame.entity.GameInfos;

/**
 *
 * 查询比赛信息的服务
 * Created by Administrator on 2016-7-27.
 */
public interface GameInfoService {
    /**
     * 根据比赛id查询比赛信息
     * @param id
     * @return
     */
    GameInfos getGameInfos(long id);


}
