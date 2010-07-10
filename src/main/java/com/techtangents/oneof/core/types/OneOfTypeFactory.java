package com.techtangents.oneof.core.types;

import com.techtangents.oneof.core.value.OneOfValueFactory;
import com.techtangents.oneof.types.value.OneOf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static java.lang.reflect.Proxy.newProxyInstance;

public class OneOfTypeFactory {

    private final OneOfValueFactory f = new OneOfValueFactory();

    @SuppressWarnings("unchecked")
    public <T, V extends OneOf> T make(Class<T> typeClass, Class<V> valueClass, Class... classes) {
        return (T) bake(typeClass, valueClass, classes);
    }

    private Object bake(Class typeClass, final Class<? extends OneOf> valueClass, final Class[] classes) {
        return newProxyInstance(valueClass.getClassLoader(), new Class[]{typeClass}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                if (methodName.equals("nu"))
                    return f.make(args[0], valueClass, classes);
                throw new UnsupportedOperationException();
            }
        });
    }

}
