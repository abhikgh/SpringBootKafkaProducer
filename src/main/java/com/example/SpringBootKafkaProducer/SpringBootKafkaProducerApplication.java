package com.example.SpringBootKafkaProducer;

import com.example.SpringBootKafkaProducer.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKafkaProducerApplication implements CommandLineRunner {

	@Autowired
	private KafkaProducer kafkaProducer;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//kafkaProducer.sendMessage(new User("11","kdkd","SSE"));

	 //kafkaProducer.sendMessage(new Toy("11","Fuju","Bublu"));

		kafkaProducer.sendMessage("Hello World Kafka!");

	}
}
