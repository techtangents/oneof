package com.techtangents.oneof.core.value;

import com.techtangents.oneof.api.DefaultOneOf;
import com.techtangents.oneof.numbered.value.OneOf1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class OneOfValueFactory {
    private final Validator validator = new Validator();

    public Object make(Object o, Class<? extends OneOf1> cls, final Class... clarses) {
        validator.validateObject(o, clarses);
        InvocationHandler i = new OneOfInvocationHandler(o, clarses);
        return Proxy.newProxyInstance(DefaultOneOf.class.getClassLoader(), new Class[]{cls}, i);
    }
}