package com.techtangents.oneof.core.value;

import com.techtangents.oneof.api.DefaultOne;
import com.techtangents.oneof.types.value.OneOf;

import java.lang.reflect.InvocationHandler;

import static java.lang.reflect.Proxy.newProxyInstance;

public class OneOfValueFactory {

    public Object make(Object o, Class<? extends OneOf> cls, final Class... clarses) {
        InvocationHandler i = new OneOfInvocationHandler(o, clarses);
        return newProxyInstance(DefaultOne.class.getClassLoader(), new Class[]{cls}, i);
    }
}