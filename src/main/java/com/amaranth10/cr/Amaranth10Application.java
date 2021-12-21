package com.amaranth10.cr;

import com.amaranth10.cr.constants.CrConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@SpringBootApplication
@EnableAspectJAutoProxy
public class Amaranth10Application {
    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/"+ CrConstants.contextPath);

        SpringApplication.run(Amaranth10Application.class, args);
    }
    @Configuration
    public class WebConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**").allowedOrigins("*");
        }
    }
}
