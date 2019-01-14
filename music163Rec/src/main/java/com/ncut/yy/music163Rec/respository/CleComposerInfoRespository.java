package com.ncut.yy.music163Rec.respository;

import com.ncut.yy.music163Rec.pojo.CleComposerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 印佳明
 * @create 2019-01-12 19:52
 */
public interface CleComposerInfoRespository extends JpaRepository<CleComposerInfo,Integer> {
    CleComposerInfo findByComposerid(String composerid);
}
