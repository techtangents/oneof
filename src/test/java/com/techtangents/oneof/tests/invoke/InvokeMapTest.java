package com.techtangents.oneof.tests.invoke;

import com.techtangents.oneof.api.DefaultOneOf;
import com.techtangents.oneof.api.OneOf;
import com.techtangents.oneof.invoke.Fn;
import com.techtangents.oneof.types.OneOf2Type;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvokeMapTest {

    private final OneOf one = new DefaultOneOf();

    @Test
    public void test() {

        Fn<String, String> stringHandler = new Fn<String, String>() {
            public String apply(String s) {
                return "I am a string";
            }
        };
        Fn<Integer, String> integerHandler = new Fn<Integer, String>() {
            public String apply(Integer integer) {
                return "integers are funny";
            }
        };

//        SwitchMap2<String, String, Integer> m = new SwitchMap2<String, String, Integer>(
//                stringHandler,
//                integerHandler
//        );

        OneOf2Type<Integer, String> type = one.of(Integer.class, String.class);
//        SwitchMap2<String, Integer, String> m = type.switchMap(integerHandler, stringHandler);

        assertEquals("I am a string", type.nu("hello").invoke(integerHandler, stringHandler));
        assertEquals("integers are funny", type.nu(1234).invoke(integerHandler, stringHandler));
    }
}
