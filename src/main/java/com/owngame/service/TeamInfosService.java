package com.owngame.service;

import com.owngame.dto.TeamInfosFullExposer;
import com.owngame.entity.TeamInfos;

/**
 * Created by Administrator on 2016/7/31.
 * 球队信息暴露给使用者的接口
 */
public interface TeamInfosService {
    TeamInfos queryById(long id);
    TeamInfosFullExposer queryFullById(long id);
    int insert(TeamInfos teamInfos);
    int update(TeamInfos teamInfos);
    int delete(long id);
}
