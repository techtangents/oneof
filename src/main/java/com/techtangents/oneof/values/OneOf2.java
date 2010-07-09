package com.techtangents.oneof.values;

public interface OneOf2<A, B> extends OneOf1<A> {
    B getB();
    boolean isB();
}
