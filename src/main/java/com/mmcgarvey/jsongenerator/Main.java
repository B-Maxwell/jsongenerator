package com.mmcgarvey.jsongenerator;

import java.io.IOException;

public class Main {

    private static final String jsonObjectString =
            "{" +
                    "\"name\": \"{{ name() }}\", " +
                    "\"age\": \"{{ integer() }}\", " +
                    "\"friends\": [" +
                        "\"{{ name() }}\"," +
                        "\"{{ name() }}\"" +
                    "]," +
                    "\"contact\": {" +
                        "\"name\": \"{{ name() }}\", " +
                        "\"number\": \"{{ phoneNumber() }}\", " +
                        "\"family_member\": true" +
                    "}" +
            "}";

    private static final String jsonArrayString =
            "[" +
                    "\"hello\"," +
                    "\"goodbye\"" +
            "]";

    public static void main(String[] args) throws IOException {
        JsonParser jsonParser = new JsonParser();
        String json = jsonParser.parse(jsonObjectString);
        System.out.println(json);

        System.out.println(jsonParser.parse(jsonArrayString));
    }
}
