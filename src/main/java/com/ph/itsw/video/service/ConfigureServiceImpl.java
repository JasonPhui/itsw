package com.ph.itsw.video.service;

import com.ph.itsw.video.dao.ConfigureMapper;
import com.ph.itsw.video.entity.Configure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JasonPhui
 * 2018/12/15
 */

@Service
public class ConfigureServiceImpl implements ConfigureService{

    @Autowired
    private ConfigureMapper configure;

    @Override
    public Configure getConfigure(String name) {
        return configure.getConfigure(name);
    }

}
