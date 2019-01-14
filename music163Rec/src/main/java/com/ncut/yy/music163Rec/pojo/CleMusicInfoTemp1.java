package com.ncut.yy.music163Rec.pojo;

import javax.persistence.*;

/**
 * @author 印佳明
 * @create 2019-01-12 19:14
 */
@Entity
@Table(name = "cle_musicinfo_temp1")
public class CleMusicInfoTemp1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String musicid;
    private String name;
    private String composerid;
    private String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusicid() {
        return musicid;
    }

    public void setMusicid(String musicid) {
        this.musicid = musicid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposerid() {
        return composerid;
    }

    public void setComposerid(String composerid) {
        this.composerid = composerid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "CleMusicInfoTemp1{" +
                "id=" + id +
                ", musicid='" + musicid + '\'' +
                ", name='" + name + '\'' +
                ", composerid='" + composerid + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
