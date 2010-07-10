package com.techtangents.oneof.types.value;

import com.techtangents.oneof.invoke.Fn;

public interface OneOfMany {
    Object get(int i);
    Object get(Class clarse);
    Object get();

    Object is(int i);
    Object is(Class clarse);

    <Out> Out invoke(Fn<?, Out>[] args);
}
