package com.nearsoft.exercise.pinstore.service;

import com.nearsoft.exercise.pinstore.model.Item;
import com.nearsoft.exercise.pinstore.messaging.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateItemService {

    @Autowired
    private Sender sender;

    public boolean createItem(Item item){
        try {
            sender.send();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
