package com.example.kafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Value("${example.profile}")
    private String exampleProperties;
    @Value("${examplo.spring.datasource.username}")
    private String dbUsername;
    @Value("${examplo.spring.datasource.password}")
    private String dbPassword;

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        System.out.println("[EXAMPLE-PROFILE] Exemplo de profile: " + exampleProperties);
        System.out.println("[EXAMPLE-PROFILE] Exemplo de profile - USERNAME banco: " + dbUsername);
        System.out.println("[EXAMPLE-PROFILE] Exemplo de profile - PASSWORD banco: " + dbPassword);

        //System.out.println("[KAFKA-PRODUCER] Properties do kafka: " + bootstrapAddress);
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
