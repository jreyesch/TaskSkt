package com.nearsoft.exercise.persistenceservice.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

@Component
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String tittle;
    private String brand;
    private String description;
    private BigDecimal unitPrice;
    private int availableUnits;

    public Item(){}

    public Item(int id, String tittle, String brand, String description, BigDecimal unitPrice, int availableUnits){
        this.id = id;
        this.tittle = tittle;
        this.brand = brand;
        this.description = description;
        this.unitPrice = unitPrice;
        this.availableUnits = availableUnits;
    }

    public int getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }
}
