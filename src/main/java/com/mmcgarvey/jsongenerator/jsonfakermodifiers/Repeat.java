package com.mmcgarvey.jsongenerator.jsonfakermodifiers;

import com.fasterxml.jackson.databind.JsonNode;
import com.mmcgarvey.jsongenerator.model.JsonGeneratorString;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Repeat implements JsonArrayModifier {
    @Override
    public String getName() {
        return "repeat";
    }

    @Override
    public JsonNode modify(JsonNode node, JsonGeneratorString modifier) {
        throw new NotImplementedException();
    }

    @Override
    public List<JsonNode> modifyArray(JsonNode node, JsonGeneratorString modifier) {
        List<JsonNode> repeats = new ArrayList<>();
        repeats.add(node);
        List<String> parameters = modifier.getGeneratorMethod().getParameters();
        if (parameters.size() > 1) {
            return repeats;
        }

        Integer repeatAmount;

        if (!parameters.isEmpty()) {
            try {
                repeatAmount = Integer.parseInt(parameters.get(0));
            } catch (NumberFormatException e) {
                return repeats;
            }
        } else {
            repeatAmount = 1;
        }


        for (int i = 0; i < repeatAmount - 1; i++) {
            repeats.add(node.deepCopy());
        }
        return repeats;
    }
}
