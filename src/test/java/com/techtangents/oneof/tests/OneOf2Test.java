package com.techtangents.oneof.tests;

import com.techtangents.oneof.api.DefaultOneOf;
import com.techtangents.oneof.api.OneOf;
import com.techtangents.oneof.values.OneOf2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class OneOf2Test {
    private final OneOf one = new DefaultOneOf();

    @Test
    public void test() {
        Object value = "hello";
        check(value, one.nu(value, String.class, Integer.class));
        check(value, one.of(String.class, Integer.class).nu(value));
    }

    private void check(Object value, OneOf2 one) {
        assertEquals(value, one.get());
        assertEquals(value, one.getA());

        try {
            one.getB();
            fail();
        } catch(ClassCastException expected) {
            //expected
        }

        assertEquals(true, one.isA());
        assertEquals(false, one.isB());

        assertEquals(true, one.is(String.class));
        assertEquals(false, one.is(Integer.class));
    }
}
