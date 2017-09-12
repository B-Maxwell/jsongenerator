package com.mmcgarvey.jsongenerator.jsonfaker;

import com.github.javafaker.Faker;
import com.mmcgarvey.jsongenerator.model.JsonGeneratorMethod;
import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.List;
import java.util.Random;

public abstract class JsonFiller {
    protected static final Faker faker = new Faker();
    protected static final Random random = new Random();

    public abstract List<String> getMethodNames();

    public abstract Class returns();

    public boolean returnsString() {
        return returns().equals(String.class);
    }

    public abstract Object run(JsonGeneratorString generatorString);

    protected String replaceText(JsonGeneratorString generatorString, String fillerText) {
        JsonGeneratorMethod generatorMethod = generatorString.getGeneratorMethod();
        String part1 = generatorString.getJsonString().substring(0, generatorMethod.getStart());
        String part2 = generatorString.getJsonString().substring(generatorMethod.getEnd());
        return part1 + fillerText + part2;
    }
}
