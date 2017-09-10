package com.mmcgarvey.jsongenerator.jsonfakers;

import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BooleanFiller extends JsonFiller {

    @Override
    public List<String> getMethodNames() {
        return Collections.singletonList("boolean");
    }

    @Override
    public Object run(JsonGeneratorString generatorString) {
        return random.nextBoolean();
    }
}
