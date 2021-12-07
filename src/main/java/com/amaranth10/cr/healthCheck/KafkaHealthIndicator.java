package com.amaranth10.cr.healthCheck;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeClusterOptions;
import org.apache.kafka.clients.admin.DescribeClusterResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

@Component
public class KafkaHealthIndicator implements HealthIndicator {

    private final static String key="kafka";

    @Autowired
    KafkaAdmin admin;

    @Override
    public Health health() {
        DescribeClusterOptions describeClusterOptions=new DescribeClusterOptions().timeoutMs(1000);
        AdminClient adminClient=AdminClient.create(admin.getConfigurationProperties());

        DescribeClusterResult result=adminClient.describeCluster(describeClusterOptions);

        try{
            String clusterId=result.clusterId().get();

            return Health.up().withDetail(key,"Connected").withDetail("clusterId",clusterId).build();
        }catch (Exception e){
            return Health.down().withDetail(key,"Not Connected").withException(e).build();
        }
    }
}