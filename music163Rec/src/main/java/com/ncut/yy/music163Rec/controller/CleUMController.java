package com.ncut.yy.music163Rec.controller;

import com.ncut.yy.music163Rec.pojo.CleMusicInfoTemp1;
import com.ncut.yy.music163Rec.pojo.ResUserMusicVO;
import com.ncut.yy.music163Rec.service.CleMusicInfoTemp1Service;
import com.ncut.yy.music163Rec.service.CleUserMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 印佳明
 * @create 2019-01-13 16:13
 * CleUserMusic相关接口、页面
 */

@Controller
@RequestMapping(value = "/cle")
public class CleUMController {

    private static final int PAGE_SIZE = 20;

    @Autowired
    CleUserMusicService cleUserMusicService;
    @Autowired
    CleMusicInfoTemp1Service cleMusicInfoTemp1Service;


    @RequestMapping(value = "/userMusic")
    public String userMusic(HttpServletRequest request, HttpServletResponse response, Model model) {

//        String pageNumberStr = request.getParameter("pageNumber");
//        if (pageNumberStr == null || "".equals(pageNumberStr)) {
//            pageNumberStr = "1";
//        }
//        int pageNumber = Integer.parseInt(pageNumberStr);
//        Page<ResUserMusicVO> cleUserMusicByPageNAndPageS = resUserMusicService
//                .findCleUserMusicByPageNAndPageS(pageNumber, PAGE_SIZE);
//
//        model.addAttribute("cleUserMusicList", cleUserMusicByPageNAndPageS.getContent());
//        model.addAttribute("totalPageNumber", cleUserMusicByPageNAndPageS.getTotalPages());
        return "userMusic";
    }

    @RequestMapping(value = "/getUserMusic", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<Object, Object> getUserMusic(HttpServletRequest request, HttpServletResponse response) {

        Map<Object, Object> result = new HashMap<>();
        //数据起始位置
        int startIndex = Integer.parseInt(request.getParameter("startIndex"));
        //每页显示的条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        List<ResUserMusicVO> cleUserMusics = cleUserMusicService
                .findCleUserMusicByPageBeginAndEnd(startIndex+1, startIndex+pageSize);

        result.put("cleUserMusics",cleUserMusics);
        result.put("cleUMTotal",6969354);
        return result;

    }



    @RequestMapping(value = "/getMusicInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<Object, Object> getMusicInfo(HttpServletRequest request, HttpServletResponse response) {

        Map<Object, Object> result = new HashMap<>();
        //数据起始位置
        int startIndex = Integer.parseInt(request.getParameter("startIndex"));
        //每页显示的条数
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        List<CleMusicInfoTemp1> cleMusicInfoTemp1s = cleMusicInfoTemp1Service
                .findCleUserMusicByPageBeginAndEnd(startIndex+1, startIndex+pageSize);
        result.put("cleMusicInfoTemp1s",cleMusicInfoTemp1s);
        result.put("cleMTotal",453414);
        return result;
    }
}
