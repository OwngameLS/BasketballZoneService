package com.owngame.dao;

import com.owngame.entity.PlayerInfos;

/**
 * Created by Administrator on 2016/7/23.
 */
public interface PlayerInfosDao {
    /**
     * 通过球员的Id号来查询球员信息
     * @param id
     * @return
     */
    PlayerInfos queryById(long id);

    /**
     * 插入球员信息
     * @param playerinfos
     * @return
     */
    int insert(PlayerInfos playerInfos);

    /**
     * 更新球员信息
     * @param playerInfos
     * @return
     */
    int update(PlayerInfos playerInfos);
}
