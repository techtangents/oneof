package com.techtangents.oneof.types.value;

public interface OneOf {
    boolean is(Class cls);
    Object get();
    <Z> Z get(Class<Z> clarse);
}
