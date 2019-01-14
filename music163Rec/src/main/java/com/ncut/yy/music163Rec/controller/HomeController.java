package com.ncut.yy.music163Rec.controller;

import com.ncut.yy.music163Rec.pojo.CleUserMusic;
import com.ncut.yy.music163Rec.respository.CleUserMusicRespository;
import com.ncut.yy.music163Rec.service.CleUserMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 印佳明
 * @create 2019-01-12 17:04
 * 主页面
 */

@Controller
@RequestMapping(value = "/")
public class HomeController {
    @Autowired
    CleUserMusicRespository userMusicRespository;
    @Autowired
    CleUserMusicService cleUserMusicService;

    @RequestMapping(value = "/getCleUserMusic")
    @ResponseBody
    public String getCleUserMusic(String userid){
        List<CleUserMusic> cleUserMusics = userMusicRespository.findByUserid(userid);

        Page<CleUserMusic> cleUserMusicByPageNAndPageS = cleUserMusicService.findCleUserMusicByPageNAndPageS(0, 20);


        return cleUserMusics.get(0).toString();
    }

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/musicInfo")
    public String musicInfo(){
        return "musicInfo";
    }


    @RequestMapping(value = "/musicAttribute")
    public String musicAttribute(){
        return "musicAttribute";
    }

    @RequestMapping(value = "/userMixInterest")
    public String userMixInterest(){
        return "userMixInterest";
    }

    @RequestMapping(value = "/userMusicSim")
    public String userMusicSim(){
        return "userMusicSim";
    }

    @RequestMapping(value = "/contentRecomResult")
    public String contentRecomResult(){
        return "contentRecomResult";
    }

    @RequestMapping(value = "/contentChart")
    public String contentChart(){
        return "contentChart";
    }

    @RequestMapping(value = "/userMusicScore")
    public String userMusicScore(){
        return "userMusicScore";
    }

    @RequestMapping(value = "/musicSim")
    public String musicSim(){
        return "musicSim";
    }

    @RequestMapping(value = "/userSim")
    public String userSim(){
        return "userSim";
    }

    @RequestMapping(value = "/collaRecomResult")
    public String collaRecomResult(){
        return "collaRecomResult";
    }

    @RequestMapping(value = "/collaChart")
    public String collaChart(){
        return "collaChart";
    }

    @RequestMapping(value = "/mixPredScore")
    public String mixPredScore(){
        return "mixPredScore";
    }

    @RequestMapping(value = "/mixRecomResult")
    public String mixRecomResult(){
        return "mixRecomResult";
    }

    @RequestMapping(value = "/mixChart")
    public String mixChart(){
        return "mixChart";
    }

    @RequestMapping(value = "/welcome")
    public String welcome(){
        return "welcome";
    }

}
