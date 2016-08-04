package com.owngame.dao;

import com.owngame.entity.TotalStats;


/**
 * Created by Administrator on 2016-7-26.
 */
public interface TotalStatsDao {
    TotalStats queryById(long id);

    int insert(TotalStats totalStats);

    int update(TotalStats totalStats);

    int delete(long id);
}
