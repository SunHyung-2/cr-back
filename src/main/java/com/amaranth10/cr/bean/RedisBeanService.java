package com.amaranth10.cr.bean;

import com.amaranth10.cr.model.properties.RedisConnectionModels;
import com.amaranth10.cr.util.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisBeanService {

    @Autowired
    RedisConnectionModels redisConnectionModels;

    @Bean
    public RedisManager getRedisOrgConnection() throws Exception {
        return new RedisManager(
                redisConnectionModels.getIp()
                ,redisConnectionModels.getPort()
                ,redisConnectionModels.getPassword()
                ,redisConnectionModels.getSentinelHosts()
                ,redisConnectionModels.getMasterName());
    }
}