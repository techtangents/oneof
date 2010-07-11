package com.techtangents.oneof.core.value.methodadapters;

import com.techtangents.oneof.core.value.SuffixMethodPicker;
import com.techtangents.oneof.types.value.OneOf;

public class GetXMethodAdapter implements MethodAdapter {

    private final SuffixMethodPicker picker = new SuffixMethodPicker();

    public Object adapt(OneOf many, String methodName, Object[] args) {
        int i = picker.pick(methodName, "get");
        return many.get(i);
    }
}
