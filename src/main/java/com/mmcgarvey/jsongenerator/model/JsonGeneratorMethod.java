package com.mmcgarvey.jsongenerator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonGeneratorMethod {
    private final String name;
    private final List<String> parameters;
    private final Integer start;
    private final Integer end;

    public JsonGeneratorMethod(String name, String params, Integer start, Integer end) {
        this.name = name;
        this.parameters = parseParameters(params);
        this.start = start;
        this.end = end;
    }

    private List<String> parseParameters(String params) {
        List<String> generatorParams = new ArrayList<>();
        if (params.isEmpty()) {
            return generatorParams;
        }
        String[] paramsArr = params.split(",");
        generatorParams.addAll(Arrays.asList(paramsArr));
        return generatorParams;
    }

    public String getName() {
        return name;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }
}
