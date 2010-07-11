package com.techtangents.oneof.core.onetomany.dispatch;

import com.techtangents.oneof.api.DefaultOne;
import com.techtangents.oneof.core.onetomany.target.DefaultOneOfMany;
import com.techtangents.oneof.types.value.OneOf;

import java.lang.reflect.InvocationHandler;

import static java.lang.reflect.Proxy.newProxyInstance;

public class OneOfValueFactory {

    public Object make(Object o, Class<? extends OneOf> cls, final Class... clarses) {
        OneOf many = new DefaultOneOfMany(o, clarses);
        InvocationHandler i = new Dispatcher(many);
        return newProxyInstance(DefaultOne.class.getClassLoader(), new Class[]{cls}, i);
    }
}