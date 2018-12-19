package com.ph.itsw.configure;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;

/**
 * @author JasonPhui
 * 2018/12/19
 * Thymeleaf的配置
 */
@Configuration
public class ThymeleafConfigure {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
