package com.example.SpringBootKafkaProducer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "orders_kafka")
@Data
public class OrderEntity {

    @Id
    @Column(name = "orderId")
    private Integer orderId;

    @Column(name = "status")
    private String status;

    @Column(name = "consumerId")
    private String consumerId;

    @Column(name = "orderDate")
    private Date orderDate;

    @Column(name = "orderStatus")
    private boolean orderStatus;
}
