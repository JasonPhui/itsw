package com.ph.itsw;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.TemplateEngine;

@SpringBootApplication
@MapperScan("com.ph.itsw.video.dao")
public class ItswApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItswApplication.class, args);
    }

}

