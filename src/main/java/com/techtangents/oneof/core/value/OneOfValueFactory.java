package com.techtangents.oneof.core.value;

import com.techtangents.oneof.api.DefaultOne;
import com.techtangents.oneof.core.many.DefaultOneOfMany;
import com.techtangents.oneof.types.value.OneOf;

import java.lang.reflect.InvocationHandler;

import static java.lang.reflect.Proxy.newProxyInstance;

public class OneOfValueFactory {

    public Object make(Object o, Class<? extends OneOf> cls, final Class... clarses) {
        OneOf many = new DefaultOneOfMany(o, clarses);
        Adapter adapter = new Adapter(many);
        InvocationHandler i = new Dispatcher(adapter);
        return newProxyInstance(DefaultOne.class.getClassLoader(), new Class[]{cls}, i);
    }
}