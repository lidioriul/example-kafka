package com.example.kafka.resources;

import com.example.kafka.model.ProducerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/kafka/producer")
public class KafkaProducerResource {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @PostMapping
    public String sendMessage(@RequestBody ProducerRequest pr) {
        kafkaTemplate.send(pr.getTopicName(), pr.getMessage());
        return "OK";
    }

    @GetMapping
    public String ok() {
        return "App UP";
    }
}
