package com.techtangents.oneof.demo;

import com.techtangents.oneof.api.DefaultOne;
import com.techtangents.oneof.api.One;
import com.techtangents.oneof.types.type.OneOf2Type;
import com.techtangents.oneof.types.value.OneOf2;


public class BasicDemo {

    private static final One ONE = new DefaultOne();

    public static void main(String[] args) {
        Object o = "hello";
        OneOf2Type<String, Integer> type = ONE.of(String.class, Integer.class);
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
