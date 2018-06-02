package com.nearsoft.exercise.persistenceservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@NamedStoredProcedureQuery(
        name = "create",
        procedureName = "pin_store.create",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "tittle", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "brand", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "description", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "unitPrice", type = BigDecimal.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "availableUnits", type = Integer.class)
        })
@Table(name = "item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id //@Generated value=assigned
    @Column(name = "id")
    private long id;
    @Column(name = "tittle")
    private String tittle;
    @Column(name = "brand")
    private String brand;
    @Column(name = "description")
    private String description;
    @Column(name = "unitprice")
    private BigDecimal unitPrice;
    @Column(name = "availableunits")
    private int availableUnits;

    public Item(){}

    public Item(Long id, String tittle, String brand, String description, BigDecimal unitPrice, int availableUnits){
        this.id = id;
        this.tittle = tittle;
        this.brand = brand;
        this.description = description;
        this.unitPrice = unitPrice;
        this.availableUnits = availableUnits;
    }

    public long getId() {
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

    public void setId(Long id) {
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

    //override equals, hashcode
}
