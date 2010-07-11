package com.techtangents.oneof.core.value.methodadapters;

import com.techtangents.oneof.types.value.OneOf;

public class MarshallMethodAdapter implements MethodAdapter {
    public Object adapt(OneOf many, String methodName, Object[] args) {
        Class<?> returnType = (Class<?>) args[0];
        Object invokee = args[1];
        return many.marshall(returnType, invokee);
    }
}
