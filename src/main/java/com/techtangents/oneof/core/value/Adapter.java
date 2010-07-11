package com.techtangents.oneof.core.value;

import com.techtangents.oneof.core.value.methodadapters.*;
import com.techtangents.oneof.types.value.OneOf;

class Adapter {

    private final MethodAdapter isMethodAdapter = new IsMethodAdapter();
    private final MethodAdapter isXMethodAdapter = new IsXMethodAdapter();
    private final MethodAdapter getMethodAdapter = new GetMethodAdapter();
    private final MethodAdapter getXMethodAdapter = new GetXMethodAdapter();
    private final MethodAdapter invokeMethodAdapter = new InvokeMethodAdapter();
    private final MethodAdapter marshallMethodAdapter = new MarshallMethodAdapter();

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

    public Object invoke(String methodName, Object[] args) {
        return invokeMethodAdapter.adapt(many, methodName, args);
    }

    public Object marshall(String methodName, Object[] args) {
        return marshallMethodAdapter.adapt(many, methodName, args);
    }
}
