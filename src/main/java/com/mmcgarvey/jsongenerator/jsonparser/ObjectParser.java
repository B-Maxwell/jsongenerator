package com.mmcgarvey.jsongenerator.jsonparser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.Map;

public class ObjectParser implements JsonTypeParser {
    private JsonParser jsonParser = new JsonParser();

    private Map<String, Object> json = new HashMap<>();

    @Override
    public Object parse(JsonNode node) throws JsonProcessingException {
        node.fieldNames().forEachRemaining(name -> json.put(name, null));
        for (String key : json.keySet()) {
            json.put(key, jsonParser.parse(node.get(key)));
        }
        return json;
    }
}
