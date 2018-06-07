package com.nearsoft.exercise.persistenceservice.repositories;

import com.nearsoft.exercise.persistenceservice.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository("itemRepository")
public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query(value = "{call pin_store.find_all_items}", nativeQuery = true)
    List<Item> findAll();

    @Procedure(name = "create")
    void create(
            @Param("id") Long id,
            @Param("tittle") String tittle,
            @Param("brand") String brand,
            @Param("description") String description,
            @Param("unitPrice") BigDecimal unitPrice,
            @Param("availableUnits") Integer availableUnits);
}
