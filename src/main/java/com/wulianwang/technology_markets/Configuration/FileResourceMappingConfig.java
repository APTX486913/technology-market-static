package com.wulianwang.technology_markets.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 文件资源映射路径配置
 */
@Configuration
public class FileResourceMappingConfig implements WebMvcConfigurer {
    @Value("${upload.image.location}")
    private String uploadLocation;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:" + uploadLocation);
    }
}
