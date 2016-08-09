package com.owngame.web;

import com.owngame.dto.PlayerInfosFullExposer;
import com.owngame.service.PlayerInfosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



/**
 * Created by Administrator on 2016-8-2.
 */

/**
 * Spring使用说明
 * 在Spring3.0中定义一个控制器类，这个类必须标有@Controller注解。
 * 当有@Controller注解的控制器收到一个请求时，它会寻找一个合适的handler方法去处理这个请求。
 * 这就需要控制器通过一个或多个handler映射去把每个请求映射到handler方法。
 * 为了这样做，一个控制器类的方法需要被@RequestMapping注解装饰，使它们成为handler方法。
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
    @RequestMapping(value = "/{id}/detail", method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})// 声明如何匹配网络请求和返回数据
//    @ResponseBody// 告知返回的是json数据
    public String detail(@PathVariable("id") long id, Model model) {
        System.out.println("id:" + id);
        if (id == 0) {
            return "redirect";
        }
        PlayerInfosFullExposer playerInfosFullExposer = playerInfosService.getPlayerInfosFullById(id);
        model.addAttribute("playerInfosFullExposer", playerInfosFullExposer);
        logger.info("at:::::model={}", model);
        // 在返回数据中读取model里的数据 model
        return "detail";//view
        /**
         * handler方法处理完请求后，它把控制权委托给视图名与handler方法返回值相同的视图。
         * 为了提供一个灵活的方法，一个handler方法的返回值并不代表一个视图的实现而是一个逻辑视图，即没有任何文件扩展名。
         * 你可以将这些逻辑视图映射到正确的实现，并将这些实现写入到上下文文件，这样你就可以轻松的更改视图层代码甚至不用修改请求handler类的代码。
         * 为一个逻辑名称匹配正确的文件是视图解析器的责任。一旦控制器类已将一个视图名称解析到一个视图实现。它会根据视图实现的设计来渲染对应对象。
         */
    }


    /**
     * 返回json数据格式的方法
     * 因为开启了相应的配置，所以只要用上特定的@ResponseBody，它就能把返回的对象做成Json对象返回了。
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}/test", method = RequestMethod.GET)
    @ResponseBody
    public PlayerInfosFullExposer test(@PathVariable("id") long id, Model model) {
        PlayerInfosFullExposer playerInfosFullExposer = playerInfosService.getPlayerInfosFullById(id);
        model.addAttribute("playerInfosFullExposer", playerInfosFullExposer);
        logger.info("at:::::model={}", model);
        // 在返回数据中读取model里的数据 model
        return playerInfosFullExposer;
    }

    @RequestMapping(value = "jsontype/{id}", method = RequestMethod.GET)
    public ResponseEntity<PlayerInfosFullExposer> test2(@PathVariable("id") long id) {
        PlayerInfosFullExposer playerInfosFullExposer = playerInfosService.getPlayerInfosFullById(id);
        return new ResponseEntity<PlayerInfosFullExposer>(playerInfosFullExposer, HttpStatus.OK);
    }

    /**
     * 接受网络请求 并拿去到请求中的json数据
     * @param object
     * @return
     */
    @RequestMapping(value = "/test3", method = RequestMethod.POST)
    public ResponseEntity<PlayerInfosFullExposer> test3(@RequestBody Object object) {
        System.out.println("I was shooted...." + object);
        PlayerInfosFullExposer playerInfosFullExposer =  (PlayerInfosFullExposer)object;
        playerInfosFullExposer.getPlayerBasicInfos().setName("我是你哥！");
        logger.info("at:::::playerInfosFullExposer={}", playerInfosFullExposer);
        return new ResponseEntity<PlayerInfosFullExposer>(playerInfosFullExposer, HttpStatus.OK);
    }

}
