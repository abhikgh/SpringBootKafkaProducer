package com.example.SpringBootKafkaProducer.service;

import com.example.SpringBootKafkaProducer.entity.OrderEntity;
import com.example.SpringBootKafkaProducer.entity.OrderEntityMapper;
import com.example.SpringBootKafkaProducer.repository.OrderRepository;
import com.ingka.spe.model.icart.OrderInput;
import com.ingka.spe.model.icart.OrderOutput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public OrderOutput updateOrder(OrderInput orderInput) {

        //Mapstruct
        OrderEntityMapper orderEntityMapper = OrderEntityMapper.ORDER_ENTITY_MAPPER;
        OrderEntity orderEntity = orderEntityMapper.mapDTOToOrderEntity(orderInput);
        orderRepository.saveAndFlush(orderEntity);

        //Modelmapper
        OrderOutput orderOutput = modelMapper.map(orderEntity, OrderOutput.class);

        return orderOutput;

    }
}
