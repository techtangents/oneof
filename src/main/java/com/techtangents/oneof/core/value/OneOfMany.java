package com.techtangents.oneof.core.value;

import com.techtangents.oneof.invoke.Fn;

public class OneOfMany {

    private final Validator validator = new Validator();

    private final Object o;
    private final Class[] clarses;
    private final int index;

    public OneOfMany(Object o, Class[] clarses) {
        this.o = o;
        this.clarses = clarses;
        index = validator.which(o.getClass(), clarses);
    }

    public Object get(int i) {
        Class c = clarses[i];
        return get(c);
    }

    public Object get(Class clarse) {
        validator.validateCast(o, clarse);
        return get();
    }

    public Object get() {
        return o;
    }

    public Object is(int i) {
        Class c = clarses[i];
        return is(c);
    }

    public Object is(Class clarse) {
        validator.validateClass(clarse, clarses);
        return validator.isValidCast(o, clarse);
    }

    public <Out> Out invoke(Fn<Object, Out>[] args) {
        Fn<Object, Out> arg = args[index];
        return arg.apply(o);
    }
}
