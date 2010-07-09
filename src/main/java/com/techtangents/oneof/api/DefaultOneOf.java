package com.techtangents.oneof.api;

import com.techtangents.oneof.core.OneOfFactory;
import com.techtangents.oneof.iface.*;

@SuppressWarnings("unchecked")
public class DefaultOneOf implements OneOf {
    private final OneOfFactory f = new OneOfFactory();

    public <A> OneOf1<A> nu(Object o, Class<A> classA) {
        return (OneOf1<A>) f.make(o, OneOf1.class, classA);
    }

    public <A, B> OneOf2<A, B> nu(Object o, Class<A> classA, Class<B> classB) {
        return (OneOf2<A, B>) f.make(o, OneOf2.class, classA, classB);
    }

    public <A, B, C> OneOf3<A, B, C> nu(Object o, Class<A> classA, Class<B> classB, Class<C> classC) {
        return (OneOf3<A, B, C>) f.make(o, OneOf3.class, classA, classB, classC);
    }

    public <A, B, C, D> OneOf4<A, B, C, D> nu(Object o, Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD) {
        return (OneOf4<A, B, C, D>) f.make(o, OneOf4.class, classA, classB, classC, classD);
    }

    public <A, B, C, D, E> OneOf5<A, B, C, D, E> nu(Object o, Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD, Class<E> classE) {
        return (OneOf5<A, B, C, D, E>) f.make(o, OneOf5.class, classA, classB, classC, classD, classE);
    }
}
