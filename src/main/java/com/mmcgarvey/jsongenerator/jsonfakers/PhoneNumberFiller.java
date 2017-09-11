package com.mmcgarvey.jsongenerator.jsonfakers;

import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.Collections;
import java.util.List;

public class PhoneNumberFiller extends JsonFiller {

    @Override
    public List<String> getMethodNames() {
        return Collections.singletonList("phoneNumber");
    }

    @Override
    public Class returns() {
        return String.class;
    }

    @Override
    public Object run(JsonGeneratorString generatorString) {
        return replaceText(generatorString, faker.phoneNumber().cellPhone());
    }
}
