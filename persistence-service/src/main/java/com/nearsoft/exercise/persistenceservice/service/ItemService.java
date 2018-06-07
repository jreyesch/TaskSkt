package com.nearsoft.exercise.persistenceservice.service;

import com.nearsoft.exercise.persistenceservice.model.Item;
import java.math.BigDecimal;
import java.util.List;

public interface ItemService {

    public List<Item> findAll();

    public void create(Long id, String tittle, String brand, String description, BigDecimal unitPrice, Integer availableUnits);
}
