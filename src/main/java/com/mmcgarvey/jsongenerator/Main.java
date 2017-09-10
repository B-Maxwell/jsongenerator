package com.mmcgarvey.jsongenerator;

import java.io.IOException;

public class Main {

    private static final String jsonObjectString =
            "{" +
                    "\"name\": \"{{ fullName() }}\", " +
                    "\"age\": \"{{ integer(1,60) }}\", " +
                    "\"friends\": [" +
                        "\"{{ repeat(5) }}\"," +
                        "\"{{ fullName() }}\"" +
                    "]," +
                    "\"contact\": {" +
                        "\"name\": \"{{ fullName() }}\"," +
                        "\"number\": \"{{ phoneNumber() }}\"," +
                        "\"family_member\": \"{{ boolean() }}\"," +
                        "\"email\": \"{{ email() }}\"" +
                    "}, " +
                    "\"website\": \"{{ url() }}\"," +
                    "\"hometown\": \"{{ city() }}\"," +
                    "\"state\": \"{{ stateAbbrev() }}\"" +
            "}";

    private static final String jsonArrayString =
            "[" +
                    "\"{{ word() }}\"," +
                    "\"{{ letter(6) }}\"," +
                    "\"{{ firstName() }}\"," +
                    "\"{{ lastName() }}\"" +
            "]";

    public static void main(String[] args) throws IOException {
        JsonParser jsonParser = new JsonParser();
        String json = jsonParser.parse(jsonObjectString);
        System.out.println(json);

        System.out.println(jsonParser.parse(jsonArrayString));
    }
}
