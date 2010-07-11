package com.techtangents.oneof.core.value.methodadapters;

import com.techtangents.oneof.types.value.OneOf;

public class GetMethodAdapter implements MethodAdapter {
    public Object adapt(OneOf many, String methodName, Object[] args) {
        if (args != null && args.length == 1) {
            return getOneArg(many, args[0]);
        } else {
            return many.get();
        }
    }

    private Object getOneArg(OneOf many, Object arg) {
        if (arg instanceof Class<?>) {
            return many.get((Class<?>) arg);
        } else if (arg instanceof Integer) {
            return many.get((Integer) arg);
        }
        throw new UnsupportedOperationException();
    }
}