package com.example.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "quickstart-events", groupId = "${spring.kafka.consumer.group-id}")
    public void kafkaConsumer(String message) {
        System.out.println(message);
    }

}
