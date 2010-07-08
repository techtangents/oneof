package com.techtangents.oneof.iface;

public interface OneOf5<A, B, C, D, E> extends OneOf4<A, B, C, D> {
    boolean isE();
    E getE();
}
