package com.techtangents.oneof.api;

import com.techtangents.oneof.types.type.*;
import com.techtangents.oneof.types.value.*;

public interface One {
    <A> OneOf1<A> nu(Object o, Class<A> classA);

    <A, B> OneOf2<A, B> nu(Object o, Class<A> classA, Class<B> classB);

    <A, B, C> OneOf3<A, B, C> nu(Object o, Class<A> classA, Class<B> classB, Class<C> classC);

    <A, B, C, D> OneOf4<A, B, C, D> nu(Object o, Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD);

    <A, B, C, D, E> OneOf5<A, B, C, D, E> nu(Object o, Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD, Class<E> classE);

    <A> OneOf1Type<A> of(Class<A> classA);

    <A, B> OneOf2Type<A, B> of(Class<A> classA, Class<B> classB);

    <A, B, C> OneOf3Type<A, B, C> of(Class<A> classA, Class<B> classB, Class<C> classC);

    <A, B, C, D> OneOf4Type<A, B, C, D> of(Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD);

    <A, B, C, D, E> OneOf5Type<A, B, C, D, E> of(Class<A> classA, Class<B> classB, Class<C> classC, Class<D> classD, Class<E> classE);
}
