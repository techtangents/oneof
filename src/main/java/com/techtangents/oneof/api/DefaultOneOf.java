package com.techtangents.oneof.api;

import com.techtangents.oneof.core.OneOfFactory;
import com.techtangents.oneof.iface.*;

public class DefaultOneOf implements OneOf {
    private final OneOfFactory f = new OneOfFactory();

    public <A> OneOf1 of(Object o, Class<A> classA) {
        return (OneOf1) f.make(o, OneOf1.class, classA);
    }

    public <A, B> OneOf2 of(Object o, Class<A> classA, Class<B> classB) {
        return (OneOf2) f.make(o, OneOf2.class, classA, classB);
    }

    public <A, B, C> OneOf3 of(Object o, Class<A> classA, Class<B> classB, Class<C> classC) {
        return (OneOf3) f.make(o, OneOf3.class, classA, classB, classC);
    }

    public <A, B, C, D> OneOf4 of(Object o, Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD) {
        return (OneOf4) f.make(o, OneOf4.class, classA, classB, classC, classD);
    }

    public <A, B, C, D, E> OneOf5 of(Object o, Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD, Class<E> classE) {
        return (OneOf5) f.make(o, OneOf5.class, classA, classB, classC, classD, classE);
    }
}
