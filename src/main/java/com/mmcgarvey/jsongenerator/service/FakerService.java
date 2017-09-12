package com.mmcgarvey.jsongenerator.service;

import com.github.javafaker.Faker;
import com.mmcgarvey.jsongenerator.model.Fakeable;

public class FakerService {
    private static Fakeable faker;

    public void setFaker(Fakeable faker) {
        FakerService.faker = faker;
    }

    public Faker getFaker() {
        return new Faker();
    }
}
