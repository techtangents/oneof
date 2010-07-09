package com.techtangents.oneof.values;

import java.util.Map;

public interface OneOf1<A> {

    boolean is(Class cls);

    Object get();
    <Z> Z get(Class<Z> clarse);

    boolean isA();
    A getA();

    // FIX not sure how to handle this guy
    <Q> Object invoke(Map<Class, Object> m, String methodName, Class<Q> returnType);
}
