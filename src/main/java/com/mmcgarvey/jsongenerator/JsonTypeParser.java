package com.mmcgarvey.jsongenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public interface JsonTypeParser {
    Object parse(JsonNode node) throws JsonProcessingException;
}
