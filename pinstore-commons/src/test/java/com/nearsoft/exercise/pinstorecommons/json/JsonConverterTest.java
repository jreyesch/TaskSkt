package com.nearsoft.exercise.pinstorecommons.json;

import com.nearsoft.exercise.pinstorecommons.entities.Item;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JsonConverterTest {

    private Item item;
    private JsonConverter jsonConverter;
    String jsonItem;

    @Before
    public void setUp() throws Exception {
        jsonConverter = JsonConverter.getInstance();
        jsonItem = "{\"id\":0,\"tittle\":\"Salsa Valentina\",\"brand\":\"Salsa Tamazula\"," +
                "\"description\":\"12.5 ounces glass bottle with flip-top cap\",\"unitPrice\":6.99,\"availableUnits\":100}";
        item = new Item(0L,"Salsa Valentina","Salsa Tamazula",
                "12.5 ounces glass bottle with flip-top cap", new BigDecimal("6.99"),100);
    }

    @Test
    public void toJson() {
        assertEquals(jsonItem,jsonConverter.toJson(item));
    }

    @Test
    public void fromJSonToObject() {
        Item item = jsonConverter.fromJSonToObject(jsonItem);
        assertEquals("Salsa Valentina",item.getTittle());
    }

    @Test
    public void fromListToJson() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        assertEquals("["+jsonItem+"]",jsonConverter.fromListToJson(itemList));
    }

    @Test
    public void fromJSonToList() {
        String json = "["+jsonItem+"]";
        assertEquals("12.5 ounces glass bottle with flip-top cap",
                jsonConverter.fromJSonToList(json).get(0).getDescription());
    }

    @Test
    public void newInstancesShouldReturn_SameObject() {
        JsonConverter jsonConverter2 = JsonConverter.getInstance();
        assertEquals(jsonConverter, jsonConverter2);
    }
}