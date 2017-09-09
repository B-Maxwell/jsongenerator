package com.mmcgarvey.jsongenerator.jsonfakers;


public class NameFiller extends JsonFiller {

    @Override
    public String getName() {
        return "name";
    }

    @Override
    public Object run(String text, String parameters, Integer start, Integer end) {
        String fakeText = faker.name().fullName();
        return replaceText(text, fakeText, start, end);
    }
}
