package com.mmcgarvey.jsongenerator;

import com.fasterxml.jackson.databind.JsonNode;

public class NoOpParser implements JsonTypeParser {
    @Override
    public Object parse(JsonNode node) {
        return "";
    }
}
