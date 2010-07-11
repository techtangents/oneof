package com.techtangents.oneof.demo;

import com.techtangents.oneof.api.DefaultOne;
import com.techtangents.oneof.api.One;
import com.techtangents.oneof.types.type.OneOf2Type;
import com.techtangents.oneof.types.value.OneOf2;

@SuppressWarnings({"ALL"})
public class MarshallDemo {
    private static final One one = new DefaultOne();

    public static class MyInvokee {
        public String stringThing(String input) { return "was a string"; }
        public String integerThing(Integer input) { return "was an integer"; }
    }

    public static void main(String[] args) {
        Object invokee = new MyInvokee();
        OneOf2Type<Integer, String> t = one.of(Integer.class, String.class);
        OneOf2<Integer, String> v = t.nu("some string");
        String output = v.marshall(String.class, invokee);
        System.out.println("output = " + output);
    }
}
