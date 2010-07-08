package com.techtangents.oneof.iface;

public interface OneOf4<A, B, C, D> extends OneOf3<A, B, C> {
    boolean isD();
    D getD();
}
