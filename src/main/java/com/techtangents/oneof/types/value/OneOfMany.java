package com.techtangents.oneof.types.value;

import com.techtangents.oneof.invoke.Fn;

public interface OneOfMany extends OneOf {
    Object get(int i);
    Object get();

    Object is(int i);

    <Out> Out invoke(Fn<?, Out>[] args);
}
