package com.techtangents.oneof.types.value;

import com.techtangents.oneof.invoke.Fn;

public interface OneOf {
    boolean is(Class cls);
    Object get();
    <Z> Z get(Class<Z> clarse);
    Object invoke(Fn[] args);
}
