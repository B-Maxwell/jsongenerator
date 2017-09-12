package com.mmcgarvey.jsongenerator.jsonparser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.mmcgarvey.jsongenerator.JsonParser;
import com.mmcgarvey.jsongenerator.jsonfakermodifier.JsonArrayModifier;
import com.mmcgarvey.jsongenerator.jsonfakermodifier.Repeat;
import com.mmcgarvey.jsongenerator.model.JsonGeneratorMethod;
import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayParser implements JsonTypeParser {

    private static final JsonParser jsonParser = new JsonParser();
    private static final Map<String, JsonArrayModifier> arrayModifiers = new HashMap<>();

    static {
        addModifier(new Repeat());
    }

    private List<Object> json = new ArrayList<>();

    private static void addModifier(JsonArrayModifier arrayModifier) {
        arrayModifiers.put(arrayModifier.getName(), arrayModifier);
    }

    @Override
    public Object parse(JsonNode node) throws JsonProcessingException {
        JsonNode modifiedNode = handleModifiers(node);
        for (JsonNode j : modifiedNode) {
            json.add(jsonParser.parse(j));
        }
        return json;
    }

    private JsonNode handleModifiers(JsonNode node) {
        ArrayNode modifyingNode = new ArrayNode(JsonNodeFactory.instance);

        boolean shouldModify = false;
        JsonGeneratorString modifier = null;
        for (JsonNode n : node) {
            if (n.isTextual() && isModifier(n.asText()) && !shouldModify) {
                shouldModify = true;
                modifier = new JsonGeneratorString(n.asText());
                continue;
            } else if (shouldModify) {
                JsonGeneratorMethod generatorMethod = modifier.getGeneratorMethod();
                List<JsonNode> modifiedNodes =
                        arrayModifiers.get(generatorMethod.getName()).modifyArray(n, modifier);
                modifiedNodes.forEach(modifyingNode::add);
                shouldModify = false;
                modifier = null;
                continue;
            }
            modifyingNode.add(n);
        }
        return modifyingNode;
    }

    private boolean isModifier(String s) {
        JsonGeneratorString generatorString = new JsonGeneratorString(s);
        return generatorString.isGeneratorString()
                && arrayModifiers.containsKey(generatorString.getGeneratorMethod().getName());
    }
}
