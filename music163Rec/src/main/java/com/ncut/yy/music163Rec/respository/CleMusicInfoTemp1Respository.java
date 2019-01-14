package com.ncut.yy.music163Rec.respository;

import com.ncut.yy.music163Rec.pojo.CleMusicInfoTemp1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 印佳明
 * @create 2019-01-12 19:52
 */
public interface CleMusicInfoTemp1Respository extends JpaRepository<CleMusicInfoTemp1,Integer> {
    CleMusicInfoTemp1 findByMusicid(String musicid);
    List<CleMusicInfoTemp1> getAllByIdBetween(Integer pageB, Integer pageE);
}
