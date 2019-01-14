package com.ncut.yy.music163Rec.pojo;

import javax.persistence.*;

/**
 * @author 印佳明
 * @create 2019-01-14 19:13
 */
@Entity
@Table(name = "cle_composerinfo")
public class CleComposerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String composerid;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComposerid() {
        return composerid;
    }

    public void setComposerid(String composerid) {
        this.composerid = composerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
