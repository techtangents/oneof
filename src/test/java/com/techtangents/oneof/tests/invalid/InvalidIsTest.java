package com.techtangents.oneof.tests.invalid;

import com.techtangents.oneof.api.DefaultOne;
import com.techtangents.oneof.api.One;
import com.techtangents.oneof.data.Frog;
import com.techtangents.oneof.types.value.OneOf2;
import org.junit.Test;

import static org.junit.Assert.fail;

public class InvalidIsTest {

    private final One one = new DefaultOne();
    private final OneOf2 oneOf2 = one.nu("", String.class, Frog.class);

    @Test
    public void test() {
        try {
            oneOf2.is(Double.class);
            fail();
        } catch(IllegalArgumentException expected){}
    }
}
