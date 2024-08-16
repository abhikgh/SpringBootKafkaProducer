package com.example.SpringBootKafkaProducer;

import com.example.SpringBootKafkaProducer.producer.KafkaProducer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ingka.spe.model.icart.OrderInput;
import com.ingka.spe.model.icart.Toy;
import com.ingka.spe.model.icart.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class SpringBootKafkaProducerApplication implements CommandLineRunner {

    @Autowired
    private KafkaProducer kafkaProducer;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       // kafkaProducer.sendMessage(new User("11", "kdkd", "SSE"));

        //kafkaProducer.sendMessage(new Toy("11", "Fuju", "Bublu"));

        //kafkaProducer.sendMessage("Hello World Kafka!");

		File file = new File("src/main/resources/order.json");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		OrderInput orderInput = objectMapper.readValue(file, OrderInput.class);
		kafkaProducer.sendMessage(orderInput);

    }
}
