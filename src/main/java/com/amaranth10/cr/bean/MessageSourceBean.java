package com.amaranth10.cr.bean;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageSourceBean {

    private final static String DEFAULT_CHARSET = "UTF-8";
    private final static String MESSAGE_BASE_FIX = "messages";

    @Bean
    public MessageSource getMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding(DEFAULT_CHARSET);
        messageSource.setBasename(MESSAGE_BASE_FIX);
        return  messageSource;
    }
}