package com.nearsoft.exercise.pinstore.service;

import com.nearsoft.exercise.pinstorecommons.entities.Item;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
interface IItem {
    public boolean createSingleItem(Item item);

    public List<Item> findaAll();
}
