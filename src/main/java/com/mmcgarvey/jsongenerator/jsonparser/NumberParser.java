package com.mmcgarvey.jsongenerator.jsonparser;

import com.fasterxml.jackson.databind.JsonNode;

public class NumberParser implements JsonTypeParser {

    @Override
    public Object parse(JsonNode node) {
        if (node.asText().contains(".")) {
            return node.asDouble();
        }
        return node.asInt();
    }
}
