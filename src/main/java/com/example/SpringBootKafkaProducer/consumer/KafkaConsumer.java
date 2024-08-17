package com.example.SpringBootKafkaProducer.consumer;

import com.ingka.spe.model.icart.OrderInput;
import com.ingka.spe.model.icart.Toy;
import com.ingka.spe.model.icart.User;
import lombok.SneakyThrows;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @SneakyThrows
    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "${kafka.topic.receive}",
                                             partitionOffsets = @PartitionOffset(partition = "0" ,initialOffset = "0")),
            containerFactory = "kafkaStringListenerContainerFactory", groupId = "group1")
    public void consumeString(@Payload String input){
        System.out.println("String " + input + " received successfully");
    }
	
	@SneakyThrows
	@KafkaListener(
            topicPartitions = @TopicPartition(topic = "${kafka.topic.receive}",
                                              partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "0")),
            containerFactory = "kafkaUserListenerContainerFactory", groupId = "group1")
	public void consumeUser(@Payload User user){
		System.out.println("User received successfully");
		System.out.println(user.getUserId()+"---"+user.getUserName()+"---"+user.getDesignation());
	}

    @SneakyThrows
    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "${kafka.topic.receive}",
                                              partitionOffsets = @PartitionOffset(partition = "2" ,initialOffset = "0")),
            containerFactory = "kafkaToyListenerContainerFactory", groupId = "group1")
    public void consumeToy(@Payload Toy toy){
        System.out.println("Toy received successfully");
        System.out.println(toy.getToyId()+"---"+toy.getToyName()+"---"+toy.getToyType());
    }

    @SneakyThrows
    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "${kafka.topic.receive}",
                    partitionOffsets = @PartitionOffset(partition = "3" ,initialOffset = "0")),
            containerFactory = "kafkaOrderListenerContainerFactory", groupId = "group1")
    public void consumeOrder(@Payload OrderInput orderInput){
        System.out.println("OrderInput received successfully");
        System.out.println(orderInput.getOrderId()+"---"+orderInput.getStatus()+"---"+orderInput.getConsumerId()+"---"+orderInput.getOrderDate()+"---"+orderInput.getOrderStatus());
    }



}
