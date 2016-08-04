package com.owngame.dao;

import com.owngame.entity.TeamInfos;

/**
 * Created by Administrator on 2016-7-26.
 */
public interface TeamInfosDao {
    TeamInfos queryById(long id);

    int insert(TeamInfos teamInfos);

    int update(TeamInfos teamInfos);

    int delete(long id);
}
