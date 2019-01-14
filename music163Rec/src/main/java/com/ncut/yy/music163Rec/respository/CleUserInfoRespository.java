package com.ncut.yy.music163Rec.respository;

import com.ncut.yy.music163Rec.pojo.CleUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 印佳明
 * @create 2019-01-12 19:52
 */
public interface CleUserInfoRespository extends JpaRepository<CleUserInfo,Integer> {
    CleUserInfo findByUserid(String userid);
}
