package com.nearsoft.exercise.pinstore.messaging;

import com.nearsoft.exercise.pinstore.PinStoreApplication;
import com.nearsoft.exercise.pinstore.controller.ItemController;
import com.nearsoft.exercise.pinstorecommons.json.JsonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private static final Logger logger = LoggerFactory.getLogger(Sender.class);

    private JsonConverter converter;

    @Autowired
    PinStoreApplication application;

    @Autowired
    ItemController controller;

    @RabbitListener(queues = "${queue.findAllResponse}")
    public void receive(String in) {
        logger.info(" >>> Received: {}", in);
        converter = JsonConverter.getInstance();
        application.persistedItems = converter.fromJSonToList(in);
    }
}