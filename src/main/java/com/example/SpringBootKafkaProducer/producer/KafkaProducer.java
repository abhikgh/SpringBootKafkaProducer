package com.example.SpringBootKafkaProducer.producer;


import com.ingka.spe.model.icart.Toy;
import com.ingka.spe.model.icart.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Component
@Slf4j
public class KafkaProducer {

    @Value("${kafka.topic.send}")
    private String topicSend;

    @Autowired
    @Qualifier("kafkaUserTemplate")
    private KafkaTemplate<String, User> kafkaUserTemplate;

    @Autowired
    @Qualifier("kafkaToyTemplate")
    private KafkaTemplate<String, Toy> kafkaToyTemplate;

    @Autowired
    @Qualifier("kafkaStringTemplate")
    private KafkaTemplate<String, String> kafkaStringTemplate;

    public void sendMessage(Object object) throws ExecutionException, InterruptedException {
        int partition = -1;

        //kafkaTemplate.send(topic, key, value);

        if (object instanceof User) {
            User user = (User) object;
            kafkaUserTemplate.send(topicSend, UUID.randomUUID().toString(), user);
            System.out.println("User sent successfully");
        }

        if (object instanceof Toy) {
            Toy toy = (Toy) object;
            kafkaToyTemplate.send(topicSend, UUID.randomUUID().toString(), toy);
            System.out.println("Toy sent successfully");
        }

        if (object instanceof String) {
            String input = object.toString();
            kafkaStringTemplate.send(topicSend, UUID.randomUUID().toString(), input);
            System.out.println("String sent successfully");
        }

    }
}
