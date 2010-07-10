package com.techtangents.oneof.types.value;

import com.techtangents.oneof.core.validator.Validator;
import com.techtangents.oneof.invoke.Fn;

public class DefaultOneOfMany implements OneOf {

    private final Validator validator = new Validator();

    private final Object o;
    private final Class[] clarses;
    private final int index;

    public DefaultOneOfMany(Object o, Class[] clarses) {
        this.o = o;
        this.clarses = clarses;
        index = validator.which(o.getClass(), clarses);
    }

    public Object get(int i) {
        Class<?> c = clarses[i];
        return get(c);
    }

    public <Z> Z get(Class<Z> c) {
        return c.cast(o);
    }

    public Object get() {
        return o;
    }

    public Object is(int i) {
        Class c = clarses[i];
        return is(c);
    }

    public boolean is(Class clarse) {
        validator.validateClass(clarse, clarses);
        return validator.isValidCast(o, clarse);
    }

    @SuppressWarnings("unchecked")
    public Object invoke(Fn[] args) {
        Fn arg = args[index];
        return arg.apply(o);
    }
}
