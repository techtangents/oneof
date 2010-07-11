package com.techtangents.oneof.core.value;

import com.techtangents.arraymangler.bits.ArrayCaster;
import com.techtangents.arraymangler.bits.DefaultArrayCaster;
import com.techtangents.oneof.core.string.Violin;
import com.techtangents.oneof.invoke.Fn;
import com.techtangents.oneof.types.value.OneOf;

class Adapter {

    private final Violin violin = new Violin();
    private final ArrayCaster arrayCaster = new DefaultArrayCaster();

    private final OneOf many;

    public Adapter(OneOf many) {
        this.many = many;
    }

    public Object is(String methodName, Object[] args) {
        Object v = args[0];
        if (v instanceof Class<?>) {
            return many.is((Class<?>)v);
        } else if (v instanceof Integer) {
            return many.is((Integer)v);
        }
        throw new UnsupportedOperationException();
    }

    public Object isX(String methodName, Object args) {
        int i = pick(methodName, "is");
        return many.is(i);
    }

    public Object get(String methodName, Object[] args) {
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

    public Object getX(String methodName, Object[] args) {
        int i = pick(methodName, "get");
        return many.get(i);
    }

    private int pick(String methodName, String prefix) {
        String suffix = violin.removePrefix(methodName, prefix);
        return suffix.charAt(0) - 'A';
    }

    @SuppressWarnings("unchecked")
    public Object invoke(String methodName, Object[] args) {
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

    public Object marshall(String methodName, Object[] args) {
        Class<?> returnType = (Class<?>) args[0];
        Object invokee = args[1];
        return many.marshall(returnType, invokee);
    }
}
