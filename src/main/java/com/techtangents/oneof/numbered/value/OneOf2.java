package com.techtangents.oneof.numbered.value;

import com.techtangents.oneof.invoke.Fn;

public interface OneOf2<A, B> extends OneOf1<A> {
    B getB();
    boolean isB();
    <Out> Out invoke(Fn<A, Out> a, Fn<B, Out> b);
}
