package com.techtangents.oneof.values;

import com.techtangents.oneof.invoke.Fn;

public interface OneOf1<A> {

    boolean is(Class cls);

    Object get();
    <Z> Z get(Class<Z> clarse);

    boolean isA();
    A getA();

    <Out> Out invoke(Fn<A, Out> a);
}
