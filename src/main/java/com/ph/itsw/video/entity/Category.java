package com.ph.itsw.video.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JasonPhui
 * 2018/12/12
 */
public class Category implements java.io.Serializable {

    // Fields

    private Integer id;
    private String name;
    private Integer parentid;
    private String remark;
    private Set<Video> videos = new HashSet<Video>(0);

    // Constructors

    /** default constructor */
    public Category() {
    }

    /** full constructor */
    public Category(String name, Integer parentid, String remark,
                    Set<Video> videos) {
        this.name = name;
        this.parentid = parentid;
        this.remark = remark;
        this.videos = videos;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return this.parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<Video> getVideos() {
        return this.videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }

}
