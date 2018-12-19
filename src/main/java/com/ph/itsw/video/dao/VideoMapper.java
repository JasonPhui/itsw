package com.ph.itsw.video.dao;

import com.ph.itsw.video.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JasonPhui
 * 2018/12/12
 */
public interface VideoMapper {

    Video getVideoById(@Param("id") int id);

    Video getVideoCategoryById(@Param("id") int id);

    /**
     * 根据video的状态来获取video对象
     * @param order video的状态码
     * @return video对象
     */
    List<Video> getVideoByOrder(@Param("order") int order);

    /**
     * 通过Video对象更新数据
     * @param video Video对象
     */
    void updateVideoByVideo(Video video);
}
