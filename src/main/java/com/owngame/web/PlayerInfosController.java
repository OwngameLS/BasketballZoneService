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

    @RequestMapping(value="/{id}/detail", method = RequestMethod.GET,
                    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String detail(@PathVariable("id") Long id, Model model){
        if(id == null){
            return "redirect";
        }
        PlayerInfosFullExposer playerInfosFullExposer =  playerInfosService.getPlayerInfosFullById(id);
        model.addAttribute("playerInfos", playerInfosFullExposer);
        return "detail";
    }

}
