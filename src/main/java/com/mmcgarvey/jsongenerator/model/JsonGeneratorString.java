package com.mmcgarvey.jsongenerator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonGeneratorString {
    private static final String GENERATOR_STRING_PATTERN = "\\{\\{\\s([a-zA-Z]*)\\((.*?)\\)\\s?}}";
    private static final Pattern pattern = Pattern.compile(GENERATOR_STRING_PATTERN);
    private boolean isGeneratorString;
    private String jsonString;
    private JsonGeneratorMethod generatorMethod;

    public JsonGeneratorString(String jsonString) {
        this.jsonString = jsonString;
        parseGeneratorString(jsonString);
    }

    private void parseGeneratorString(String jsonString) {
        Matcher matcher = pattern.matcher(jsonString);
        if (matcher.find()) {
            generatorMethod = new JsonGeneratorMethod(matcher.group(1), matcher.group(2), matcher.start(), matcher.end());
            isGeneratorString = true;
        } else {
            isGeneratorString = false;
        }
    }

    public JsonGeneratorMethod getGeneratorMethod() {
        return generatorMethod;
    }

    public boolean isGeneratorString() {
        return isGeneratorString;
    }

    public String getJsonString() {
        return jsonString;
    }
}
