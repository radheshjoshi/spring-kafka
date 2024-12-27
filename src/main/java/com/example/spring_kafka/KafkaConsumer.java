package com.example.spring_kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "baeldung", groupId = "group_id")
    public void listener(String message){
        System.out.println("Received Messasge in group group_id: " + message);
    }
}
