package com.mmcgarvey.jsongenerator.jsonfaker;

import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.Collections;
import java.util.List;

public class BooleanFiller extends JsonFiller {

    @Override
    public List<String> getMethodNames() {
        return Collections.singletonList("boolean");
    }

    @Override
    public Class returns() {
        return Boolean.class;
    }

    @Override
    public Object run(JsonGeneratorString generatorString) {
        return random.nextBoolean();
    }
}
