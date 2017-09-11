package com.mmcgarvey.jsongenerator.jsonfakermodifiers;

import com.fasterxml.jackson.databind.JsonNode;
import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

public interface JsonFakerModifier {
    public String getName();

    public JsonNode modify(JsonNode node, JsonGeneratorString modifier);
}
