package com.mmcgarvey.jsongenerator.jsonfakers;

import com.mmcgarvey.jsongenerator.model.JsonGeneratorMethod;
import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;

import java.util.Arrays;
import java.util.List;

public class LoremFiller extends JsonFiller {

    @Override
    public List<String> getMethodNames() {
        return Arrays.asList("letter", "word", "sentence", "paragraph");
    }

    @Override
    public Class returns() {
        return String.class;
    }

    @Override
    public Object run(JsonGeneratorString generatorString) {
        String lorem;
        JsonGeneratorMethod generatorMethod = generatorString.getGeneratorMethod();
        Integer amount = getAmount(generatorMethod.getParameters());
        switch (generatorMethod.getName()) {
            case "letter":
                lorem = getLetter(amount);
                break;
            case "word":
                lorem = getWord(amount);
                break;
            case "sentence":
                lorem = getSentence(amount);
                break;
            case "paragraph":
                lorem = getParagraph(amount);
                break;
            default:
                return generatorString.getJsonString();
        }
        return replaceText(generatorString, lorem);
    }

    private String getLetter(Integer amount) {
        return faker.lorem().characters(amount, true);
    }

    private String getWord(Integer amount) {
        return String.join(" ", faker.lorem().words(amount));
    }

    private String getSentence(Integer amount) {
        return String.join(" ", faker.lorem().sentences(amount));
    }

    private String getParagraph(Integer amount) {
        return String.join("\n", faker.lorem().paragraphs(amount));
    }

    private Integer getAmount(List<String> parameters) {
        if (parameters.isEmpty() || parameters.size() > 1) {
            return 1;
        }
        try {
            Integer amount = Integer.parseInt(parameters.get(0));
            if (amount <= 0) {
                return 1;
            }
            return amount;
        } catch (Exception e) {
            return 1;
        }
    }
}
