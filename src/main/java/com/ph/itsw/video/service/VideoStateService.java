package com.ph.itsw.video.service;

import com.ph.itsw.video.entity.VideoState;

/**
 * @author JasonPhui
 * 2018/12/15
 */
public interface VideoStateService {

    /**
     * 根据状态码来获取状态对象
     * @param order 状态码
     * @return 状态对象
     */
    VideoState getVideoStateByOrder(int order);
}
