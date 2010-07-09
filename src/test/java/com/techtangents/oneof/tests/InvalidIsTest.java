package com.techtangents.oneof.tests;

import com.techtangents.oneof.api.DefaultOneOf;
import com.techtangents.oneof.api.OneOf;
import com.techtangents.oneof.data.Frog;
import com.techtangents.oneof.values.OneOf2;
import org.junit.Test;

import static org.junit.Assert.fail;

public class InvalidIsTest {

    private final OneOf oneOf = new DefaultOneOf();
    OneOf2 one = oneOf.nu("", String.class, Frog.class);

    @Test
    public void test() {
        try {
            one.is(Double.class);
            fail();
        } catch(IllegalArgumentException expected){}
    }
}
