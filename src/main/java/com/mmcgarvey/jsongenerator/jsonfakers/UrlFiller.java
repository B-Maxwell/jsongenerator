package com.mmcgarvey.jsongenerator.jsonfakers;

import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.Collections;
import java.util.List;

public class UrlFiller extends JsonFiller {

    @Override
    public List<String> getMethodNames() {
        return Collections.singletonList("url");
    }

    @Override
    public Object run(JsonGeneratorString generatorString) {
        return replaceText(generatorString, faker.internet().url());
    }
}
