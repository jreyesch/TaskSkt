package com.nearsoft.exercise.persistenceservice.messaging;

import com.nearsoft.exercise.persistenceservice.model.Item;
import com.nearsoft.exercise.persistenceservice.model.JsonConverter;
import com.nearsoft.exercise.persistenceservice.service.ItemService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private JsonConverter converter;

    @Autowired
    Sender sender;

    @Autowired
    ItemService service;

    @RabbitListener(queues = "create-item")
    public void receiveCreateItem(String in) {

        System.out.println(" [x] Received '" + in + "'");
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

    @RabbitListener(queues = "find-all")
    public void receiveFindAllItems(String in) {
        for(Item item : service.findAll()){
            System.out.println(" [x] Received *" + item.getTittle() + "*");
        }
        converter = JsonConverter.getInstance();
        sender.requestAllItems(service.findAll());
    }
}