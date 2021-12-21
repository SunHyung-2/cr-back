package com.amaranth10.cr.model.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicPropertiesModels {

    /*
    기본 properties 정의
     */
    @Getter
    @Setter
    @Value("${Klago.Sign.Value:#{''}}")
    private String klagoSignValue;

    /*
    기본 properties 정의
     */
    @Getter
    @Setter
    @Value("${Klago.sms.server}")
    private String klagoSmsServer;

}