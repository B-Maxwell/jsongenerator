package com.mmcgarvey.jsongenerator.jsonparser;

import com.fasterxml.jackson.databind.JsonNode;

public class NoOpParser implements JsonTypeParser {
    @Override
    public Object parse(JsonNode node) {
        return "";
    }
}
