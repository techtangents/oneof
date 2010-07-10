package com.techtangents.oneof.tests.invoke;

import com.techtangents.oneof.api.DefaultOneOf;
import com.techtangents.oneof.api.OneOf;
import com.techtangents.oneof.data.Chicken;
import com.techtangents.oneof.data.Donkey;
import com.techtangents.oneof.data.Frog;
import com.techtangents.oneof.invoke.Fn;
import com.techtangents.oneof.values.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvokeTest {

    private final OneOf one = new DefaultOneOf();

    private final Fn<String, String> stringHandler = new Fn<String, String>() {
        public String apply(String s) {
            return s;
        }
    };
    private final Fn<Integer, String> integerHandler = new Fn<Integer, String>() {
        public String apply(Integer integer) {
            return integer.toString();
        }
    };
    private final Fn<Frog, String> frogHandler = new Fn<Frog, String>() {
        public String apply(Frog frog) {
            return frog.toString();
        }
    };
    private final Fn<Donkey, String> donkeyHandler = new Fn<Donkey, String>() {
        public String apply(Donkey donkey) {
            return donkey.toString();
        }
    };
    private final Fn<Chicken, String> chickenHandler = new Fn<Chicken, String>() {
        public String apply(Chicken c) {
            return c.toString();
        }
    };


    @Test public void test1() {
        check1("1234", 1234);
    }

    private void check1(Object expected, Object o) {
        OneOf1<Integer> onesey = one.of(Integer.class).nu(o);
        assertEquals(expected, onesey.invoke(integerHandler));
    }

    @Test public void test2() {
        check2("hello", "hello");
        check2("1234", 1234);
    }

    private void check2(Object expected, Object o) {
        OneOf2<Integer,String> onesey = one.of(Integer.class, String.class).nu(o);
        assertEquals(expected, onesey.invoke(integerHandler, stringHandler));
    }

    @Test public void test3() {
        check3("ribbit", new Frog());
        check3("hello", "hello");
        check3("1234", 1234);
    }

    private void check3(Object expected, Object o) {
        OneOf3<Frog, Integer,String> onesey = one.of(Frog.class, Integer.class, String.class).nu(o);
        assertEquals(expected, onesey.invoke(frogHandler, integerHandler, stringHandler));
    }
    
    @Test public void test4() {
        check4("ribbit", new Frog());
        check4("donkey", new Donkey());
        check4("hello", "hello");
        check4("1234", 1234);
    }

    private void check4(Object expected, Object o) {
        OneOf4<Frog, Integer, Donkey, String> onesey = one.of(Frog.class, Integer.class, Donkey.class, String.class).nu(o);
        assertEquals(expected, onesey.invoke(frogHandler, integerHandler, donkeyHandler, stringHandler));
    }

    @Test public void test5() {
        check5("ribbit", new Frog());
        check5("donkey", new Donkey());
        check5("hello", "hello");
        check5("1234", 1234);
    }

    private void check5(Object expected, Object o) {
        OneOf5<Frog, Integer, Donkey, String, Chicken> onesey = one.of(Frog.class, Integer.class, Donkey.class, String.class, Chicken.class).nu(o);
        assertEquals(expected, onesey.invoke(frogHandler, integerHandler, donkeyHandler, stringHandler, chickenHandler));
    }

//        SwitchMap2<String, String, Integer> m = new SwitchMap2<String, String, Integer>(
//                stringHandler,
//                integerHandler
//        );
//        SwitchMap2<String, Integer, String> m = type.switchMap(integerHandler, stringHandler);
}
