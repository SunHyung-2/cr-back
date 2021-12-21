package com.amaranth10.cr.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","HEAD","OPTIONS","PUT")
                .maxAge(3600)
                .allowedHeaders("x-requested-with", "origin", "content-type", "accept", "authorization", "content-type", "timestamp", "transaction-id", "wehago-sign");
    }

}