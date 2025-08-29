package co.medina.study.javakafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic userEventsTopic() {
        return new NewTopic("users-events", 3, (short) 1);
    }
}
