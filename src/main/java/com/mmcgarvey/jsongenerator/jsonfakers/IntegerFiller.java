package com.mmcgarvey.jsongenerator.jsonfakers;

import java.util.Random;

public class IntegerFiller extends JsonFiller {

    private static final Random random = new Random();

    @Override
    public String getName() {
        return "integer";
    }

    @Override
    public Object run(String text, String parameters, Integer start, Integer end) {
        if (parameters.isEmpty()) {
            return random.nextInt();
        }
        int min = Integer.parseInt(parameters.substring(0, parameters.indexOf(",")));
        int max = Integer.parseInt(parameters.substring(parameters.indexOf(",") + 1));
        return random.nextInt((max - min) + 1) + min;
    }
}
