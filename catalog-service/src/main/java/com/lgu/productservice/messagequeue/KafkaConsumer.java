package com.lgu.productservice.messagequeue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgu.productservice.jpa.ProductEntity;
import com.lgu.productservice.jpa.ProductRepository;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.ObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class KafkaConsumer {
    ProductRepository repository;

    @Autowired
    public KafkaConsumer(ProductRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "product-topic")
    public void updateQty(String kafkaMsg) {
        log.info("Kafka Message : " + kafkaMsg);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(kafkaMsg, new TypeReference<Map<Object, Object>>() {});
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

        ProductEntity entitiy = repository.findByProductId((String) map.get("productId"));

        if (entitiy != null) {
            entitiy.setStock(entitiy.getStock() - (Integer) map.get("qty"));
            repository.save(entitiy);
        }
    }
}
