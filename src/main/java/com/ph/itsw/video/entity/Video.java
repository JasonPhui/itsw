package com.ph.itsw.video.entity;

import java.sql.Timestamp;

/**
 * @author JasonPhui
 * 2018/12/12
 */
public class Video implements java.io.Serializable {

    // Fields

    private Integer id;
    private VideoState videoState;
    private Category category;
    private String name;
    private String intro;
    private Timestamp edittime;
    private Integer islive;
    private String url;
    private String oriurl;
    private String thumbnailurl;
    private String remark;

    // Constructors

    /** default constructor */
    public Video() {
    }

    /** full constructor */
    public Video(VideoState videoState, Category category, String name,
                 String intro, Timestamp edittime, Integer islive, String url,
                 String oriurl, String thumbnailurl, String remark) {
        this.videoState = videoState;
        this.category = category;
        this.name = name;
        this.intro = intro;
        this.edittime = edittime;
        this.islive = islive;
        this.url = url;
        this.oriurl = oriurl;
        this.thumbnailurl = thumbnailurl;
        this.remark = remark;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VideoState getVideostate() {
        return this.videoState;
    }

    public void setVideostate(VideoState videostate) {
        this.videoState = videostate;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Timestamp getEdittime() {
        return this.edittime;
    }

    public void setEdittime(Timestamp edittime) {
        this.edittime = edittime;
    }

    public Integer getIslive() {
        return this.islive;
    }

    public void setIslive(Integer islive) {
        this.islive = islive;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOriurl() {
        return this.oriurl;
    }

    public void setOriurl(String oriurl) {
        this.oriurl = oriurl;
    }

    public String getThumbnailurl() {
        return this.thumbnailurl;
    }

    public void setThumbnailurl(String thumbnailurl) {
        this.thumbnailurl = thumbnailurl;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
