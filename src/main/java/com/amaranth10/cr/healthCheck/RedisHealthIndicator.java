package com.amaranth10.cr.healthCheck;

import com.amaranth10.cr.util.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RedisHealthIndicator implements HealthIndicator {
    private static final String key = "Redis";

    @Autowired
    RedisManager redisManager;

    @Override
    public Health health() {
        if(!isRedisConnect()) {
            return Health.down().withDetail(key, "Not Connected").build();
        }
        return Health.up().withDetail(key, "Connected").build();
    }

    private Boolean isRedisConnect() {
        return redisManager.healthCheck();
    }
}