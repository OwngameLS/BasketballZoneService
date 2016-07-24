package com.owngame.dao;

import com.owngame.entity.Playerinfos;

import java.util.List;

/**
 * Created by Administrator on 2016/7/23.
 */
public interface PlayerinfosDao {
    Playerinfos queryById(long id);
    int addPlayerinfos(Playerinfos playerinfos);

}
