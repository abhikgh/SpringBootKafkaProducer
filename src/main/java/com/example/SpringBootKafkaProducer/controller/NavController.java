package com.example.SpringBootKafkaProducer.controller;

import com.example.SpringBootKafkaProducer.service.OrderService;
import com.ingka.spe.model.icart.OrderInput;
import com.ingka.spe.model.icart.OrderOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class NavController {

    @Autowired
    private OrderService orderService;

    // http://localhost:9071/kafka/updateOrder
    /*
        {
            "orderId": 100,
            "status": "New",
            "consumerId": "2",
            "orderDate": "2023-03-22",
            "orderStatus": 1
        }
     */
    @PostMapping(value = "/updateOrder", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderOutput updateOrder(@RequestBody OrderInput orderInput) {
        return orderService.updateOrder(orderInput);
    }
}
