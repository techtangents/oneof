package com.techtangents.oneof.types.value;

import com.techtangents.oneof.invoke.Fn;

public interface OneOf {
    boolean is(Class<?> cls);
    Object is(int i);

    Object get();
    Object get(int i);
    <Z> Z get(Class<Z> clarse);

    Object invoke(Fn[] args);
}
