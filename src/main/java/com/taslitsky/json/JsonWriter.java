package com.taslitsky.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taslitsky.order.Order;

import java.nio.file.Paths;

public class JsonWriter {

    public void createJson(Order order) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(Paths.get("order.json").toFile(), order);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
