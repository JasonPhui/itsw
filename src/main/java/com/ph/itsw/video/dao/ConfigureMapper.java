package com.ph.itsw.video.dao;

import com.ph.itsw.video.entity.Configure;
import org.apache.ibatis.annotations.Param;

/**
 * @author JasonPhui
 * 2018/12/12
 */
public interface ConfigureMapper {
    /**
     * 根据name来获取配置
     * @param name 配置名
     * @return 配置对象
     */
    Configure getConfigure(@Param("name") String name);
}
