package com.nearsoft.exercise.pinstore.service;

import com.nearsoft.exercise.pinstore.model.Item;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ListAllItemsService {

    public List<Item> findaAll(){

        List<Item> fullItemList = new ArrayList<>();
        Item dummyItem = new Item(1,"Marqueez Black","Nike",
                "Black sneakers with white accents",new BigDecimal("99.99"),20);
        Item dummyItem1 = new Item(1,"Sony 52 inch TV with gift","Sony",
                "Silver LED TV with free sound bar",new BigDecimal("899.99"),5);
        fullItemList.add(dummyItem);
        fullItemList.add(dummyItem1);
        return fullItemList;
    }
}
