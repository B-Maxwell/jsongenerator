package com.mmcgarvey.jsongenerator.jsonfaker;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BooleanFillerTest {

    @Test
    public void booleanFillerReturnsBoolean() {
        assertTrue(new BooleanFiller().run(null) instanceof Boolean);
    }
}
