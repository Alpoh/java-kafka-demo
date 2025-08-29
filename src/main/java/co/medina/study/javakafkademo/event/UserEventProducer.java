package co.medina.study.javakafkademo.event;

import co.medina.study.javakafkademo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEventProducer {

    private static final String TOPIC = "users-events";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendUserCreatedEvent(User user) {
        kafkaTemplate.send(TOPIC, user.getId().toString(), user);
        System.out.println("User created event sent to Kafka: " + user);
    }
}
