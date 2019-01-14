package com.ncut.yy.music163Rec.respository;

import com.ncut.yy.music163Rec.pojo.CleUserMusic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 印佳明
 * @create 2019-01-12 19:52
 */
public interface CleUserMusicRespository extends JpaRepository<CleUserMusic,Integer> {
    List<CleUserMusic> findByUserid(String userid);

    List<CleUserMusic> getAllByIdBetween(Integer pageB, Integer pageE);
}
