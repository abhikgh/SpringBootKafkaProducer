package com.example.SpringBootKafkaProducer.partition;


import com.ingka.spe.model.icart.OrderInput;
import com.ingka.spe.model.icart.Toy;
import com.ingka.spe.model.icart.User;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

public class KafkaCustomPartitioner implements Partitioner {

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

        if (value instanceof String) {
            return 0;
        } else if (value instanceof User) {
            return 1;
        } else if (value instanceof Toy) {
            return 2;
        } else if (value instanceof OrderInput) {
            return 3;
        } else {
            return 0;
        }

    }

    @Override
    public void configure(Map<String, ?> map) {

    }

    @Override
    public void close() {

    }
}
