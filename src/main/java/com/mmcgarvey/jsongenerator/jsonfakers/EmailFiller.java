package com.mmcgarvey.jsongenerator.jsonfakers;

import com.github.javafaker.Faker;
import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.Collections;
import java.util.List;

public class EmailFiller extends JsonFiller {

    @Override
    public List<String> getMethodNames() {
        return Collections.singletonList("email");
    }

    @Override
    public Object run(JsonGeneratorString generatorString) {
        String fakeEmail = faker.internet().emailAddress();
        return replaceText(generatorString, fakeEmail);
    }
}
