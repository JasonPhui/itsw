package com.ph.itsw.video.service;

import com.ph.itsw.video.entity.Video;

import java.util.List;

/**
 * @author JasonPhui
 * 2018/12/15
 */
public interface VideoService {

    /**
     * 根据video的状态来获取video对象
     * @param order video的状态码
     * @return video对象
     */
    List<Video> getVideoByOrder(int order);

    /**
     * 通过Video对象更新数据
     * @param video Video对象
     */
    void updateVideoByVideo(Video video);
}
