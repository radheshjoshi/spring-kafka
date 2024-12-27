package com.example.spring_kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("baeldung", message);
        future.whenComplete((res,  ex) -> {
            if(ex == null){
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + res.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });
    }
}
