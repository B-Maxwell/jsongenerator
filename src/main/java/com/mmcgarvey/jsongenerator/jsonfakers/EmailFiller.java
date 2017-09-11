package com.mmcgarvey.jsongenerator.jsonfakers;

import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.Collections;
import java.util.List;

public class EmailFiller extends JsonFiller {

    @Override
    public List<String> getMethodNames() {
        return Collections.singletonList("email");
    }

    @Override
    public Class returns() {
        return String.class;
    }

    @Override
    public Object run(JsonGeneratorString generatorString) {
        String fakeEmail = faker.internet().emailAddress();
        return replaceText(generatorString, fakeEmail);
    }
}
