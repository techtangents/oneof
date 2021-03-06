package com.techtangents.oneof.demo;

import com.techtangents.oneof.api.DefaultOne;
import com.techtangents.oneof.api.One;
import com.techtangents.oneof.invoke.Fn;
import com.techtangents.oneof.types.type.OneOf2Type;
import com.techtangents.oneof.types.value.OneOf2;

public class InvokeDemo {
    private static final One ONE = new DefaultOne();

    public static void main(String[] args) {
        Object x = "hello";

        Fn<String, String> fnString = new Fn<String, String>() {
            public String apply(String s) {
                return "it's a string";
            }
        };
        Fn<Integer, String> fnInteger = new Fn<Integer, String>() {
            public String apply(Integer s) {
                return "it's an integer: " + s.toString();
            }
        };

        OneOf2Type<String, Integer> t = ONE.of(String.class, Integer.class);
        OneOf2<String, Integer> v = t.nu(x);
        String result = v.invoke(fnString, fnInteger);

        System.out.println("result = " + result);
    }
}
