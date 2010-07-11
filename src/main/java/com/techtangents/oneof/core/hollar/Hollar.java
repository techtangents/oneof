package com.techtangents.oneof.core.hollar;

import com.techtangents.oneof.core.validator.Validator;
import com.techtangents.oneof.edge.java.lang.MethodEdge;

import java.lang.reflect.Method;

public class Hollar {

    private final MethodEdge methodEdge = new MethodEdge();
    private final Validator validator = new Validator();

    public <Out> Out marshall(Class<Out> returnType, Object invokee, Class paramType, Object o) {
        Method m = pickMethod(invokee, paramType);
        Object r = methodEdge.invoke(m, invokee, o);
        return returnType.cast(r);
    }

    private Method pickMethod(Object invokee, Class actualClass) {
        Method[] methods = invokee.getClass().getMethods();
        for (Method m : methods) {
            Class<?>[] pTypes = m.getParameterTypes();
            if (isSuitable(pTypes, actualClass)) {
                return m;
            }
        }
        throw new IllegalArgumentException("Invokee does not have a method with one argument of type: " + actualClass);
    }

    private boolean isSuitable(Class<?>[] pTypes, Class actualClass) {
        return pTypes.length == 1 && validator.isValidCast(actualClass, pTypes[0]);
    }
}
