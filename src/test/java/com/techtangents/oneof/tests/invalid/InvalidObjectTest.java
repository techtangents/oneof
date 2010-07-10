package com.techtangents.oneof.tests.invalid;

import com.techtangents.oneof.api.DefaultOne;
import com.techtangents.oneof.api.One;
import com.techtangents.oneof.data.Chicken;
import com.techtangents.oneof.data.Frog;
import org.junit.Test;

import java.net.URL;

public class InvalidObjectTest {

    private final One one = new DefaultOne();

    @Test(expected=IllegalArgumentException.class)
    public void test1() {
        one.nu("", Integer.class);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test2() {
        one.nu("", Integer.class, Frog.class);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test3() {
        one.nu("", Integer.class, Frog.class, Chicken.class);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test4() {
        one.nu("", Integer.class, Frog.class, Chicken.class, URL.class);
    }
}
