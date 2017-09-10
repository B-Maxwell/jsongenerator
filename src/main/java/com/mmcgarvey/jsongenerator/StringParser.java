package com.mmcgarvey.jsongenerator;

import com.fasterxml.jackson.databind.JsonNode;
import com.mmcgarvey.jsongenerator.jsonfakers.*;
import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.HashMap;
import java.util.Map;

public class StringParser implements JsonTypeParser {
    private static final Map<String, JsonFiller> fillers = new HashMap<>();

    private static void addFiller(JsonFiller filler) {
        filler.getMethodNames().forEach(name -> fillers.put(name, filler));
    }

    static {
        addFiller(new NumberFiller());
        addFiller(new PhoneNumberFiller());
        addFiller(new BooleanFiller());
        addFiller(new NameFiller());
        addFiller(new EmailFiller());
        addFiller(new LoremFiller());
        addFiller(new UrlFiller());
        addFiller(new LocationFiller());
    }


    @Override
    public Object parse(JsonNode node) {
        JsonGeneratorString generatorString = new JsonGeneratorString(node.asText());
        if (generatorString.isGeneratorString()) {
            JsonFiller filler = fillers.get(generatorString.getGeneratorMethodName());
            if (filler != null) {
                return filler.run(generatorString);
            }
        }
        return generatorString.getJsonString();
    }
}
