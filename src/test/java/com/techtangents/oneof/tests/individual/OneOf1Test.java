package com.techtangents.oneof.tests.individual;

import com.techtangents.oneof.api.DefaultOneOf;
import com.techtangents.oneof.api.OneOf;
import com.techtangents.oneof.values.OneOf1;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class OneOf1Test {
    private final OneOf one = new DefaultOneOf();

    @Test
    public void test() {
        Object value = "hello";
        check(value, one.nu(value, String.class));
        check(value, one.of(String.class).nu(value));
    }

    private void check(Object value, OneOf1<String> one) {
        assertEquals(value, one.get());
        assertEquals(value, one.getA());

        assertEquals(true, one.isA());

        assertEquals(true, one.is(String.class));

        try {
            assertEquals(false, one.is(Integer.class));
            fail();
        } catch(IllegalArgumentException e){
            //expected
        }
    }
}
