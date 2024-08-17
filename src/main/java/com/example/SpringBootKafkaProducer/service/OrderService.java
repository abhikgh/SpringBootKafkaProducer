package com.example.SpringBootKafkaProducer.service;

import com.example.SpringBootKafkaProducer.entity.OrderEntity;
import com.example.SpringBootKafkaProducer.entity.OrderEntityMapper;
import com.example.SpringBootKafkaProducer.repository.OrderRepository;
import com.ingka.spe.model.icart.OrderInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity updateOrder(OrderInput orderInput) {

        OrderEntityMapper orderEntityMapper = OrderEntityMapper.ORDER_ENTITY_MAPPER;
        OrderEntity orderEntity = orderEntityMapper.mapDTOToOrderEntity(orderInput);
        orderRepository.saveAndFlush(orderEntity);
        return orderEntity;

    }
}
