package com.techtangents.oneof.core.onetomany.adapt;

import com.techtangents.oneof.types.value.OneOf;

public class IsMethodAdapter implements MethodAdapter {
    public Object adapt(OneOf many, String methodName, Object[] args) {
        Object v = args[0];
        if (v instanceof Class<?>) {
            return many.is((Class<?>) v);
        } else if (v instanceof Integer) {
            return many.is((Integer) v);
        }
        throw new UnsupportedOperationException();
    }
}