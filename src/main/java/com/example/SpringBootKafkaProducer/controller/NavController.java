package com.example.SpringBootKafkaProducer.controller;

import com.example.SpringBootKafkaProducer.service.OrderService;
import com.ingka.spe.model.icart.OrderInput;
import com.ingka.spe.model.icart.OrderOutput;
import io.jaegertracing.internal.JaegerTracer;
import io.micrometer.core.instrument.MeterRegistry;
import io.opentracing.Span;
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

    @Autowired
    private MeterRegistry meterRegistry;

    @Autowired
    private JaegerTracer jaegerTracer;

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
        //Span span = jaegerTracer.buildSpan("updateOrder").start();
        OrderOutput orderOutput =  orderService.updateOrder(orderInput);
        //span.finish();
        return orderOutput;
    }
}
