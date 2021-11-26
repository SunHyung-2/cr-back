package com.amaranth10.cr.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Configuration
@Component
public class KafkaConsumerService {
    // consumer
    @KafkaListener(topics = "event01A01", groupId = "event")
    public void consume(@Headers MessageHeaders headers, @Payload String payload) {
        System.out.println("#### -> Consumed message -> " + payload);
    }

}
