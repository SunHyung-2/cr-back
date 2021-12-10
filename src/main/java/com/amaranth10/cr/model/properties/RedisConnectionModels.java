package com.amaranth10.cr.model.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ToString
@Configuration
public class RedisConnectionModels {

    @Value("${Klago.redis.ip}")
    private String ip;
    @Value("${Klago.redis.port}")
    private int port;
    @Value("${Klago.redis.password}")
    private String password;
    @Value("${Klago.redis.sentinel.client.hosts:#{''}}")
    private String sentinelHosts;
    @Value("${Klago.redis.master.name:#{''}}")
    private String masterName;

}
