package com.techtangents.oneof.tests.invalid;

import com.techtangents.oneof.api.DefaultOneOf;
import com.techtangents.oneof.api.OneOf;
import com.techtangents.oneof.data.Chicken;
import com.techtangents.oneof.data.Frog;
import org.junit.Test;

import java.net.URL;

public class InvalidObjectTest {

    private final OneOf oneOf = new DefaultOneOf();

    @Test(expected=IllegalArgumentException.class)
    public void test1() {
        oneOf.nu("", Integer.class);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test2() {
        oneOf.nu("", Integer.class, Frog.class);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test3() {
        oneOf.nu("", Integer.class, Frog.class, Chicken.class);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test4() {
        oneOf.nu("", Integer.class, Frog.class, Chicken.class, URL.class);
    }
}
