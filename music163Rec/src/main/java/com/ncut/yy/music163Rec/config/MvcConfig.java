package com.ncut.yy.music163Rec.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 印佳明
 * @create 2019-01-12 17:43
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    /*资源处理器*/
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/temp/**").addResourceLocations("/WEB-INF/temp/");
        registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
        registry.addResourceHandler("/lib/**").addResourceLocations("/WEB-INF/lib/");
    }
}
