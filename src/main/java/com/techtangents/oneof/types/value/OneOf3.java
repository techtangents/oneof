package com.techtangents.oneof.types.value;

import com.techtangents.oneof.invoke.Fn;

public interface OneOf3<A, B, C> extends OneOf {
    boolean isA();
    boolean isB();
    boolean isC();
    A getA();
    B getB();
    C getC();
    <Out> Out invoke(Fn<A, Out> a, Fn<B, Out> b, Fn<C, Out> c);
}
