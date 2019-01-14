package com.ncut.yy.music163Rec.pojo;

import javax.persistence.*;

/**
 * @author 印佳明
 * @create 2019-01-12 19:14
 */
@Entity
@Table(name = "cle_user_music")
public class CleUserMusic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userid;
    private String musicid;
    private String ratio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMusicid() {
        return musicid;
    }

    public void setMusicid(String musicid) {
        this.musicid = musicid;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "CleUserMusic{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", musicid='" + musicid + '\'' +
                ", ratio='" + ratio + '\'' +
                '}';
    }
}
