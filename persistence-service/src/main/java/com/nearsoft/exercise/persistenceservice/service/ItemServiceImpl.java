package com.nearsoft.exercise.persistenceservice.service;

import com.nearsoft.exercise.persistenceservice.model.Item;
import com.nearsoft.exercise.persistenceservice.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    public List<Item> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(Long id, String tittle, String brand, String description, BigDecimal unitPrice, Integer availableUnits) {
        repository.create(id, tittle, brand, description, unitPrice, availableUnits);
    }
}
