package com.techtangents.oneof.demo;

import com.techtangents.oneof.api.DefaultOneOf;
import com.techtangents.oneof.api.OneOf;
import com.techtangents.oneof.types.OneOf2Type;
import com.techtangents.oneof.values.OneOf2;


public class OneOfDemo {

    private static final OneOf one = new DefaultOneOf();

    public static void main(String[] args) {

        Object o = "hello";
        OneOf2Type<String, Integer> type = one.of(String.class, Integer.class);
        OneOf2<String, Integer> container = type.nu(o);

        System.out.println("container.get() = " + container.get());
        System.out.println("container.getA() = " + container.getA());
        System.out.println("container.get(String.class)) = " + container.get(String.class));

        try {
            container.getB();
        } catch (Exception e) {
            System.out.println("container.getB() = " + e.getClass());
        }

        try {
            container.get(Integer.class);
        } catch (Exception e) {
            System.out.println("container.get(Integer.class) " + e.getClass());
        }
    }
}
