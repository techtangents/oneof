package com.techtangents.oneof.tests;

import com.techtangents.oneof.api.DefaultOneOf;
import com.techtangents.oneof.api.OneOf;
import com.techtangents.oneof.values.OneOf2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class OneOf2Test {
    private final OneOf oneOf = new DefaultOneOf();

    @Test
    public void test() {
        Object value = "hello";
        OneOf2 one = oneOf.nu(value, String.class, Integer.class);

        assertEquals(value, one.get());
        assertEquals(value, one.getA());

        try {
            one.getB();
            fail();
        } catch(ClassCastException expected) {}

        assertEquals(true, one.isA());
        assertEquals(false, one.isB());

        assertEquals(true, one.is(String.class));
        assertEquals(false, one.is(Integer.class));
    }
}
