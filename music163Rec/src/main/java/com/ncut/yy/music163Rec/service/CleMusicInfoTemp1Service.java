package com.ncut.yy.music163Rec.service;

import com.ncut.yy.music163Rec.pojo.CleMusicInfoTemp1;
import com.ncut.yy.music163Rec.respository.CleMusicInfoTemp1Respository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 印佳明
 * @create 2019-01-12 20:43
 */
@Service
public class CleMusicInfoTemp1Service {

    @Autowired
    CleMusicInfoTemp1Respository cleMusicInfoTemp1Respository;

    public Page<CleMusicInfoTemp1> findCleUserMusicByPageNAndPageS(Integer pageNumber, Integer pageSize) {
        PageRequest request = new PageRequest(pageNumber, pageSize);
        return cleMusicInfoTemp1Respository.findAll(request);
    }
    public List<CleMusicInfoTemp1> findCleUserMusicByPageBeginAndEnd(Integer pageB, Integer pageE) {
        return cleMusicInfoTemp1Respository.getAllByIdBetween(pageB,pageE);
    }
}
