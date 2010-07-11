package com.techtangents.oneof.core.onetomany.dispatch;

import com.techtangents.oneof.core.onetomany.adapt.*;
import com.techtangents.oneof.types.value.OneOf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class Dispatcher implements InvocationHandler {

    private final MethodAdapter is = new IsMethodAdapter();
    private final MethodAdapter isX = new IsXMethodAdapter();
    private final MethodAdapter get = new GetMethodAdapter();
    private final MethodAdapter getX = new GetXMethodAdapter();
    private final MethodAdapter invoke = new InvokeMethodAdapter();
    private final MethodAdapter marshall = new MarshallMethodAdapter();

    private final OneOf many;

    public Dispatcher(OneOf many) {
        this.many = many;
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        return handle(method, args);
    }

    private Object handle(Method method, Object[] args) {
        String methodName = method.getName();
        MethodAdapter adapter = pick(methodName);
        return adapter.adapt(many, methodName, args);
    }

    private MethodAdapter pick(String methodName) {
        if (methodName.equals("is")) return is;
        else if (methodName.startsWith("is")) return isX;
        else if (methodName.equals("get")) return get;
        else if (methodName.startsWith("get")) return getX;
        else if (methodName.equals("invoke")) return invoke;
        else if (methodName.equals("marshall")) return marshall;
        throw new UnsupportedOperationException();
    }

}
