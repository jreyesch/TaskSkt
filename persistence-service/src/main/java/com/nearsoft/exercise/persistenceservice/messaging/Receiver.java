package com.nearsoft.exercise.persistenceservice.messaging;

import com.nearsoft.exercise.persistenceservice.model.Item;
import com.nearsoft.exercise.persistenceservice.model.JsonConverter;
import com.nearsoft.exercise.persistenceservice.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    private JsonConverter converter;

    @Autowired
    Sender sender;

    @Autowired
    ItemService service;

    @RabbitListener(queues = "${queue.create-item}")
    public void receiveCreateItem(String in) {
        logger.info(" >>> Received receiveCreateItem: {}", in);
        converter = JsonConverter.getInstance();
        Item temp = converter.fromJSonToObject(in);
        System.out.println(" [x] temp '" + temp.toString() + "'");
        service.create(
                temp.getId(),
                temp.getTittle(),
                temp.getBrand(),
                temp.getDescription(),
                temp.getUnitPrice(),
                temp.getAvailableUnits());

    }

    @RabbitListener(queues = "${queue.find-all}")
    public void receiveFindAllItems(String in) {
        logger.info(" >>> Received receiveFindAllItems: {}", in);
        converter = JsonConverter.getInstance();
        sender.requestAllItems(service.findAll());
    }
}