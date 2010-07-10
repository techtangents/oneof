package com.techtangents.oneof.core.value;

import com.techtangents.arraymangler.bits.ArrayCaster;
import com.techtangents.arraymangler.bits.DefaultArrayCaster;
import com.techtangents.oneof.core.string.Violin;
import com.techtangents.oneof.invoke.Fn;
import com.techtangents.oneof.types.value.DefaultOneOfMany;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class OneOfInvocationHandler implements InvocationHandler {

    private final Violin violin = new Violin();
    private final ArrayCaster arrayCaster = new DefaultArrayCaster();
    
    private final DefaultOneOfMany many;

    public OneOfInvocationHandler(Object o, Class[] clarses) {
        many = new DefaultOneOfMany(o, clarses);
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        return handle(method, args);
    }

    private Object handle(Method method, Object[] args) {
        String methodName = method.getName();

        if (methodName.equals("is"))           return is(args);
        else if (methodName.startsWith("is"))  return is(methodName);
        else if (methodName.equals("get"))     return get(args);
        else if (methodName.startsWith("get")) return getX(methodName);
        else if (methodName.equals("invoke"))  return theOtherInvoke(args);

        throw new UnsupportedOperationException();
    }

    private Object is(Object[] args) {
        Object v = args[0];
        if (v instanceof Class<?>) {
            return many.is((Class<?>)v);
        } else if (v instanceof Integer) {
            return many.is((Integer)v);
        }
        throw new UnsupportedOperationException();
    }

    private Object is(String methodName) {
        int i = pick(methodName, "is");
        return many.is(i);
    }

    public Object get(Object[] args) {
        if (args != null && args.length == 1) {
            Object v = args[0];
            if (v instanceof Class<?>) {
                return many.get((Class<?>)v);
            } else if (v instanceof Integer) {
                return many.get((Integer)v);
            }
            throw new UnsupportedOperationException();
        } else {
            return many.get();
        }
    }

    private Object getX(String methodName) {
        int i = pick(methodName, "get");
        return many.get(i);
    }

    private int pick(String methodName, String prefix) {
        String suffix = violin.removePrefix(methodName, prefix);
        return suffix.charAt(0) - 'A';
    }

    @SuppressWarnings("unchecked")
    private Object theOtherInvoke(Object[] args) {
        Fn[] fns = getInvokeArgs(args);
        return many.invoke(fns);
    }

    private Fn[] getInvokeArgs(Object[] args) {
        if (arg1IsArray(args)) return (Fn[]) args[0];
        return arrayCaster.cast(Fn.class, args);
    }

    private boolean arg1IsArray(Object[] args) {
        return args.length == 1 && args[0].getClass().isArray();
    }
}
