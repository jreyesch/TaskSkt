package com.nearsoft.exercise.pinstore.messaging;

import com.nearsoft.exercise.pinstore.PinStoreApplication;
import com.nearsoft.exercise.pinstore.controller.ItemController;
import com.nearsoft.exercise.pinstorecommons.json.JsonConverter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private JsonConverter converter;
    @Autowired
    PinStoreApplication application;

    @Autowired
    ItemController controller;

    @RabbitListener(queues = "find-all-response")
    public void receive(String in) {
        System.out.println(" [==] Received '" + in + "'");
        converter = JsonConverter.getInstance();
        application.persistedItems = converter.fromJSonToList(in);
    }
}