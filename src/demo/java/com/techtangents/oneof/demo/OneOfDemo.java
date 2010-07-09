package com.techtangents.oneof.demo;

import com.techtangents.oneof.api.DefaultOneOf;
import com.techtangents.oneof.api.OneOf;
import com.techtangents.oneof.iface.OneOf2;


public class OneOfDemo {

    public static OneOf one = new DefaultOneOf();

    public static void main(String[] args) {

        Object o = "hello";
        OneOf2<String, Integer> container = one.nu(o, String.class, Integer.class);

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
