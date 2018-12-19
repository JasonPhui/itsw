package com.ph.itsw.video.service;

import com.ph.itsw.video.dao.VideoMapper;
import com.ph.itsw.video.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JasonPhui
 * 2018/12/15
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> getVideoByOrder(int order) {
        return videoMapper.getVideoByOrder(order);
    }

    @Override
    public void updateVideoByVideo(Video video) {
        videoMapper.updateVideoByVideo(video);
    }

}
