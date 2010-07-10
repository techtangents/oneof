package com.techtangents.oneof.types.value;

import com.techtangents.oneof.invoke.Fn;

public interface OneOf5<A, B, C, D, E> extends OneOf {
    boolean isA();
    boolean isB();
    boolean isC();
    boolean isD();
    boolean isE();
    A getA();
    B getB();
    C getC();
    D getD();
    E getE();
    <Out> Out invoke(Fn<A, Out> a, Fn<B, Out> b, Fn<C, Out> c, Fn<D, Out> d, Fn<E, Out> e);
}
