package com.mmcgarvey.jsongenerator.jsonfakers;

import com.github.javafaker.Faker;
import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.List;
import java.util.Random;

public abstract class JsonFiller {
    protected static final Faker faker = new Faker();
    protected static final Random random = new Random();

    public abstract List<String> getMethodNames();
    public abstract Object run(JsonGeneratorString generatorString);

    protected String replaceText(JsonGeneratorString generatorString, String fillerText) {
        String text = generatorString.getJsonString();
        String part1 = text.substring(0, generatorString.getGeneratorMethodIndexStart());
        String part2 = text.substring(generatorString.getGeneratorMethodIndexEnd());
        return part1 + fillerText + part2;
    }
}
