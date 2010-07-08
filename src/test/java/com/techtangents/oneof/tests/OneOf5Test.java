package com.techtangents.oneof.tests;

import com.techtangents.oneof.api.DefaultOneOf;
import com.techtangents.oneof.api.OneOf;
import com.techtangents.oneof.data.Chicken;
import com.techtangents.oneof.data.Donkey;
import com.techtangents.oneof.data.Frog;
import com.techtangents.oneof.iface.OneOf5;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class OneOf5Test {
    private final OneOf oneOf = new DefaultOneOf();

    @Test
    public void test() {
        Object value = new Frog();
        OneOf5 one = oneOf.of(value, String.class, Integer.class, Chicken.class, Frog.class, Donkey.class);

        assertEquals(value, one.get());

        try {
            one.getA();
            fail();
        } catch(ClassCastException expected) {}

        try {
            one.getB();
            fail();
        } catch(ClassCastException expected) {}

        try {
            one.getC();
            fail();
        } catch(ClassCastException expected) {}

        assertEquals(value, one.getD());

        try {
            one.getC();
            fail();
        } catch(ClassCastException expected) {}

        assertEquals(false, one.isA());
        assertEquals(false, one.isB());
        assertEquals(false, one.isC());
        assertEquals(true, one.isD());
        assertEquals(false, one.isE());

        assertEquals(true, one.is(Frog.class));
        assertEquals(false, one.is(Integer.class));
        assertEquals(false, one.is(Chicken.class));
        assertEquals(false, one.is(Donkey.class));
    }
}
