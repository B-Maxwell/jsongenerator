package com.mmcgarvey.jsongenerator.jsonparser;

import com.fasterxml.jackson.databind.JsonNode;
import com.mmcgarvey.jsongenerator.jsonfakers.*;
import com.mmcgarvey.jsongenerator.model.JsonGeneratorMethod;
import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.HashMap;
import java.util.Map;

public class StringParser implements JsonTypeParser {
    private static final Map<String, JsonFiller> fillers = new HashMap<>();

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

    private static void addFiller(JsonFiller filler) {
        filler.getMethodNames().forEach(name -> fillers.put(name, filler));
    }

    @Override
    public Object parse(JsonNode node) {
        JsonGeneratorString generatorString = new JsonGeneratorString(node.asText());
        while (generatorString.isGeneratorString()) {
            JsonGeneratorMethod generatorMethod = generatorString.getGeneratorMethod();
            JsonFiller filler = fillers.get(generatorMethod.getName());
            if (filler != null) {
                Object filled = filler.run(generatorString);
                if (!filler.returnsString()) {
                    return filled;
                }
                generatorString = new JsonGeneratorString(filled.toString());
            }
        }
        return generatorString.getJsonString();
    }
}
