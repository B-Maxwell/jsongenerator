package com.mmcgarvey.jsongenerator.jsonfaker;

import com.mmcgarvey.jsongenerator.model.JsonGeneratorMethod;
import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.Arrays;
import java.util.List;

public class NumberFiller extends JsonFiller {

    @Override
    public List<String> getMethodNames() {
        return Arrays.asList("integer", "double");
    }

    @Override
    public Class returns() {
        return Number.class;
    }

    @Override
    public Object run(JsonGeneratorString generatorString) {
        Integer min = null;
        Integer max = null;
        JsonGeneratorMethod generatorMethod = generatorString.getGeneratorMethod();
        List<String> parameters = generatorMethod.getParameters();
        if (!parameters.isEmpty()) {
            if (generatorMethod.getName().equals("double")
                    || parameters.size() > 2) {
                return generatorString.getJsonString();
            }
            if (parameters.size() == 2) {
                min = Integer.parseInt(parameters.get(0));
                max = Integer.parseInt(parameters.get(1));
            } else {
                max = Integer.parseInt(parameters.get(0));
            }
        }
        switch (generatorMethod.getName()) {
            case "integer":
                return getInt(min, max);
            case "double":
                return getDouble();
            default:
                return generatorString.getJsonString();
        }
    }

    private Integer getInt(Integer min, Integer max) {
        if (max != null) {
            if (min != null) {
                return random.nextInt((max - min) + 1) + min;
            }
            return random.nextInt(max);
        }
        return random.nextInt();
    }

    private Double getDouble() {
        return random.nextDouble();
    }
}
