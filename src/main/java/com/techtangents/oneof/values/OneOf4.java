package com.techtangents.oneof.values;

import com.techtangents.oneof.invoke.Fn;

public interface OneOf4<A, B, C, D> extends OneOf3<A, B, C> {
    boolean isD();
    D getD();
    <Out> Out invoke(Fn<A, Out> a, Fn<B, Out> b, Fn<C, Out> c, Fn<D, Out> d);
}
