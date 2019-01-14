package com.ncut.yy.music163Rec.pojo;

/**
 * @author 印佳明
 * @create 2019-01-13 20:16
 */
public class ResUserMusicVO {
    private Integer id;
    private String userid;
    private String username;
    private String musicid;
    private String musicname;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMusicid() {
        return musicid;
    }

    public void setMusicid(String musicid) {
        this.musicid = musicid;
    }

    public String getMusicname() {
        return musicname;
    }

    public void setMusicname(String musicname) {
        this.musicname = musicname;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "ResUserMusicVO{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", musicid='" + musicid + '\'' +
                ", musicname='" + musicname + '\'' +
                ", ratio='" + ratio + '\'' +
                '}';
    }
}
