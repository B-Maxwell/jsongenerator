package com.mmcgarvey.jsongenerator;

import com.fasterxml.jackson.databind.JsonNode;

public class BooleanParser implements JsonTypeParser {
    @Override
    public Object parse(JsonNode node) {
        return node.asBoolean();
    }
}
