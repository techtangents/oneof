package com.techtangents.oneof.core.value;

import com.techtangents.oneof.types.value.OneOf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class Dispatcher implements InvocationHandler {

    private final Adapter adapter;

    public Dispatcher(OneOf many) {
        adapter = new Adapter(many);
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        return handle(method, args);
    }

    private Object handle(Method method, Object[] args) {
        String methodName = method.getName();

        if (methodName.equals("is"))           return adapter.is(args);
        else if (methodName.startsWith("is"))  return adapter.is(methodName);
        else if (methodName.equals("get"))     return adapter.get(args);
        else if (methodName.startsWith("get")) return adapter.getX(methodName);
        else if (methodName.equals("invoke"))  return adapter.invoke(args);

        throw new UnsupportedOperationException();
    }

}