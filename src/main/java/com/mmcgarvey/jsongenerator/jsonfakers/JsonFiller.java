package com.mmcgarvey.jsongenerator.jsonfakers;

import com.github.javafaker.Faker;

public abstract class JsonFiller {
    protected static final Faker faker = new Faker();

    public abstract String getName();
    public abstract Object run(String text, String parameters, Integer start, Integer end);

    protected String replaceText(String text, String fillerText, Integer start, Integer end) {
        String part1 = text.substring(0, start);
        String part2 = text.substring(end);
        return part1 + fillerText + part2;
    }
}
