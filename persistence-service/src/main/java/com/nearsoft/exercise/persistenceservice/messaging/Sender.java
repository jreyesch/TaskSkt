package com.nearsoft.exercise.persistenceservice.messaging;

import com.nearsoft.exercise.persistenceservice.model.Item;
import com.nearsoft.exercise.persistenceservice.model.JsonConverter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class Sender {
    private JsonConverter jSon;

    @Autowired
    private RabbitTemplate template;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(Item item) {
        jSon = JsonConverter.getInstance();
        this.template.convertAndSend("create-item", jSon.toJson(item));
        System.out.println(" [x] Sent '" + jSon.toJson(item));
    }

    public void requestAllItems(List<Item> fullItemList){
        jSon = JsonConverter.getInstance();
        this.template.convertAndSend("find-all-response", jSon.fromListToJson(fullItemList));
        System.out.println(" [x] Sent requestAllItems'");
    }
}
