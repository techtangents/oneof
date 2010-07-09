package com.techtangents.oneof.values;

public interface OneOf3<A, B, C> extends OneOf2<A, B> {
    boolean isC();
    C getC();
}
