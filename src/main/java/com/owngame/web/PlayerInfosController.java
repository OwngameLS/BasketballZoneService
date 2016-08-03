package com.owngame.web;

import com.owngame.dto.PlayerInfosFullExposer;
import com.owngame.service.PlayerInfosService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016-8-2.
 */
@Controller
@RequestMapping("/playerinfos")
public class PlayerInfosController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerInfosService playerInfosService;

    /**
     * 获取球员信息
     * 用来处理网络调用
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="/{id}/detail", method = RequestMethod.GET,
                    produces = {"application/json;charset=UTF-8"})// 声明如何匹配网络请求和返回数据
//    @ResponseBody// 告知返回的是json数据
    public String detail(@PathVariable("id") long id, Model model){
        System.out.println("id:"+id);
        if(id == 0){
            return "redirect";
        }
        PlayerInfosFullExposer playerInfosFullExposer =  playerInfosService.getPlayerInfosFullById(id);
        model.addAttribute("playerInfosFullExposer", playerInfosFullExposer);
        logger.info("at:::::model={}", model);
        // 在返回数据中读取model里的数据 model
        return "detail";//view
    }

}
