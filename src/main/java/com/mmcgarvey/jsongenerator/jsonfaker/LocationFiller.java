package com.mmcgarvey.jsongenerator.jsonfaker;

import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.Arrays;
import java.util.List;

public class LocationFiller extends JsonFiller {

    @Override
    public List<String> getMethodNames() {
        return Arrays.asList("street", "city", "state", "country", "stateAbbrev");
    }

    @Override
    public Class returns() {
        return String.class;
    }

    @Override
    public Object run(JsonGeneratorString generatorString) {
        String location;
        switch (generatorString.getGeneratorMethod().getName()) {
            case "street":
                location = faker.address().streetAddress();
                break;
            case "city":
                location = faker.address().city();
                break;
            case "state":
                location = faker.address().state();
                break;
            case "country":
                location = faker.address().country();
                break;
            case "stateAbbrev":
                location = faker.address().stateAbbr();
                break;
            default:
                return generatorString.getJsonString();
        }
        return replaceText(generatorString, location);
    }
}
