package com.techtangents.oneof.interfaces.value;

import com.techtangents.oneof.invoke.Fn;

public interface OneOf3<A, B, C> extends OneOf2<A, B> {
    boolean isC();
    C getC();
    <Out> Out invoke(Fn<A, Out> a, Fn<B, Out> b, Fn<C, Out> c);
}
