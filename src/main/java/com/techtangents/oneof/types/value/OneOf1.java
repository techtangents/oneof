package com.techtangents.oneof.types.value;

import com.techtangents.oneof.invoke.Fn;

public interface OneOf1<A> extends OneOf {
    boolean isA();
    A getA();
    <Out> Out invoke(Fn<A, Out> a);
}
