package com.techtangents.oneof.core.value.methodadapters;

import com.techtangents.oneof.types.value.OneOf;

public interface MethodAdapter {
    Object adapt(OneOf many, String methodName, Object[] args);
}
