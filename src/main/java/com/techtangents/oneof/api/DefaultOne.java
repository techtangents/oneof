package com.techtangents.oneof.api;

import com.techtangents.oneof.core.types.OneOfTypeFactory;
import com.techtangents.oneof.core.value.OneOfValueFactory;
import com.techtangents.oneof.types.type.*;
import com.techtangents.oneof.types.value.*;

@SuppressWarnings("unchecked")
public class DefaultOne implements One {
    private final OneOfValueFactory vf = new OneOfValueFactory();
    private final OneOfTypeFactory tf = new OneOfTypeFactory();

    public <A> OneOf1<A> nu(Object o, Class<A> classA) {
        return (OneOf1<A>) vf.make(o, OneOf1.class, classA);
    }

    public <A, B> OneOf2<A, B> nu(Object o, Class<A> classA, Class<B> classB) {
        return (OneOf2<A, B>) vf.make(o, OneOf2.class, classA, classB);
    }

    public <A, B, C> OneOf3<A, B, C> nu(Object o, Class<A> classA, Class<B> classB, Class<C> classC) {
        return (OneOf3<A, B, C>) vf.make(o, OneOf3.class, classA, classB, classC);
    }

    public <A, B, C, D> OneOf4<A, B, C, D> nu(Object o, Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD) {
        return (OneOf4<A, B, C, D>) vf.make(o, OneOf4.class, classA, classB, classC, classD);
    }

    public <A, B, C, D, E> OneOf5<A, B, C, D, E> nu(Object o, Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD, Class<E> classE) {
        return (OneOf5<A, B, C, D, E>) vf.make(o, OneOf5.class, classA, classB, classC, classD, classE);
    }

    public <A> OneOf1Type<A> of(Class<A> classA) {
        return (OneOf1Type<A>) tf.make(OneOf1Type.class, OneOf1.class, classA);
    }

    public <A, B> OneOf2Type<A, B> of(Class<A> classA, Class<B> classB) {
        return (OneOf2Type<A, B>) tf.make(OneOf2Type.class, OneOf2.class, classA, classB);
    }

    public <A, B, C> OneOf3Type<A, B, C> of(Class<A> classA, Class<B> classB, Class<C> classC) {
        return (OneOf3Type<A, B, C>) tf.make(OneOf3Type.class, OneOf3.class, classA, classB, classC);
    }

    public <A, B, C, D> OneOf4Type<A, B, C, D> of(Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD) {
        return (OneOf4Type<A, B, C, D>) tf.make(OneOf4Type.class, OneOf4.class, classA, classB, classC, classD);
    }

    public <A, B, C, D, E> OneOf5Type<A, B, C, D, E> of(Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD, Class<E> classE) {
        return (OneOf5Type<A, B, C, D, E>) tf.make(OneOf5Type.class, OneOf5.class, classA, classB, classC, classD, classE);
    }

}


