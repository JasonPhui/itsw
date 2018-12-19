package com.ph.itsw.video.service;

import com.ph.itsw.video.dao.VideoStateMapper;
import com.ph.itsw.video.entity.VideoState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JasonPhui
 * 2018/12/15
 */
@Service
public class VideoStateServiceImpl implements VideoStateService{

    @Autowired
    private VideoStateMapper videoStateMapper;

    @Override
    public VideoState getVideoStateByOrder(int order) {
        return videoStateMapper.getVideoStateByOrder(order);
    }
}
