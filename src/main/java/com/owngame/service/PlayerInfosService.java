package com.owngame.service;

import com.owngame.dto.PlayerInfosFullExposer;
import com.owngame.entity.TotalStats;

/**
 * Created by Administrator on 2016-7-28.
 *
 * 球员信息操作服务类
 */
public interface PlayerInfosService {
    /**
     * 查询某一个球员的所有信息
     * @param id
     * @return
     */
    PlayerInfosFullExposer getPlayerInfosFullById(long id);

    /**
     * 查询某一个球员的生涯技术统计
     * @param statid
     * @return
     */
    TotalStats getTotalStats(long statid);
}
