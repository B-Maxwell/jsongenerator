package com.mmcgarvey.jsongenerator.jsonfakers;

import java.util.Random;

public class PhoneNumberFiller extends JsonFiller {
    private static final Random random = new Random();

    @Override
    public String getName() {
        return "phoneNumber";
    }

    @Override
    public Object run(String text, String parameters, Integer start, Integer end) {
        System.out.println("Here");
        StringBuilder phoneNumberBuilder = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            if (i != 3 && i != 7) {
                phoneNumberBuilder.append(randomNum());
            } else {
                phoneNumberBuilder.append("-");
            }
        }
        return phoneNumberBuilder.toString();
    }

    private int randomNum() {
        return random.nextInt((10));
    }
}
