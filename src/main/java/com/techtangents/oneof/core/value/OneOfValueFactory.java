package com.techtangents.oneof.core.value;

import com.techtangents.oneof.api.DefaultOne;
import com.techtangents.oneof.types.value.OneOf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class OneOfValueFactory {
    private final Validator validator = new Validator();

    public Object make(Object o, Class<? extends OneOf> cls, final Class... clarses) {
        validator.validateObject(o, clarses);
        InvocationHandler i = new OneOfInvocationHandler(o, clarses);
        return Proxy.newProxyInstance(DefaultOne.class.getClassLoader(), new Class[]{cls}, i);
    }
}