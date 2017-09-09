package com.mmcgarvey.jsongenerator;

import com.fasterxml.jackson.databind.JsonNode;
import com.mmcgarvey.jsongenerator.jsonfakers.IntegerFiller;
import com.mmcgarvey.jsongenerator.jsonfakers.JsonFiller;
import com.mmcgarvey.jsongenerator.jsonfakers.NameFiller;
import com.mmcgarvey.jsongenerator.jsonfakers.PhoneNumberFiller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser implements JsonTypeParser {
    private static final Pattern method = Pattern.compile("\\{\\{\\s([a-zA-Z]*)\\((.*?)\\)\\s?}}");
    private static final Map<String, JsonFiller> fillers = new HashMap<>();

    public static void addFiller(JsonFiller filler) {
        fillers.put(filler.getName(), filler);
    }

    static {
        addFiller(new NameFiller());
        addFiller(new IntegerFiller());
        addFiller(new PhoneNumberFiller());
    }


    @Override
    public Object parse(JsonNode node) {
        String text = node.asText();
        Matcher potentialMatch = method.matcher(text);
        if (potentialMatch.find()) {
            String method = potentialMatch.group(1);
            String parameters = potentialMatch.group(2);
            Integer start = potentialMatch.start();
            Integer end = potentialMatch.end();
            return fill(text, method, parameters, start, end);
        }
        return text;
    }

    private Object fill(String text, String method, String parameters, Integer start, Integer end) {
        JsonFiller filler = fillers.get(method);
        if (filler == null) {
            return text;
        }
        return filler.run(text, parameters, start, end);
    }
}
