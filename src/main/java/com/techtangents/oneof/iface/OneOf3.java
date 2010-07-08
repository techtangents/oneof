package com.techtangents.oneof.iface;

public interface OneOf3<A, B, C> extends OneOf2<A, B> {
    boolean isC();
    C getC();
}
