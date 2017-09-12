package com.mmcgarvey.jsongenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.mmcgarvey.jsongenerator.jsonparser.*;

import java.io.IOException;

public class JsonParser {

    private final ObjectMapper mapper = new ObjectMapper();

    public String parse(String jsonString) throws IOException {
        JsonNode json = mapper.readTree(jsonString);
        return mapper.writeValueAsString(parse(json));
    }

    public Object parse(JsonNode jsonNode) throws JsonProcessingException {
        return doParse(jsonNode, jsonNode.getNodeType());
    }

    private Object doParse(JsonNode json, JsonNodeType jsonNodeType) throws JsonProcessingException {
        JsonTypeParser typeParser = getParserFor(jsonNodeType);
        return typeParser.parse(json);
    }

    private JsonTypeParser getParserFor(JsonNodeType jsonNodeType) {
        JsonTypeParser jsonTypeParser;
        switch (jsonNodeType) {
            case ARRAY:
                jsonTypeParser = new ArrayParser();
                break;
            case OBJECT:
                jsonTypeParser = new ObjectParser();
                break;
            case NUMBER:
                jsonTypeParser = new NumberParser();
                break;
            case STRING:
                jsonTypeParser = new StringParser();
                break;
            case BOOLEAN:
                jsonTypeParser = new BooleanParser();
                break;
            default:
                jsonTypeParser = new NoOpParser();
        }
        return jsonTypeParser;
    }

}
