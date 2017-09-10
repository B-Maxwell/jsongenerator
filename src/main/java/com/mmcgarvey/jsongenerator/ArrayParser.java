package com.mmcgarvey.jsongenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.mmcgarvey.jsongenerator.jsonfakermodifiers.JsonArrayModifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayParser implements JsonTypeParser {

    private static final JsonParser jsonParser = new JsonParser();
    private static final Map<String, JsonArrayModifier> arrayModifiers = new HashMap<>();

    static {

    }

    private List<Object> json = new ArrayList<>();

    @Override
    public Object parse(JsonNode node) throws JsonProcessingException {
        JsonNode modifier = null;
        for (JsonNode j : node) {
            if (j.isTextual() && isModifier(j.asText())) {

            }
            json.add(jsonParser.parse(j));
        }
        return json;
    }

    private boolean isModifier(String s) {

    }

    private static void addModifier(JsonArrayModifier arrayModifier) {
        arrayModifiers.put(arrayModifier.getName(), arrayModifier);
    }
}
