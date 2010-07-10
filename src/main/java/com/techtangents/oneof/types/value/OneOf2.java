package com.techtangents.oneof.types.value;

import com.techtangents.oneof.invoke.Fn;

public interface OneOf2<A, B> extends OneOf {
    boolean isA();
    boolean isB();
    A getA();
    B getB();
    <Out> Out invoke(Fn<A, Out> a, Fn<B, Out> b);
}
