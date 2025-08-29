package co.medina.study.javakafkademo.event;

import co.medina.study.javakafkademo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserEventConsumer {

    @KafkaListener(topics = "users-events", groupId = "user-group")
    public void consumeUserEvent(User user) {
        log.info("User event received from Kafka: {}", user);
        // Aquí iría la lógica para procesar el evento, como guardar en la base de datos
    }
}
