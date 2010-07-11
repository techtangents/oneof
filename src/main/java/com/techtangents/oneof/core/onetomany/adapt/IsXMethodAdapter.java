package com.techtangents.oneof.core.onetomany.adapt;

import com.techtangents.oneof.types.value.OneOf;

public class IsXMethodAdapter implements MethodAdapter {

    private final SuffixMethodPicker picker = new SuffixMethodPicker();

    public Object adapt(OneOf many, String methodName, Object[] args) {
        int i = picker.pick(methodName, "is");
        return many.is(i);
    }
}
