package com.nearsoft.exercise.pinstorecommons.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nearsoft.exercise.pinstorecommons.entities.Item;
import java.util.List;

public class JsonConverter {
    private static JsonConverter jsonConverter;

    protected JsonConverter() {
    }

    public static JsonConverter getInstance() {
        if (jsonConverter == null) {
            jsonConverter = new JsonConverter();
        }
        return jsonConverter;
    }

    public String toJson(Object element) {
        return new Gson().toJson(element);
    }

    public Item fromJSonToObject(String string) {
        return new Gson().fromJson(string, new TypeToken<Item>() {
        }.getType());
    }

    public String fromListToJson(List<Item> elementList) {

        return new Gson().toJson(elementList);
    }

    public List<Item> fromJSonToList(String string) {
        return new Gson().fromJson(string, new TypeToken<List<Item>>() {
        }.getType());
    }
}

