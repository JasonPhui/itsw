package com.ph.itsw.video.service;

import com.ph.itsw.video.entity.Configure;

/**
 * @author JasonPhui
 * 2018/12/15
 */
public interface ConfigureService {

    /**
     * 根据name获取配置对象
     * @param name 配置名
     * @return 配置对象
     */
    Configure getConfigure(String name);
}
