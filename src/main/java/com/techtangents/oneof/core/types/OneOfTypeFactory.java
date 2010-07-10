package com.techtangents.oneof.core.types;

import com.techtangents.oneof.core.value.OneOfValueFactory;
import com.techtangents.oneof.interfaces.value.OneOf1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class OneOfTypeFactory {

    private final OneOfValueFactory f = new OneOfValueFactory();

    @SuppressWarnings("unchecked")
    public <T, V extends OneOf1> T make(Class<T> typeClass, Class<V> valueClass, Class... classes) {
        return (T) bake(typeClass, valueClass, classes);
    }

    private Object bake(Class typeClass, final Class<? extends OneOf1> valueClass, final Class[] classes) {
        return Proxy.newProxyInstance(valueClass.getClassLoader(), new Class[]{typeClass}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                if (methodName.equals("nu")) {
                    return f.make(args[0], valueClass, classes);
                }
                throw new UnsupportedOperationException();
            }
        });
    }

}
