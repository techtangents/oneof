package com.techtangents.oneof.types.value;

import com.techtangents.oneof.core.value.Validator;
import com.techtangents.oneof.invoke.Fn;

public class DefaultOneOfMany implements OneOfMany {

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

    public <Out> Out invoke(Fn<?, Out>[] args) {
        Fn<?, Out> arg = args[index];
        return asdf(arg);
    }

    @SuppressWarnings("unchecked")
    private <Out> Out asdf(Fn<?, Out> arg) {
        return (Out) ((Fn) arg).apply(o);
    }
}
