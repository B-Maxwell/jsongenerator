package com.mmcgarvey.jsongenerator.jsonfakers;

import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.Arrays;
import java.util.List;

public class NameFiller extends JsonFiller {

    @Override
    public List<String> getMethodNames() {
        return Arrays.asList("firstName", "lastName", "fullName");
    }

    @Override
    public Class returns() {
        return String.class;
    }

    @Override
    public Object run(JsonGeneratorString generatorString) {
        String name;
        switch (generatorString.getGeneratorMethod().getName()) {
            case "firstName":
                name = faker.name().firstName();
                break;
            case "lastName":
                name = faker.name().lastName();
                break;
            case "fullName":
                name = faker.name().fullName();
                break;
            default:
                return generatorString.getJsonString();
        }
        return replaceText(generatorString, name);
    }
}
