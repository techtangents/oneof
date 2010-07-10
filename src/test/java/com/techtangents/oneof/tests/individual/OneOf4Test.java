package com.techtangents.oneof.tests.individual;

import com.techtangents.oneof.api.DefaultOneOf;
import com.techtangents.oneof.api.OneOf;
import com.techtangents.oneof.data.Chicken;
import com.techtangents.oneof.data.Frog;
import com.techtangents.oneof.numbered.value.OneOf4;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class OneOf4Test {
    private final OneOf one = new DefaultOneOf();

    @Test
    public void test() {
        Object value = new Frog();
        check(value, one.nu(value, String.class, Integer.class, Chicken.class, Frog.class));
        check(value, one.of(String.class, Integer.class, Chicken.class, Frog.class).nu(value));
    }

    private void check(Object value, OneOf4 one) {
        assertEquals(value, one.get());

        try {
            one.getA();
            fail();
        } catch (Exception expected) {
            //expected
        }

        try {
            one.getB();
            fail();
        } catch (Exception expected) {
            //expected
        }

        try {
            one.getC();
            fail();
        } catch (Exception expected) {
            //expected
        }


        assertEquals(value, one.getD());

        assertEquals(false, one.isA());
        assertEquals(false, one.isB());
        assertEquals(false, one.isC());
        assertEquals(true, one.isD());

        assertEquals(true, one.is(Frog.class));
        assertEquals(false, one.is(Integer.class));
        assertEquals(false, one.is(Chicken.class));
    }
}
