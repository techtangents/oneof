package com.techtangents.oneof.tests.individual;

import com.techtangents.oneof.api.DefaultOne;
import com.techtangents.oneof.api.One;
import com.techtangents.oneof.types.value.OneOf1;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class OneOf1Test {
    private final One one = new DefaultOne();

    @Test
    public void test() {
        Object value = "hello";
        check(value, one.nu(value, String.class));
        check(value, one.of(String.class).nu(value));
    }

    private void check(Object value, OneOf1<String> one) {
        assertEquals(value, one.get());
        assertEquals(value, one.getA());
        assertEquals(value, one.get(0));

        assertEquals(true, one.isA());

        assertEquals(true, one.is(String.class));

        try {
            assertEquals(false, one.is(Integer.class));
            fail();
        } catch(Exception e){
            //expected
        }

        try {
            assertEquals(false, one.is(1));
            fail();
        } catch(Exception e){
            //expected
        }

        try {
            assertEquals(false, one.get(1));
            fail();
        } catch(Exception e){
            //expected
        }
    }
}
