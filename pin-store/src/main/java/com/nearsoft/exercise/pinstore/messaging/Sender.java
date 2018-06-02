package com.nearsoft.exercise.pinstore.messaging;

import com.nearsoft.exercise.pinstorecommons.entities.Item;
import com.nearsoft.exercise.pinstorecommons.json.JsonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    private static final Logger logger = LoggerFactory.getLogger(Sender.class);
    private JsonConverter jSon;

    @Autowired
    private RabbitTemplate template;

    public void send(Item item) {
        jSon = JsonConverter.getInstance();
        this.template.convertAndSend("create-item", jSon.toJson(item));
        logger.info(" >>> Sent: {}",jSon.toJson(item));
    }

    public void requestAllItems(){
        this.template.convertAndSend("find-all", "requestAllItems");
        System.out.println(" >>> Sent requestAllItems'");
    }
}
