package com.techtangents.oneof.types.value;

public interface OneOfMany extends OneOf {
    Object get(int i);
    Object get();
    Object is(int i);
}
