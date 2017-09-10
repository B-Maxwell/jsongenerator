package com.mmcgarvey.jsongenerator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonGeneratorString {
    private static final String GENERATOR_STRING_PATTERN = "\\{\\{\\s([a-zA-Z]*)\\((.*?)\\)\\s?}}";

    private final String jsonString;
    private final boolean isGeneratorString;
    private String generatorMethodName;
    private List<String> generatorMethodParameters;
    private Integer generatorMethodIndexStart;
    private Integer generatorMethodIndexEnd;

    public JsonGeneratorString(String jsonString) {
        this.jsonString = jsonString;
        this.isGeneratorString = isGeneratorString(jsonString);
        if (isGeneratorString) {
            parseGeneratorString(jsonString);
        }
    }

    private void parseGeneratorString(String jsonString) {
        Matcher matcher = Pattern.compile(GENERATOR_STRING_PATTERN).matcher(jsonString);
        if (matcher.find()) {
            generatorMethodName = matcher.group(1);
            generatorMethodParameters = parseParams(matcher.group(2));
            generatorMethodIndexStart = matcher.start();
            generatorMethodIndexEnd = matcher.end();
        }
    }

    private List<String> parseParams(String params) {
        List<String> generatorParams = new ArrayList<>();
        if (params.isEmpty()) {
            return generatorParams;
        }
        String[] paramsArr = params.split(",");
        generatorParams.addAll(Arrays.asList(paramsArr));
        return generatorParams;
    }

    private boolean isGeneratorString(String jsonString) {
        return Pattern.matches(GENERATOR_STRING_PATTERN, jsonString);
    }

    public String getGeneratorMethodName() {
        return generatorMethodName;
    }

    public List<String> getGeneratorMethodParameters() {
        return generatorMethodParameters;
    }

    public Integer getGeneratorMethodIndexStart() {
        return generatorMethodIndexStart;
    }

    public Integer getGeneratorMethodIndexEnd() {
        return generatorMethodIndexEnd;
    }

    public boolean isGeneratorString() {
        return isGeneratorString;
    }

    public String getJsonString() {
        return jsonString;
    }
}
