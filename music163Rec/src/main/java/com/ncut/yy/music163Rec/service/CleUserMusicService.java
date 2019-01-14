package com.ncut.yy.music163Rec.service;

import com.ncut.yy.music163Rec.pojo.*;
import com.ncut.yy.music163Rec.respository.CleMusicInfoTemp1Respository;
import com.ncut.yy.music163Rec.respository.CleUserInfoRespository;
import com.ncut.yy.music163Rec.respository.CleUserMusicRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 印佳明
 * @create 2019-01-12 20:43
 */
@Service
public class CleUserMusicService {

    @Autowired
    CleUserMusicRespository cleUserMusicRespository;
    @Autowired
    CleUserInfoRespository cleUserInfoRespository;
    @Autowired
    CleMusicInfoTemp1Respository cleMusicInfoTemp1Respository;

    public Page<CleUserMusic> findCleUserMusicByPageNAndPageS(Integer pageNumber, Integer pageSize) {
        PageRequest request = new PageRequest(pageNumber, pageSize);
        return cleUserMusicRespository.findAll(request);
    }
    public List<ResUserMusicVO> findCleUserMusicByPageBeginAndEnd(Integer pageB, Integer pageE) {
        List<ResUserMusicVO> resUserMusicVOS = new ArrayList<>();

        List<CleUserMusic> cleUserMusics = cleUserMusicRespository.getAllByIdBetween(pageB, pageE);

        for (CleUserMusic cleUm:cleUserMusics) {
            CleUserInfo cleComposerInfo = cleUserInfoRespository.findByUserid(cleUm.getUserid());
            CleMusicInfoTemp1 cleMusicInfoTemp1 = cleMusicInfoTemp1Respository.findByMusicid(cleUm.getMusicid());
            ResUserMusicVO resUserMusicVO = new ResUserMusicVO();
            resUserMusicVO.setMusicid(cleUm.getMusicid());
            resUserMusicVO.setMusicname(cleMusicInfoTemp1.getName());
            resUserMusicVO.setUserid(cleUm.getUserid());
            resUserMusicVO.setUsername(cleComposerInfo.getName());
            resUserMusicVO.setRatio(cleUm.getRatio());
            resUserMusicVOS.add(resUserMusicVO);
        }
        return resUserMusicVOS;
    }
}
