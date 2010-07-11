package com.techtangents.oneof.core.value;

import com.techtangents.arraymangler.bits.ArrayCaster;
import com.techtangents.arraymangler.bits.DefaultArrayCaster;
import com.techtangents.oneof.core.value.methodadapters.*;
import com.techtangents.oneof.invoke.Fn;
import com.techtangents.oneof.types.value.OneOf;

class Adapter {

    private final ArrayCaster arrayCaster = new DefaultArrayCaster();
    private final SuffixMethodPicker picker = new SuffixMethodPicker();

    private final MethodAdapter isMethodAdapter = new IsMethodAdapter();
    private final MethodAdapter isXMethodAdapter = new IsXMethodAdapter();
    private final MethodAdapter getMethodAdapter = new GetMethodAdapter();
    private final MethodAdapter getXMethodAdapter = new GetXMethodAdapter();

    private final OneOf many;

    public Adapter(OneOf many) {
        this.many = many;
    }

    public Object is(String methodName, Object[] args) {
        return isMethodAdapter.adapt(many, methodName, args);
    }

    public Object isX(String methodName, Object[] args) {
        return isXMethodAdapter.adapt(many, methodName, args);
    }

    public Object get(String methodName, Object[] args) {
        return getMethodAdapter.adapt(many, methodName, args);
    }

    public Object getX(String methodName, Object[] args) {
        return getXMethodAdapter.adapt(many, methodName, args);
    }

    @SuppressWarnings("unchecked")
    public Object invoke(String methodName, Object[] args) {
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

    public Object marshall(String methodName, Object[] args) {
        Class<?> returnType = (Class<?>) args[0];
        Object invokee = args[1];
        return many.marshall(returnType, invokee);
    }
}
