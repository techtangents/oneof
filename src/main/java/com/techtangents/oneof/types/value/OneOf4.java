package com.techtangents.oneof.types.value;

import com.techtangents.oneof.invoke.Fn;

public interface OneOf4<A, B, C, D> extends OneOf {
    boolean isA();
    boolean isB();
    boolean isC();
    boolean isD();
    A getA();
    B getB();
    C getC();
    D getD();
    <Out> Out invoke(Fn<A, Out> a, Fn<B, Out> b, Fn<C, Out> c, Fn<D, Out> d);
}
