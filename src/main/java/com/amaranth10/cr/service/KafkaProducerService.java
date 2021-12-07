package com.amaranth10.cr.service;

import klago.log.utils.ILogParameterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void event01A01(String message, ILogParameterInfo requestInfo) {

        this.kafkaTemplate.send("topic","message");
    }

}
