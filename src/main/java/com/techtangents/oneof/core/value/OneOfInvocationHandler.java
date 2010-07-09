package com.techtangents.oneof.core.value;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class OneOfInvocationHandler implements InvocationHandler {

    private final Validator validator = new Validator();

    private final Object o;
    private final Class[] clarses;

    public OneOfInvocationHandler(Object o, Class[] clarses) {
        this.o = o;
        this.clarses = clarses;
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        return handle(o, method, args);
    }

    private Object handle(Object o, Method method, Object[] args) {
        String methodName = method.getName();

        if (methodName.equals("is")) {
            return is(o, (Class) args[0]);
        } else if (methodName.startsWith("is")) {
            return isX(o, methodName);
        } else if (methodName.equals("get")) {
            return get(o, args);
        } else if (methodName.startsWith("get")) {
            return getX(o, methodName);
        }

        throw new UnsupportedOperationException();
    }

    private Object get(Object o, Object[] args) {
        if (args != null && args.length == 1) {
            Class clarse = (Class) args[0];
            validator.validateCast(o, clarse);
        }
        return o;
    }

    private Object getX(Object o, String methodName) {
        Class clarse = pickClass(methodName, "get");
        return clarse.cast(o);
    }

    private Object isX(Object o, String methodName) {
        Class clarse = pickClass(methodName, "is");
        return is(o, clarse);
    }

    private Class pickClass(String methodName, String prefix) {
        String suffix = removePrefix(methodName, prefix);
        int index = suffix.charAt(0) - 'A';
        return clarses[index];
    }

    private String removePrefix(String s, String prefix) {
        return s.startsWith(prefix)
                ? s.substring(prefix.length())
                : s;
    }

    private Object is(Object o, Class clarse) {
        validator.validateClass(clarse, clarses);
        return validator.isValidCast(o, clarse);
    }
}
