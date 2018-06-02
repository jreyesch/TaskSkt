package com.nearsoft.exercise.pinstore.service;

import com.nearsoft.exercise.pinstore.messaging.Sender;
import com.nearsoft.exercise.pinstorecommons.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService implements IItem {

    @Autowired
    private Sender sender;

    @Override
    public boolean createSingleItem(Item item){
        try {
            sender.send(item);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Item> findaAll(){
        sender.requestAllItems();
        return new ArrayList<>();
    }
}
