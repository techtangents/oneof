package com.techtangents.oneof.interfaces.value;

import com.techtangents.oneof.invoke.Fn;

public interface OneOf5<A, B, C, D, E> extends OneOf4<A, B, C, D> {
    boolean isE();
    E getE();
    <Out> Out invoke(Fn<A, Out> a, Fn<B, Out> b, Fn<C, Out> c, Fn<D, Out> d, Fn<E, Out> e);
}
