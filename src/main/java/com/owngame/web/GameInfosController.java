package com.owngame.web;

import com.owngame.service.GameInfosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016-8-4.
 */
@Controller
@RequestMapping("/gameinfos")
public class GameInfosController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    GameInfosService gameInfosService;

    @RequestMapping(value = "/{id}/detail", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})// 声明如何匹配网络请求和返回数据
    public void insert(){

    }


}
