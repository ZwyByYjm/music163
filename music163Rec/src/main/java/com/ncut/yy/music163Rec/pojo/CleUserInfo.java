package com.ncut.yy.music163Rec.pojo;

import javax.persistence.*;

/**
 * @author 印佳明
 * @create 2019-01-14 19:13
 */
@Entity
@Table(name = "cle_userinfo")
public class CleUserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userid;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
