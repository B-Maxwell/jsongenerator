package com.mmcgarvey.jsongenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class ArrayParser implements JsonTypeParser {

    private final JsonParser jsonParser = new JsonParser();

    private List<Object> json = new ArrayList<>();

    @Override
    public Object parse(JsonNode node) throws JsonProcessingException {
        for (JsonNode j : node) {
            json.add(jsonParser.parse(j));
        }
        return json;
    }
}
