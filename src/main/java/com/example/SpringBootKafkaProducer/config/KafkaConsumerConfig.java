package com.example.SpringBootKafkaProducer.config;


import com.example.SpringBootKafkaProducer.partition.KafkaCustomPartitioner;
import com.ingka.spe.model.icart.OrderInput;
import com.ingka.spe.model.icart.Toy;
import com.ingka.spe.model.icart.User;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    //JSON User Deserializer
    @Bean(name = "kafkaUserListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, User> kafkaUserListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, User> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        JsonDeserializer<User> jsonDeserializer = new JsonDeserializer<>();
        jsonDeserializer.addTrustedPackages("*");
        Map<String, Object> map = new HashMap<>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        map.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, KafkaCustomPartitioner.class);
        ConsumerFactory<String, User> consumerFactory = new DefaultKafkaConsumerFactory<>(map, new StringDeserializer(), jsonDeserializer);
        concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory);
        return concurrentKafkaListenerContainerFactory;
    }

    //JSON Toy Deserializer
    @Bean(name = "kafkaToyListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, Toy> kafkaToyListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, Toy> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        JsonDeserializer<Toy> jsonDeserializer = new JsonDeserializer<>();
        jsonDeserializer.addTrustedPackages("*");
        Map<String, Object> map = new HashMap<>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        map.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, KafkaCustomPartitioner.class);
        ConsumerFactory<String, Toy> consumerFactory = new DefaultKafkaConsumerFactory<>(map, new StringDeserializer(), jsonDeserializer);
        concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory);
        return concurrentKafkaListenerContainerFactory;
    }

    //String Deserializer
    @Bean(name = "kafkaStringListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaStringListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        Map<String, Object> map = new HashMap<>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        map.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, KafkaCustomPartitioner.class);
        ConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<>(map, new StringDeserializer(), new StringDeserializer());
        concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory);
        return concurrentKafkaListenerContainerFactory;
    }

    //JSON OrderInput Deserializer
    @Bean(name = "kafkaOrderListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, OrderInput> kafkaOrderListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, OrderInput> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        JsonDeserializer<OrderInput> jsonDeserializer = new JsonDeserializer<>();
        jsonDeserializer.addTrustedPackages("*");
        Map<String, Object> map = new HashMap<>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        map.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, KafkaCustomPartitioner.class);
        ConsumerFactory<String, OrderInput> consumerFactory = new DefaultKafkaConsumerFactory<>(map, new StringDeserializer(), jsonDeserializer);
        concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory);
        return concurrentKafkaListenerContainerFactory;
    }
}
