package com.techtangents.oneof.edge.java.lang;

import java.lang.reflect.Method;

public class MethodEdge {
    public Object invoke(Method method, Object o, Object... args) {
        try {
            return method.invoke(o, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
