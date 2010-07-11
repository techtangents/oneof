package com.techtangents.oneof.core.value.methodadapters;

import com.techtangents.arraymangler.bits.ArrayCaster;
import com.techtangents.arraymangler.bits.DefaultArrayCaster;
import com.techtangents.oneof.invoke.Fn;
import com.techtangents.oneof.types.value.OneOf;

public class InvokeMethodAdapter implements MethodAdapter {

    private final ArrayCaster arrayCaster = new DefaultArrayCaster();

    public Object adapt(OneOf many, String methodName, Object[] args) {
        Fn[] fns = getInvokeArgs(args);
        return many.invoke(fns);
    }

    private Fn[] getInvokeArgs(Object[] args) {
        if (arg1IsArray(args)) return (Fn[]) args[0];
        return arrayCaster.cast(Fn.class, args);
    }

    private boolean arg1IsArray(Object[] args) {
        return args.length == 1 && args[0].getClass().isArray();
    }
}
