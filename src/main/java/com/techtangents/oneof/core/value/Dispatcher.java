package com.techtangents.oneof.core.value;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class Dispatcher implements InvocationHandler {

    private final Adapter adapter;

    public Dispatcher(Adapter adapter) {
        this.adapter = adapter;
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        return handle(method, args);
    }

    private Object handle(Method method, Object[] args) {
        String methodName = method.getName();

        if (methodName.equals("is"))            return adapter.is(methodName, args);
        else if (methodName.startsWith("is"))   return adapter.isX(methodName, args);
        else if (methodName.equals("get"))      return adapter.get(methodName, args);
        else if (methodName.startsWith("get"))  return adapter.getX(methodName, args);
        else if (methodName.equals("invoke"))   return adapter.invoke(methodName, args);
        else if (methodName.equals("marshall")) return adapter.marshall(methodName, args);

        throw new UnsupportedOperationException();
    }

}
