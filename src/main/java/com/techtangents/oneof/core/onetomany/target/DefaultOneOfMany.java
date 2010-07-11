package com.techtangents.oneof.core.onetomany.target;

import com.techtangents.oneof.core.hollar.Hollar;
import com.techtangents.oneof.core.validator.Validator;
import com.techtangents.oneof.invoke.Fn;
import com.techtangents.oneof.types.value.OneOf;

public class DefaultOneOfMany implements OneOf {

    private final Validator validator = new Validator();

    private final Object o;
    private final Class[] clarses;
    private final int index;
    private final Class actualClass;
    private final Hollar hollar = new Hollar();

    // don't instantiate directly - use a DefaultOne to get an instance
    public DefaultOneOfMany(Object o, Class[] clarses) {
        this.o = o;
        this.clarses = clarses;
        index = validator.which(o.getClass(), clarses);
        actualClass = clarses[index];
    }

    public Object get(int i) {
        validateIndex(i);
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
        validateIndex(i);
        return index == i;
    }

    private void validateIndex(int i) {
        if (i < 0 || i >= clarses.length) throw new IllegalArgumentException("OneOf does not have class # " + i);
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

    public <Out> Out marshall(Class<Out> returnType, Object invokee) {
        return hollar.marshall(returnType, invokee, actualClass, o);
    }
}
