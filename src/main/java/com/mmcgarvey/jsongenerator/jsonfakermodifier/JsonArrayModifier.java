package com.mmcgarvey.jsongenerator.jsonfakermodifier;

import com.fasterxml.jackson.databind.JsonNode;
import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.List;

public interface JsonArrayModifier extends JsonFakerModifier {
    public List<JsonNode> modifyArray(JsonNode node, JsonGeneratorString modifier);
}
